$(document).ready(function() {

    addIndividualMovies();
    addUserWithMostComments();
    addMovieWithHighestLikes();

});

function addMovieWithHighestLikes(){

    $.get("movieWithHighestLikes",
        function(data,status){

            addMovieElement("likes", "p", "" , data);
        });
}

function addUserWithMostComments(){

    $.get("userWithMostComments",
        function(data,status){
            addMovieElement("comments", "p", "" , data);
        });
}

function addIndividualMovies(){

    $.get("individualMovies",
        function(data,status){

        for(var i = 0; i < Object.keys(data).length; i++){
            addMovieElement("movies", "h3", "", data[i].title);
            addMovieElement("movies", "p", "Description: ", data[i].description);
            addMovieElement("movies", "p", "Producer: ", data[i].producer);
            addMovieElement("movies", "p", "Available in 3D?: ", data[i].availableIn3d);
            addMovieElement("movies", "p", "Age Rating: ", data[i].ageRating);
            addMovieElement("movies", "p", "likes: ", data[i].likes);
            addMovieElement("movies", "h5", "Comments","");
            addMovieElement("movies", "hr", "", "");

            for(var j = 0; j < Object.keys(data[i].comments).length; j++){
                addMovieElement("movies", "p", "", data[i].comments[j].user + ": " + data[i].comments[j].message);
                addMovieElement("movies", "p", "", data[i].comments[j].dateCreated);
                addMovieElement("movies", "p", "Likes: ", data[i].comments[j].like);
                addMovieElement("movies", "hr", "", "");
            }

        }
    });
}

function addMovieElement(elementId, element, heading, text){

    var para = document.createElement(element);
    var value = heading + text;
    var node = document.createTextNode(value);
    para.appendChild(node);

    var element = document.getElementById(elementId);
    element.appendChild(para);

}