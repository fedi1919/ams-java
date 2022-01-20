package com.epi.ams.entities;

public class Candidat {

    private int id;
    private String nom;
    private String email;
    private String tel;

    public Candidat(int id, String nom, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
    }

    public Candidat() {}

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    // getters
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public String getEmail(){
        return email;
    }
    public String getTel(){
        return tel;
    }

    //setters
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTel(String tel){
        this.tel = tel;
    }


}
