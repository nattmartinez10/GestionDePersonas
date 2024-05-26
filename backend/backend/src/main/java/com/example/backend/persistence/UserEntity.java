package com.example.backend.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas", schema = "personas_crud")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;
    private String numdoc;
    private String nombre;
    private String segundo_nombre;
    private String apellidos;
    private String f_nacimiento;
    private String genero;
    private String correo;
    private String celular;
    private String foto;

    // Constructor with all fields
    public UserEntity(String tipo, String numdoc, String nombre, String segundo_nombre, String apellidos, String f_nacimiento, String genero, String correo, String celular, String foto) {
        this.tipo = tipo;
        this.numdoc = numdoc;
        this.nombre = nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellidos = apellidos;
        this.f_nacimiento = f_nacimiento;
        this.genero = genero;
        this.correo = correo;
        this.celular = celular;
        this.foto = foto;
    }

    // Default constructor
    public UserEntity() {
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public String getFoto() {
        return foto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

