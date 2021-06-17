package src.Controle;

import src.Ator.*;
import src.Painel.painelBatalha;

public class Controle implements IControle {
    // Atributos
    private IHeroi heroi;

    // IControle
    public void setHeroi(IHeroi heroi) {
        this.heroi = heroi;
    }

    public boolean getVivo() {
        return heroi.getVivo();
    }

    public void jogada(int x, int y) {
        char movimento = heroi.verificarMovimento(x, y);

        switch (movimento) {
            case 'i':
                IAtor inimigo = heroi.getInimigoNaPosicao(x, y);
                new painelBatalha(heroi, inimigo);

                if (heroi.getVivo()) {
                    // heroi.pegarItem(); ??????????????????????????????????????
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
