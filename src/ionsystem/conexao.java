package ionsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexao {
    private static final String
    drive = "com.mysql.jdbc.Driver",
    url = "jdbc:mysql://localhost/ion",
    usuario = "root",
    senha = "1203";
    public static Connection getconexao(){
        try{
            
            Class.forName(drive);
            return DriverManager.getConnection(url,usuario,senha);
            
        }catch (ClassNotFoundException ex){
            throw new RuntimeException("Erro na conexão", ex);
            //Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void fechar(Connection c){
        if (c !=null){
            try {
                c.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
                //Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void fechar(Connection c, PreparedStatement qry){
        if(c!=null)
            try{
                c.close();
            }catch(SQLException ex){
                Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, url);
            }
        if(qry !=null)
            try{
                qry.close();
            }catch (SQLException ex){
                Logger.getLogger(conexao.class.getName()).log(Level.SEVERE, url);
            }
    }
}