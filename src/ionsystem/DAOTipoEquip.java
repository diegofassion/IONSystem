package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTipoEquip {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(TipoEquip tipoequip){
        String sql="insert into tipo_equipamento"
                + "(Cod_Tipo_Equipamento,Descricao) values(?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, tipoequip.getCodigo());
            qry.setString(2, tipoequip.getDescricao());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String num){
        String sql="delete from tipo_equipamento" + " where Cod_Tipo_Equipamento = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(TipoEquip tipoequip, String num){
        String sql="update tipo_equipamento set Cod_Tipo_Equipamento = ?, Descricao = ? where Cod_Tipo_Equipamento = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, tipoequip.getCodigo());
            qry.setString(2, tipoequip.getDescricao());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOTipoEquip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<TipoEquip> ListarTodosTiposEquip(){
        String sql = "select Cod_Tipo_Equipamento, Descricao from tipo_equipamento";
        con = conexao.getconexao();
        ArrayList<TipoEquip> Tiposequip = new ArrayList<TipoEquip>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                TipoEquip a = new TipoEquip();
                a.setCodigo(rs.getInt("Cod_Tipo_Equipamento"));
                a.setDescricao(rs.getString("Descricao"));
                Tiposequip.add(a);
            }
            return Tiposequip;
        } catch (SQLException ex){
            Logger.getLogger(DAOTipoEquip.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
