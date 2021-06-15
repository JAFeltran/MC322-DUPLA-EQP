package src.Controle;

import src.Ator.IHeroi;
import src.Ator.ICombate;
import src.Janela.janelaCombate;

public class Controle implements IControle {
    // Atributos
    private int fase, pontuacao;
    private IHeroi heroi;
    // Referencia pro view??????????????????????????????????????????????????????

    // Construtor
    public Controle() {
        fase = 0;
        pontuacao = 0;
    }

    // IControle
    public void setHeroi(IHeroi heroi) {
        this.heroi = heroi;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public boolean getVivo() {
        return heroi.getVivo();
    }

    public void jogada(int x, int y) {
        char movimento = heroi.verificarMovimento(x, y);

        switch (movimento) {
            case 'i':
                ICombate inimigo = heroi.getInimigo(x, y);
                new janelaCombate(heroi, inimigo);

                if (heroi.getVivo) {
                    heroi.mover(x, y);
                }

                break;
            case 'o':
                // avisa que não dá pra mover
                break;
            case 't':
                // avisa que o herói entrou no território do chefão
                break;
            case 'v':
                heroi.mover(x, y);
                break;
        }
    } 
}
