/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restfull_client_registry;

import java.util.Date;

/**
 *
 * @author Virgilio
 */
public class User {

    private long Id;

    private String Name;

    private String LastName;

    private int Cedula;

    private String FechaNacimiento;

    private String Directory;

    private String Phone;

    private String Mail;

    public User(long id, String Nombre, String Apellido, String Cedula, String Fecha, String Directorio, String Telefono, String Correo) {

        this.Id = id;
        this.Name = Nombre;
        this.LastName = Apellido;
        this.Cedula = Integer.parseInt(Cedula);
        this.FechaNacimiento =  Fecha;
        this.Directory = Directorio;
        this.Phone = Telefono;
        this.Mail = Correo;

    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDirectory() {
        return Directory;
    }

    public void setDirectory(String Directory) {
        this.Directory = Directory;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    
    
}
