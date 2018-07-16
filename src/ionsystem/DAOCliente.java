package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(Cliente cliente){
        String sql="insert into cliente"
                + "(Cod_Cliente,Nome,Sexo,Data_Nasc,RG,CPF,Telefone,Endereco,CEP,Bairro,Cidade,Estado) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, cliente.getCod_Cliente());
            qry.setString(2, cliente.getNome());
            qry.setString(3, cliente.getSexo());
            qry.setDate(4, new java.sql.Date(
                        cliente.getData_Nasc().getTimeInMillis()));
            qry.setString(5, cliente.getRG());
            qry.setString(6, cliente.getCPF());
            qry.setString(7, cliente.getTelefone());
            qry.setString(8, cliente.getEndereco());
            qry.setString(9, cliente.getCEP());
            qry.setString(10, cliente.getBairro());
            qry.setString(11, cliente.getCidade());
            qry.setString(12, cliente.getEstado());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String num){
        String sql="delete from Cliente" + " where Cod_Cliente = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            //qry.setString(1,num);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Cliente cliente, String num){
        String sql="update Cliente set Cod_Cliente = ?, Nome = ?, Sexo = ?, Data_Nasc = ?, RG = ?, CPF = ?, Telefone = ?, Endereco = ?, CEP = ?, Bairro = ?, Cidade = ?, Estado = ? where Cod_Cliente = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, cliente.getCod_Cliente());
            qry.setString(2, cliente.getNome());
            qry.setString(3, cliente.getSexo());
            qry.setDate(4, new java.sql.Date(
                        cliente.getData_Nasc().getTimeInMillis()));
            qry.setString(5, cliente.getRG());
            qry.setString(6, cliente.getCPF());
            qry.setString(7, cliente.getTelefone());
            qry.setString(8, cliente.getEndereco());
            qry.setString(9, cliente.getCEP());
            qry.setString(10, cliente.getBairro());
            qry.setString(11, cliente.getCidade());
            qry.setString(12, cliente.getEstado());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Cliente> ListarTodosClientes(){
        String sql = "select Cod_Cliente, Nome, Data_Nasc, Telefone from Cliente";
        con = conexao.getconexao();
        ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Cliente a = new Cliente();
                a.setCod_Cliente(rs.getInt("Cod_Cliente"));
                a.setNome(rs.getString("Nome"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("Data_Nasc"));
                a.setData_Nasc(cal);
                a.setTelefone(rs.getString("Telefone"));
                Clientes.add(a);
            }
            return Clientes;
        } catch (SQLException ex){
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
