package com.imdb.util;

import static com.imdb.util.Consts.L;

/**
 * @developer -- ilkercolakoglu
 */
public class ImdbAPIProviderUtil {

    public static String createLikeQueryForField(String fieldValue) {
        return L + fieldValue + L;
    }
}
