package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOOs {
    private Connection con;
    private PreparedStatement qry;
    private int codOS = 1;
    
    public int CodMax(){
        String sql = "SELECT max(COD_OS) FROM os";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            if(rs.next()){
                 codOS = rs.getInt(1)+1;
                 return codOS;
            }else{
                return codOS;
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void salvarOS(Os os){
        String sql="insert into os "
                + "(Cod_Os,Cod_Cliente,Cod_Funcionario,Cod_Equipamento,Data_Ent,Data_Saida,Situacao,Valor_Servicos, Valor_Pecas, Valor_Outros, Valor_Total) values(?,?,?,?,?,?,?,?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, os.getCodigo());
            qry.setInt(2, os.getCod_Cliente());
            qry.setInt(3, os.getCod_Funcionario());
            qry.setInt(4, os.getCod_Equip());
            qry.setDate(5, new java.sql.Date(
                        os.getDataEnt().getTimeInMillis()));
            qry.setDate(6, new java.sql.Date(
                        os.getDataSaida().getTimeInMillis()));
            qry.setString(7, os.getSituacao());
            qry.setFloat(8, os.getValor_Serv());
            qry.setFloat(9, os.getValor_Pecas());
            qry.setFloat(10, os.getValor_Outros());
            qry.setFloat(11, os.getValor_Total());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarItemServ(ItemOsServ ItServ){
        String sql="insert into item_os_serv"
                + "(Cod_os2,Cod_Serv,Descricao,Preco) values(?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, ItServ.getCod_OS_Serv());
            qry.setInt(2, ItServ.getCod_Serv());
            qry.setString(3, ItServ.getDescricao());
            qry.setFloat(4, ItServ.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvarItemPeca(ItemOsPeca ItPeca){
        String sql="insert into item_os_peca"
                + "(Cod_os1,Cod_Peca,Descricao,Preco) values(?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, ItPeca.getCod_OS1());
            qry.setInt(2, ItPeca.getCod_Peca());
            qry.setString(3, ItPeca.getDescricao());
            qry.setFloat(4, ItPeca.getPreco());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Os os, String num){
        String sql="update os set Cod_Os = ?,Cod_Cliente = ?,Cod_Funcionario = ?,Cod_Equipamento = ?,Data_Ent = ?,Data_Saida = ?,Situacao = ?,Valor_Servicos = ?, Valor_Pecas = ?, Valor_Outros = ?, Valor_Total = ? where Cod_Os = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, os.getCodigo());
            qry.setInt(2, os.getCod_Cliente());
            qry.setInt(3, os.getCod_Funcionario());
            qry.setInt(4, os.getCod_Equip());
            qry.setDate(5, new java.sql.Date(
                        os.getDataEnt().getTimeInMillis()));
            qry.setDate(6, new java.sql.Date(
                        os.getDataSaida().getTimeInMillis()));
            qry.setString(7, os.getSituacao());
            qry.setFloat(8, os.getValor_Serv());
            qry.setFloat(9, os.getValor_Pecas());
            qry.setFloat(10, os.getValor_Outros());
            qry.setFloat(11, os.getValor_Total());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void excluir(String num){
        String sql="delete from Equipamento" + " where Cod_Equipamento = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public ArrayList<Os> ListarTodasOs(){
        String sql = "select Cod_Os, Cod_Cliente, Cod_Funcionario, Cod_Equipamento, Data_Ent, Data_Saida, Situacao, Valor_Servicos, Valor_Pecas, Valor_Outros, Valor_Total from os";
        con = conexao.getconexao();
        ArrayList<Os> Oss = new ArrayList<Os>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Os a = new Os();
                a.setCodigo(rs.getInt("Cod_Os"));
                a.setCod_Cliente(rs.getInt("Cod_Cliente"));
                a.setCod_Funcionario(rs.getInt("Cod_Funcionario"));
                a.setCod_Equip(rs.getInt("Cod_Equipamento"));
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(rs.getDate("Data_Ent").getTime());
                a.setDataEnt(cal);
                cal.setTimeInMillis(rs.getDate("Data_Saida").getTime());
                a.setDataSaida(cal);
                a.setSituacao(rs.getString("Situacao"));
                a.setValor_Serv(rs.getFloat("Valor_Servicos"));
                a.setValor_Pecas(rs.getFloat("Valor_Pecas"));
                a.setValor_Outros(rs.getFloat("Valor_Outros"));
                a.setValor_Total(rs.getFloat("Valor_Total"));
                Oss.add(a);
            }
            return Oss;
        } catch (SQLException ex){
            Logger.getLogger(DAOOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
