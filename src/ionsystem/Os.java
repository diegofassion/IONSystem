package ionsystem;

import java.util.Calendar;

public class Os {
    private int Codigo;
    private String Situacao;
    private Calendar DataEnt;
    private Calendar DataSaida;
    private int Cod_Equip;
    private String Marca;
    private String Modelo;
    private int Cod_Cliente;
    private int Cod_Funcionario;
    private String Nome_Cli;
    private Float Valor_Serv;
    private Float Valor_Pecas;
    private Float Valor_Outros;
    private Float Valor_Total;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public Calendar getDataEnt() {
        return DataEnt;
    }

    public void setDataEnt(Calendar DataEnt) {
        this.DataEnt = DataEnt;
    }

    public Calendar getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(Calendar DataSaida) {
        this.DataSaida = DataSaida;
    }

    public int getCod_Equip() {
        return Cod_Equip;
    }

    public void setCod_Equip(int Cod_Equip) {
        this.Cod_Equip = Cod_Equip;
    }

    
    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }
    
    

    public int getCod_Funcionario() {
        return Cod_Funcionario;
    }

    public void setCod_Funcionario(int Cod_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
    }

    public String getNome_Cli() {
        return Nome_Cli;
    }

    public void setNome_Cli(String Nome_Cli) {
        this.Nome_Cli = Nome_Cli;
    }

    public Float getValor_Serv() {
        return Valor_Serv;
    }

    public void setValor_Serv(Float Valor_Serv) {
        this.Valor_Serv = Valor_Serv;
    }

    public Float getValor_Pecas() {
        return Valor_Pecas;
    }

    public void setValor_Pecas(Float Valor_Pecas) {
        this.Valor_Pecas = Valor_Pecas;
    }

    public Float getValor_Outros() {
        return Valor_Outros;
    }

    public void setValor_Outros(Float Valor_Outros) {
        this.Valor_Outros = Valor_Outros;
    }

    public Float getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(Float Valor_Total) {
        this.Valor_Total = Valor_Total;
    }
}
