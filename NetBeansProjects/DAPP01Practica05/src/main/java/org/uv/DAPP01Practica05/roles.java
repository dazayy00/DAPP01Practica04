package org.uv.DAPP01Practica05;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class roles implements Serializable {

    @Id
    @GeneratedValue(generator = "rol_clave_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rol_clave_seq", sequenceName = "rol_clave_seq", initialValue = 1, allocationSize = 1)
    private long clave;
    private String nombre;

    @ManyToMany
    @JoinTable(name = "empleado_rol",
            joinColumns = @JoinColumn(name = "empleado_clave"),
            inverseJoinColumns = @JoinColumn(name = "rol_clave"))
    private Set<Empleado> empleado = new HashSet<>();

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

    public Set<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Set<Empleado> empleado) {
        this.empleado = empleado;
    }

    
}

