package br.com.inatel.udemyCucumber.entities;

import java.util.Date;

public class NotaAluguel {

    private int preco;

    private Date dataEntrega;
    private int pontuação;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }

    public Integer getPontuação() {
        return pontuação;
    }

    public void setPontuacao(int pontuação) {
        this.pontuação = pontuação;
    }
}
