package org.uv.dapp01practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private static ConexionDB cx=null;
    public static ConexionDB getInstance(){
        if(cx==null)
            cx=new ConexionDB();
        return cx;
    }
    
    private Connection con=null;
    private  ConexionDB(){
        try {
            String url="jdbc:postgresql://localhost:5432/ejemplo";
            String usr="postgres";
            String pwd="postgres";
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean execute(String sql){
        try {
            Statement st=con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean execute(TransactionDB tra){
        return tra.execute(con);
    }
    
    public List select(SelectionDB select){
        return select.find(id);
    }
}
 