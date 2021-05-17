package com.imdb.service.impl;

import com.imdb.entity.NameBasic;
import com.imdb.exception.OutOfKevinBaconNetworkException;
import com.imdb.exception.ServiceNotReadyException;
import com.imdb.exception.TitleNotFoundException;
import com.imdb.repository.NameBasicRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.imdb.util.Consts.*;
import static com.imdb.util.InMemoryCheckValues.IS_TITLE_MAP_READY;

/**
 * @developer -- ilkercolakoglu
 */
@Service
public class NameBasicService {

    private final NameBasicRepository nameBasicRepository;

    public NameBasicService(NameBasicRepository nameBasicRepository) {
        this.nameBasicRepository = nameBasicRepository;
    }

    Map<String, Set<String>> titleMap = new HashMap<>();
    Set<String> kevinTitleSet = new HashSet<>();
    Set<String> visitedSet = new HashSet<>();
    int degree = 1;

    /**
     * https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon
     * finding bacon number by the rule set that is explained in the Wikipedia link above.
     *
     * @param actorName
     * @return
     * @throws ServiceNotReadyException
     * @throws TitleNotFoundException
     * @throws OutOfKevinBaconNetworkException
     */
    public int findDegreesOfKevinBacon(String actorName)
            throws ServiceNotReadyException, TitleNotFoundException, OutOfKevinBaconNetworkException {
        if (!IS_TITLE_MAP_READY) throw new ServiceNotReadyException(SERVICE_NOT_READY_EXCEPTION);

        if (actorName.equals(KEVIN_BACON)) return 0; // Kevin Bacon himself has a Bacon number of 0.

        degree = 1; // Those actors who have worked directly with Kevin Bacon have a Bacon number of 1.
        visitedSet.clear();

        fillActorSet(KEVIN_BACON, kevinTitleSet);
        Set<String> actorTitleSet = fillActorSet(actorName, new HashSet<>());

        findDegree(actorTitleSet);

        return degree;
    }

    /**
     * titles comparison as recursively until finding same title in Kevin Title Set
     * each recursion a new set is filled using titleMap
     *
     * @param actorTitleSet
     * @throws OutOfKevinBaconNetworkException
     */
    private void findDegree(Set<String> actorTitleSet) throws OutOfKevinBaconNetworkException {
        if (actorTitleSet.size() == 0) throw new OutOfKevinBaconNetworkException(OUT_OF_KEVIN_BACON_NETWORK_EXCEPTION);

        Set<String> insideSet = new HashSet<>();

        boolean actedTogether = checkIfContainsKevinTitles(actorTitleSet);
        if (actedTogether) {
            return;
        }

        visitedSet.addAll(actorTitleSet);

        for (String title : actorTitleSet) {
            insideSet.addAll(titleMap.get(title));
        }

        insideSet.removeAll(visitedSet);

        degree++;
        findDegree(insideSet);
    }

    /**
     * title comparison actorTitleSet vs KevinTitleSet
     *
     * @param actorTitlesSet
     * @return
     */
    private boolean checkIfContainsKevinTitles(Set<String> actorTitlesSet) {
        int initial = kevinTitleSet.size();
        kevinTitleSet.removeAll(actorTitlesSet);
        int finalValue = kevinTitleSet.size();

        return initial != finalValue;
    }

    /**
     * all titles has been obtained and a map has been created like key = title value = relatedTitleSet
     * all titles that are related are combined in this map.
     * If an actor(A) appears in 2 titles(X,Y), these titles are related
     * If an actor(B) appears in 2 titles(X,Z), these titles are related
     * map occurs like that
     * X --> (X,Y,Z)
     * Y --> (X)
     * Z --> (X)
     */
    @Async
    public void fillTitleMap() {

        List<NameBasic> nameBasicList = nameBasicRepository.findByKnownForTitlesIsNotNullAsActorsAndActress();

        for (NameBasic nameBasic : nameBasicList) {

            String[] titleArray = nameBasic.getKnownForTitles().split(",");
            Set<String> titleSet = new HashSet<>(Arrays.asList(titleArray));

            for (String title : titleArray) {
                if (titleMap.containsKey(title)) {
                    Set<String> currSet = titleMap.get(title);
                    currSet.addAll(titleSet);
                    titleMap.put(title, currSet);
                } else {
                    titleMap.put(title, titleSet);
                }
            }
        }

        IS_TITLE_MAP_READY = true;
    }

    /**
     * creating title set for an actor
     *
     * @param actorName
     * @param actorTitleSet
     * @return
     * @throws TitleNotFoundException
     */
    private Set<String> fillActorSet(String actorName, Set<String> actorTitleSet) throws TitleNotFoundException {
        List<NameBasic> actors = nameBasicRepository.findByPrimaryNameAsActorOrActress(actorName);
        List<NameBasic> nameBasicList = actors.stream()
                .filter(nameBasic -> nameBasic.getKnownForTitles() != null).collect(Collectors.toList());
        if (nameBasicList.size() == 0)
            throw new TitleNotFoundException(TITLE_NOT_FOUND_AS_ACTOR_ACTRESS_EXCEPTION_MESSAGE);

        actors.stream().filter(nameBasic -> nameBasic.getKnownForTitles()!=null).map(actor -> Arrays.stream(actor.getKnownForTitles().split(","))
                .map(actorTitleSet::add).collect(Collectors.toList())).collect(Collectors.toList());
        return actorTitleSet;
    }

}
