/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.MovieDAO;
import model.Movie;
import java.util.List; 
//comments

/**
 *
 * @author Francis
 */
public class Controller {
    private final MovieDAO dao = new MovieDAO();  // instance
    
    // get contacts form dao  
    public List<Movie> addToList(){
        return dao.addToList(); 
    }
    
    public List <Movie> searchByTitle (String pattern){
        if(pattern==null) pattern = "";
        return pattern.isBlank() ? dao.addToList() : dao.searchByTitle(pattern);
    }
    
    public boolean create (Movie movie){
       return dao.create(movie);  
    }
    
    public String verify(String title, String director){
        if(title==null || title.isBlank()) return "You must enter a movie title";
        if(director ==null || director.isBlank()) return "You must enter a movie director"; 
   return null;  // it must have at least name of the movie and director to be created 
    }
    
    public boolean update (Integer id, String title, String director, Integer year, Integer duration, String genre){
        // verify if movie exists 
        if(id==null) return false; 
        
        // validate new data 
        String v= verify(title, director); 
        if(v!=null) return false; 
        
      // update the  movie information 
      return dao.update(new Movie (id, title, director, year,duration, genre));
             
    }
   
    
    public boolean delete (Integer id){
        //check if a movie was selected 
        if(id==null) return false; 
        
        //delete movie
        return dao.delete(id);
    }
}
