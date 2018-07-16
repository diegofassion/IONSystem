package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOServico {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(Servico servico){
        String sql="insert into servico"
                + "(Cod_Servico, Descricao, Preco) values(?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, servico.getCodigo());
            qry.setString(2, servico.getDescricao());
            qry.setFloat(3, servico.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String num){
        String sql="delete from servico" + " where Cod_Servico = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Servico servico, String num){
        String sql="update servico set Cod_Servico = ?, Descricao = ?, Preco = ? where Cod_Servico = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, servico.getCodigo());
            qry.setString(2, servico.getDescricao());
            qry.setFloat(3, servico.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Servico> ListarTodosServicos(){
        String sql = "select Cod_Servico, Descricao, Preco from servico";
        con = conexao.getconexao();
        ArrayList<Servico> Servicos = new ArrayList<Servico>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Servico a = new Servico();
                a.setCodigo(rs.getInt("Cod_Servico"));
                a.setDescricao(rs.getString("Descricao"));
                a.setPreco(rs.getFloat("Preco"));
                Servicos.add(a);
            }
            return Servicos;
        } catch (SQLException ex){
            Logger.getLogger(DAOServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
