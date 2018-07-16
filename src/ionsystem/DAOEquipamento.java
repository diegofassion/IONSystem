package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEquipamento {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(Equipamento equipamento){
        String sql="insert into equipamento"
                + "(Cod_Equipamento,Marca,Modelo,Serie,Descricao,Observacao,Cod_Tipo_Equip,Cod_Cliente) values(?,?,?,?,?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, equipamento.getCod_Equip());
            qry.setString(2, equipamento.getMarca());
            qry.setString(3, equipamento.getModelo());
            qry.setString(4, equipamento.getSerie());
            qry.setString(5, equipamento.getDescricao());
            qry.setString(6, equipamento.getObs());
            qry.setInt(7, equipamento.getTipoEquip());
            qry.setInt(8, equipamento.getCod_Cliente());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void editar(Equipamento equipamento, String num){
        String sql="update Equipamento set Cod_Equipamento = ?, Marca=?, Modelo=? ,Serie=? ,Descricao=? ,Observacao=? ,Cod_Cliente=? ,Cod_Tipo_Equip=? , where Cod_Equipamento = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, equipamento.getCod_Equip());
            qry.setString(2, equipamento.getMarca());
            qry.setString(3, equipamento.getModelo());
            qry.setString(4, equipamento.getSerie());
            qry.setString(5, equipamento.getDescricao());
            qry.setString(6, equipamento.getObs());
            qry.setInt(7, equipamento.getCod_Cliente());
            qry.setInt(8, equipamento.getTipoEquip());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Equipamento> ListarTodosEquipamentos(){
        String sql = "select Cod_Equipamento, Cod_Cliente, Marca, Modelo, Serie, Tipo_Equip, Descricao, Observacao from equipamento";
        con = conexao.getconexao();
        ArrayList<Equipamento> Equipamentos = new ArrayList<Equipamento>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Equipamento a = new Equipamento();
                a.setCod_Equip(rs.getInt("Cod_Equipamento"));
                a.setCod_Cliente(rs.getInt("Cod_Cliente"));
                a.setMarca(rs.getString("Marca"));
                a.setModelo(rs.getString("Modelo"));
                a.setSerie(rs.getString("Serie"));
                a.setTipoEquip(rs.getInt("Tipo_Equip"));
                a.setDescricao(rs.getString("Descricao"));
                a.setObs(rs.getString("Observacao"));
                Equipamentos.add(a);
            }
            return Equipamentos;
        } catch (SQLException ex){
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
