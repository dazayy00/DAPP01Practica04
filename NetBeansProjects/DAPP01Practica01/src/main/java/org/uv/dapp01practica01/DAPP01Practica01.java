package org.uv.dapp01practica01;

import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAPP01Practica01 {

    public static void main(String[] args) {
//        try {
//            String url="jdbc:postgresql://localhost:5432/ejemplo";
//            String usr="postgres";
//            String pwd="postgres";
//            Connection con = DriverManager.getConnection(url, usr, pwd);
//                    
//                    System.out.println("Se conecto");
//        } catch (SQLException ex) {
//            Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.SEVERE, null, ex);
//        }
        SessionFactory sf = HibernateUtil.getsessionFactory();
        PojoEmpleado empleado = new PojoEmpleado();
        empleado.setNombre("dazayy");
        empleado.setDireccion("los alamos");
        empleado.setTelefono("2721010384");
        
        Session SessionFactory = sf.getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(empleado);
        transaction.commit();
        System.out.println("Se guardo con ID" + empleado.getId());
        
    }
}
