package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado implements IDAOGeneral<PojoEmpleado, Integer>{

    @Override
    public boolean guardar(PojoEmpleado pojo) {
       ConexionDB con=ConexionDB.getInstance();
       
       TransactionDB tra=new TransactionDB(pojo){
           @Override
           public boolean execute(Connection con){
               try {
                   String sql="insert into empleadostemporal (clave, nombre, direccion) values (?, ?, ?)";
                   PreparedStatement pstm=con.prepareStatement(sql);
                   pstm.setString(1, pojo.getNombre());
                   pstm.setString(2, pojo.getDireccion());
                   pstm.setString(3, pojo.getTelefono());
                   pstm.execute();
                   return true;
               } catch (SQLException ex) {
                   Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                   return false;
               }
           
           }
       };
       return con.execute(tra);
    
    }

    @Override
    public boolean modificar(PojoEmpleado pojo, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PojoEmpleado buscarById(Integer id) {
        SelectionDB select=new SelectionDB() {
           @Override
            public List find(Connection con) {
                try {
                    String sql="select * from empleados temporal";
                    PreparedStatement pstm=con.prepareStatement(sql);
                    ResultSet reg=pstm.executeQuery();
                    List lst =new ArrayList<PojoEmpleado>();
                    while(reg.next()) {
                        PojoEmpleado p=new PojoEmpleado();
                        p.setId(reg.getId(1));
                        p.setNombre(reg.getNombre(2));
                        p.setDireccion(reg.getDireccion(2));
                        p.setTelefono(reg.getTelefono(2));
                        lst.add(p);
                    }
                    
                    return lst;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        };
        ConexionDB con=ConexionDB.getInstance();
        List lst=con.select(select);
        PojoEmpleado empleado=(PojoEmpleado)lst.get(0);
        return empleado;
    }

    @Override
    public List<PojoEmpleado> buscarALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
