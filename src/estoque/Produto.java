package estoque;

public class Produto {
    private String nomeProduto;
    private double precoUnitario;
    private String unidade;
    private int quantidade;

    public Produto(String nomeProduto, double precoUnitario, String unidade, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nome) {
        this.nomeProduto = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

