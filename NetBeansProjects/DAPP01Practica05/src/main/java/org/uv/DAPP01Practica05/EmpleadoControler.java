package org.uv.DAPP01Practica05;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Empleado get(@PathVariable Long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent())
            return optEmpleado.get();
        else
            return null;
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> optionalEmpleado = repositoryEmpleado.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado existingEmpleado = optionalEmpleado.get();
            existingEmpleado.setNombre(empleado.getNombre()); 
            existingEmpleado.setDireccion(empleado.getDireccion());
            existingEmpleado.setTelefono(empleado.getTelefono());
            repositoryEmpleado.save(existingEmpleado);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/empleado/")
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        repositoryEmpleado.save(empleado);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repositoryEmpleado.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
