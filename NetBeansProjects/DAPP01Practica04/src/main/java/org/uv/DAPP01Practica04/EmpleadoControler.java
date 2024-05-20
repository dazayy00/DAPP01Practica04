package org.uv.DAPP01Practica04;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoControler {
    
    @Autowired
    private EmpleadoRepository repositoryEmpleado;
    
    @GetMapping("/empleado/")
    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }
    
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> get(@PathVariable Long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent()) 
            return ResponseEntity.ok(optEmpleado.get());
         else 
            return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Empleado empleado) {
    Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
    if (optEmpleado.isPresent()) {
        Empleado existingEmployee = optEmpleado.get();

        existingEmployee.setNombre(empleado.getNombre());
        existingEmployee.setDireccion(empleado.getDireccion());
        existingEmployee.setTelefono(empleado.getTelefono());  
        repositoryEmpleado.save(existingEmployee);
        
        return ResponseEntity.noContent().build(); 
    } else {
        return ResponseEntity.notFound().build(); 
    }
}
    @PostMapping("/empleado/")
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = repositoryEmpleado.save(empleado);
        return ResponseEntity.ok(savedEmpleado);
    }
    
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repositoryEmpleado.deleteById(id);
        return ResponseEntity.noContent().build(); 
    } 
}
