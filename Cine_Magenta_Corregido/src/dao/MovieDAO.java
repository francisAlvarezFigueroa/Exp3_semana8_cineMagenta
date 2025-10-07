/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 import java.sql.*; 
import java.util.ArrayList; 
import java.util.List; 
import model.Movie; 

// metodos CRUD

/**
 *
 * @author Francis
 */
public class MovieDAO {
    
    public boolean create (Movie movie){
        String sql = "INSERT into cartelera (titulo, director, anio, duracion, genero) VALUES(?, ?, ?, ?, ?)";
       // try-with-resources 
        try (Connection connect = DBConnection.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql)) {
            // replace ? with movie values
            
            ps.setString(2, movie.getTitulo()); 
            ps.setString(3, movie.getDirector()); 
            ps.setInt(4, movie.getAnio()); 
            ps.setInt(5, movie.getDuracion()); 
            ps.setString(6, movie.getGenero()); 
            
            return ps.executeUpdate() ==1; // return number of lines, return 1 if true 
            
        } catch (SQLException e){
            System.out.println("Error create (): " + e.getMessage()); 
            return false; 
            
           
        }
    }
    
    public List <Movie> addToList (){
        List<Movie> movies = new ArrayList<>();
        
        //SQL query 
        
        String sql = "SELECT id, titulo, director, anio, duracion, genero FROM cartelera ORDER BY id"; // TODO: check the "Movies" reference 
        try (Connection connect = DBConnection.getConnection(); // gets the connections to BD
                Statement st = connect.createStatement(); // create a statement to execute 
                ResultSet rs = st.executeQuery(sql)) {  // se debe recorrer execute query
            while(rs.next()){
                movies.add(new Movie(
                rs.getInt("id"), 
                rs.getString("titulo"),
                rs.getString("director"),
                rs.getInt("anio"), 
                rs.getInt("duracion"),
                rs.getString("genero")
                ));        
            }
            }catch (SQLException e){
                System.out.println("Error list (): " + e.getMessage());
            }
        return movies; //return the movies list with all the added movies 
        }
    
    public List <Movie> searchByTitle(String pattern){
        List<Movie> out = new ArrayList<>();
        String sql = "SELECT id, titulo, director, anio, duracion, genero FROM cartelera WHERE titulo LIKE ? ORDER BY id"; 
        try(Connection connect = DBConnection.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql)){
            ps.setString (1,"%" + pattern + "%");
            
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    out.add(new Movie(
                    rs.getInt("id"), 
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getInt("anio"),
                    rs.getInt("duracion"),
                    rs.getString("genero")
                    ));
                }
            }
        }catch (SQLException e){
            System.out.println ("Error searchByTitle(): " + e.getMessage());
        }
          return out;
    }
    
    
    public boolean update (Movie m){
        String sql = "UPDATE cartelera SET titulo = ?, director=?, anio=?, duracion=?, genero=? WHERE id=?";
        try (Connection connect = DBConnection.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql)){
            
            // new values
            
           ps.setString(1, m.getTitulo());
           ps.setString(2, m.getDirector());
           ps.setInt(3, m.getAnio());
           ps.setInt(4, m.getDuracion());
           ps.setString (5, m.getGenero()); 
           
           return ps.executeUpdate() ==1;
        } catch (SQLException e){
            System.out.println("Error update(): " +  e.getMessage());
            return false; 
        }        
                
    }
    
    public boolean delete (int id){
        String sql = "DELETE FROM cartelera WHERE id =?"; 
        
        try (Connection connect =DBConnection.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql)){
            ps.setInt(1, id); // connects with the id of movie to delete
            return ps.executeUpdate() ==1; 
            
        }catch(SQLException e){
        System.out.println("Error delete(): " + e.getMessage());
        return false;
        }
    }
  
    
    
}
