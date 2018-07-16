package ionsystem;

public class Equipamento {
    private int Cod_Equip;
    private String Marca;
    private String Modelo;
    private String Serie;
    private String Descricao;
    private String Obs;
    private int TipoEquip;
    private int Cod_Cliente;
    private String Nome_Cliente;

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

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public int getTipoEquip() {
        return TipoEquip;
    }

    public void setTipoEquip(int TipoEquip) {
        this.TipoEquip = TipoEquip;
    }

    public int getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public String getNome_Cliente() {
        return Nome_Cliente;
    }

    public void setNome_Cliente(String Nome_Cliente) {
        this.Nome_Cliente = Nome_Cliente;
    }
    
}
