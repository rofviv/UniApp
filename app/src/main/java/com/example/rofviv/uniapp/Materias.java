package com.example.rofviv.uniapp;

public class Materias {
    private int id;
    private String materia, descripcion, semestre, docente, dia_horario, aula;

    public Materias(int id, String materia, String descripcion, String semestre, String docente, String dia_horario, String aula) {
        this.id = id;
        this.materia = materia;
        this.descripcion = descripcion;
        this.semestre = semestre;
        this.docente = docente;
        this.dia_horario = dia_horario;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getDia_horario() {
        return dia_horario;
    }

    public void setDia_horario(String dia_horario) {
        this.dia_horario = dia_horario;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
