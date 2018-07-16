package ionsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFuncionario {
    private Connection con;
    private PreparedStatement qry;
    
    public void salvar(Funcionario func){
        String sql="insert into funcionario"
                + "(Cod_Funcionario,Nome,Sexo,Data_Nasc,RG,CPF,Telefone,Endereco,CEP,Bairro,Cidade,Estado) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, func.getCod_Funcionario());
            qry.setString(2, func.getNome());
            qry.setString(3, func.getSexo());
            qry.setDate(4, new java.sql.Date(
                        func.getData_Nasc().getTimeInMillis()));
            qry.setString(5, func.getRG());
            qry.setString(6, func.getCPF());
            qry.setString(7, func.getTelefone());
            qry.setString(8, func.getEndereco());
            qry.setString(9, func.getCEP());
            qry.setString(10, func.getBairro());
            qry.setString(11, func.getCidade());
            qry.setString(12, func.getEstado());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(String num){
        String sql="delete from funcionario" + " where Cod_Funcionario = " + num;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(Funcionario func, String num){
        String sql="update Funcionario set Cod_Funcionario = ?, Nome = ?, Sexo = ?, Data_Nasc = ?, RG = ?, CPF = ?, Telefone = ?, Endereco = ?, CEP = ?, Bairro = ?, Cidade = ?, Estado = ? where Cod_Funcionario = " + num ;
        con = conexao.getconexao();
        try{
            qry = con.prepareStatement(sql);
            qry.setInt(1, func.getCod_Funcionario());
            qry.setString(2, func.getNome());
            qry.setString(3, func.getSexo());
            qry.setDate(4, new java.sql.Date(
                        func.getData_Nasc().getTimeInMillis()));
            qry.setString(5, func.getRG());
            qry.setString(6, func.getCPF());
            qry.setString(7, func.getTelefone());
            qry.setString(8, func.getEndereco());
            qry.setString(9, func.getCEP());
            qry.setString(10, func.getBairro());
            qry.setString(11, func.getCidade());
            qry.setString(12, func.getEstado());
            qry.execute();
    }   catch (SQLException ex) {
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Funcionario> ListarTodosFuncionarios(){
        String sql = "select Cod_Funcionario, Nome, Data_Nasc, Telefone from Funcionario";
        con = conexao.getconexao();
        ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
        try{
            qry = con.prepareStatement(sql);
            ResultSet rs = qry.executeQuery();
            while(rs.next()){
                Funcionario a = new Funcionario();
                a.setCod_Funcionario(rs.getInt("Cod_Funcionario"));
                a.setNome(rs.getString("Nome"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("Data_Nasc"));
                a.setData_Nasc(cal);
                a.setTelefone(rs.getString("Telefone"));
                Funcionarios.add(a);
            }
            return Funcionarios;
        } catch (SQLException ex){
            Logger.getLogger(DAOFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
