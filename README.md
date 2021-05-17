# lunatech-imdb-assessment-template

# MICRO IMDB API PROVIDER

# Description and Tech Stack
This project has been created for providing API for imdb data. 

You should be able to start the example application by executing com.imdb.MicroImdbApplication,
which starts a webserver on port 8089 (http://localhost:8089) and serves SwaggerUI where can inspect and try existing endpoints.

The project is based on a web service which uses the following technologies:

* Java 1.8
* Spring Boot(data,restful services)
* PostgreSQL
* Maven
  
  Libs
* MapStruct
* Lombok


To solve demands of tasks;

3 REST API has been designed.

#REST APIs

* /title/search
* /title/top_rated_movies_by_genre/{genre}/{top}
* /names/get_degrees_of_kevin_bacon


## /title/search
method: POST
request: {
"originalTitle": null,
"primaryTitle": "Hamlet"
}

can be searched titles by giving original/primary title.

## /title/top_rated_movies_by_genre/{genre}/{top}
method: GET
request : /title/top_rated_movies_by_genre/Horror/50

can getting as many top movies as you want between 1 and 1000 depending on the categories


## /names/get_degrees_of_kevin_bacon
method: POST
actor: {actor/actress name that you want to find bacon's number}

API is built according to Six Degrees of Kevin Bacon. --> https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon


# Build and Run It
Although all my tests run successfully, it occurs a problem during compiling project.
That's why please use '-DskipTests=true' when compile the project.
And also I created DockerFile but it doesn't run successfully because of same reason.

After you download the project you can maven clean install -DskipTests=true and run MicroImdbApplication.java class



Tests take time to prepare service of Kevin Bacon. It should prepare title map.

Before title map is ready, IS_TITLE_MAP_READY value must be false.
As soon as title map is ready, Kevin Bacon service is ready to call.

OR

you can also run it in a docker container with the commands below:

* docker build -t micro_imdb_api .
* docker run -p 8089:8089 --name micro_imdb_api micro_imdb_api
