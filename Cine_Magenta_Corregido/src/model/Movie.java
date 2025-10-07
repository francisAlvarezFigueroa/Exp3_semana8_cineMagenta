/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Francis
 */
public class Movie {
    
 
    private Integer id; 
    private String titulo; 
    private String director; 
    private int anio; 
    private int duracion; // in minutes 
    private String genero; 
    
    public Movie (){}  // default 
    
    public Movie (Integer id, String title, String director, int year, int duration, String genre){ // parametrized
        this.id=id; 
        this.titulo=title; 
        this.director=director; 
        this.anio=year; 
        this.duracion=duration; 
        this.genero=genre; 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Movie (String title, String director, int year, int duration, String genre){
        this(null, title, director, year, duration, genre);  // id will be assigned automatically
    }
    
    
    
    
    
    
   
   
}
