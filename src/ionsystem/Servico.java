package ionsystem;

public class Servico {
    private int Cod_Serv;
    private String Descricao;
    private float Preco;

    public int getCodigo() {
        return Cod_Serv;
    }

    public void setCodigo(int Codigo) {
        this.Cod_Serv = Codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float preco) {
        this.Preco = preco;
    }
}
