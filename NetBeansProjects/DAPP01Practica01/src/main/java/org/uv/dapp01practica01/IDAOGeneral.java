package org.uv.dapp01practica01;

import java.util.List;

public interface IDAOGeneral<T, ID> {
    public boolean guardar(T pojo);
    public boolean modificar(T pojo, ID id);
    public boolean eliminar(ID id);
    
    public T buscarById(ID id);
    public List<T> buscarALL();
    
}
