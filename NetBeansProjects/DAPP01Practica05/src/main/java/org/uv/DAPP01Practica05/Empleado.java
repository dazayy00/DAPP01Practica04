package org.uv.DAPP01Practica05;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
      
    @Id
    @GeneratedValue(generator = "empleado_clave_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "empleado_clave_seq", sequenceName = "empleado_clave_seq", initialValue = 1,allocationSize =1)
    private long clave;
    private String nombre;
    private String direccion;
    private String telefono;

    @ManyToMany(mappedBy = "empleado")
    private Set<roles> roles = new HashSet<>();
    
    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
