package ionsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPeca {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(Peca peca){
        String sql="insert into peca"
                + "(Cod_Peca, Descricao, Preco) values(?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, peca.getCod_Peca());
            qry.setString(2, peca.getDescricao());
            qry.setFloat(3, peca.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String num){
        String sql="delete from peca" + " where Cod_Peca = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Peca peca, String num){
        String sql="update peca set Cod_Peca = ?, Descricao = ?, Preco = ? where Cod_Peca = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, peca.getCod_Peca());
            qry.setString(2, peca.getDescricao());
            qry.setFloat(3, peca.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Peca> ListarTodasPecas(){
        String sql = "select Cod_Peca, Descricao, Preco from peca";
        con = conexao.getconexao();
        ArrayList<Peca> pecas = new ArrayList<Peca>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Peca a = new Peca();
                a.setCod_Peca(rs.getInt("Cod_Peca"));
                a.setDescricao(rs.getString("Descricao"));
                a.setPreco(rs.getFloat("Preco"));
                pecas.add(a);
            }
            return pecas;
        } catch (SQLException ex){
            Logger.getLogger(DAOPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
