package br.com.inatel.udemyCucumber.entities;

public class Filme {

    private int estoque;
    private int aluguel;

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(Integer int1) {
        this.aluguel = int1;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer int1) {
        this.estoque = int1;
    }
}
