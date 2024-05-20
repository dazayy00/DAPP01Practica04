package org.uv.DAPP01Practica05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository  extends JpaRepository<Empleado, Long>{
    
}
