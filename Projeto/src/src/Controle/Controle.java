package src.Controle;

import Batalha.IBatalha;

public class Controle implements IControle {
    // Atributos
    private int fase, pontuacao;
    private IBatalha batalha;

    // Construtor
    public Controle() {
        fase = 0; 
        pontuacao = 0;
    }

    // IControlePropriedades
    public void setBatalha(IBatalha batalha) {
        this.batalha = batalha;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    // TODO

    TODO
}
