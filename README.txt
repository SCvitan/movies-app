READ ME!

1. Open a console and navigate to a folder where "movie-CRUD-service.jar" is located.
2. Type "java -jar movie-CRUD-service.jar" into console and server should start on http://localhost:8080
3. Now you can perform some API calls, since there is no user interface, I used Postman.
4. Lets first save few movies with:
    http://localhost:8080/v1/movie/save - POST method

    {
        "title" : "Matrix",
        "date" : "1999-08-26",
        "rank" : "8.7",
        "revenue":"63000000"
        }

    {

        "title":"Apocalypse Now",
        "date":"1979-08-15",
        "rank":"8.5",
        "revenue":"31000000"
    }

    {

        "title":"Blade Runner",
        "date":"1982-07-25",
        "rank":"8.1",
        "revenue":"30000000"
    }

  We can add as many movies as we want.

5. We can fetch all movies:
        http://localhost:8080/v1/movie/all  with GET method

6. We can fetch movie by movieId:
        http://localhost:8080/v1/movie/{id} with GET method

7. We can delete movie by movieId:
        http://localhost:8080/v1/movie/{id} with DELETE method

8. We can update movies by movieId:
        http://localhost:8080/v1/movie/update/{id} with PUT method

9. We can fetch movies filtered by launch date:
        http://localhost:8080/v1/movie/filter with GET method
