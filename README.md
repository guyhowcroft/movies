# Movies

Run: This project can be run from Eclipse or Intellij

Go to http://localhost:8080/ to see the webpage
      
      - API calls -
                - http://localhost:8080/movies - All structured data
                - http://localhost:8080/individualMovies - Individual Movie Data Records
                - http://localhost:8080/userWithMostComments - The user who has added the most comments across all movies
                - http://localhost:8080/movieWithHighestLikes - The movie with the highest sum of likes

**Notes:**

Currently Data will be read once from the JSON file. This is more efficient than reading the JSON file everytime the API is called.

In the future could add code to check if the JSON file has changed and then to read the data again.
