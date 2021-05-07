package mc322.lab06;

import java.util.Scanner;
import java.util.Random;

public class Controle {
    // Atributos
    private String nome, status;
    private int pontuacao;
    private Heroi heroi;
    private boolean jogando, ganhou;
    private Scanner teclado;

    // Construtor
    public Controle() {
        teclado = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nome = teclado.nextLine();
        pontuacao = 0;
        jogando = true;
        ganhou = false;
        status = "O heroi entra na caverna em busca de tesouro!";
    }

    // Setters
    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    // Verifica se o herói está em (0, 0) e carrega o ouro
    private void verificaVitoria() {
        if (heroi.getOuro()) {
            if ((heroi.getX() == 0) && (heroi.getY() == 0)) {
                pontuacao += 1000;
                jogando = false;
                ganhou = true;
                status = "O bravo herói conquistou o tesouro!\nVocê ganhou! =D";
            }
        }
    }

    // O herói tem 50% de chance de matar o Wumpus. Atualiza o estado do jogo de acordo com o resultado. 
    private void atacarWumpus(Caverna caverna) {
        Random random = new Random();
        int sucesso = random.nextInt(2);
        int x = heroi.getX(), y = heroi.getY();
        if (sucesso == 0) {
            pontuacao -= 1100;
            jogando = false;
            status = "O Wumpus se defendeu da flecha e matou o herói!\nVocê perdeu! =(";
        }
        else {
            pontuacao += 400;
            status = "O herói matou o Wumpus!";
            caverna.getSala(x, y).setWumpus(null);
            if (x > 0) {
                caverna.getSala(x - 1, y).setFedor(null);
            }
            if (x < 3) {
                caverna.getSala(x + 1, y).setFedor(null);
            }
            if (y > 0) {
                caverna.getSala(x, y - 1).setFedor(null);
            }
            if (y < 3) {
                caverna.getSala(x, y + 1).setFedor(null);
            }
        }
    }

    // Lê um comando do teclado e o executa
    public boolean jogada() {
        System.out.print("Digite seu comando: ");

        String comando = teclado.nextLine();
        comando.toLowerCase();
        int x = heroi.getX(), y = heroi.getY();
        Caverna caverna = heroi.getMapa();

        if (comando.equals("q")) {
            jogando = false;
            status = "Volte sempre!";
        }
        else if (comando.equals("c")) {
            if (caverna.getComponenteNaSala(x, y) == 'O') {
                caverna.getSala(x, y).pegarOuro();
                heroi.setOuro(true);
                status = "O herói pegou o ouro!";
            }
            else {
                status = "Não há ouro nesta sala!";
            }
        }
        else if (comando.equals("k")) {
            heroi.equiparFlecha();
            if (heroi.getFlechaEquipada()) {
                status = "O herói equipou a flecha!";
            }
            else {
                status = "O herói não possui mais flechas para equipar!";
            }
        }
        else if ((comando.equals("w")) || (comando.equals("a")) || (comando.equals("s")) || (comando.equals("d"))) {
            if (comando.equals("w")) {
                if (x > 0) {
                    heroi.setX(x - 1);
                    x -= 1;
                }
                else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            }
            else if (comando.equals("a")) {
                if (y > 0) {
                    heroi.setY(y - 1);
                    y -= 1;
                }
                else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            }
            else if (comando.equals("s")) {
                if (x < 3) {
                    heroi.setX(x + 1);
                    x += 1;
                }
                else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            }
            else {
                if (y < 3) {
                    heroi.setY(y + 1);
                    y += 1;
                }
                else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            }

            pontuacao -= 15;
            char componente = caverna.getComponenteNaSala(x, y);
            heroi.getMapa().getSala(x, y).setVisitado(true);

            if (componente == 'B') {
                pontuacao -= 1000;
                jogando = false;
                status = "O herói caiu em um buraco terrivelmente fundo!\nVocê perdeu! =(";
            }
            else if (componente == 'O') {
                status = "O herói vê uma pilha de ouro muito brilhante no centro da sala!";
            }
            else if (componente == 'W') {
                if (heroi.getFlechaEquipada()) {
                    atacarWumpus(caverna);
                }
                else {
                    pontuacao -= 1000;
                    jogando = false;
                    status = "No cantinho da sala, estava o fedorento Wumpus, que mata o herói!\nVocê perdeu! =(";
                }
            }
            else {
                if (heroi.getFlechaEquipada()) {
                    heroi.setFlechaEquipada(false);
                    pontuacao -= 100;
                }
                verificaVitoria();
                if (!ganhou) {
                    if (componente == 'f') {
                        status = "O herói sente um forte fedor na sala...";
                    }
                    else if (componente == 'b') {
                        status = "O herói sente uma brisa assustadora na sala...";
                    }
                    else {
                        status = "O herói encontra uma sala vazia, escura, silenciosa e assustadora...";
                    }
                }
            }
        }
        else {
            status = "O herói está confuso e não entendeu o comando...";
        }
        return jogando;
    }

    // Imprime o mapa da caverna, assim como as informacoes do jogador e o que ele encontra na sala
    public void imprimirEstado() {
        heroi.getMapa().imprimirCaverna(heroi.getX(), heroi.getY());
        System.out.println("Player: " + nome);
        System.out.println("Score: " + pontuacao);
        System.out.println("Status: " + status);
        System.out.println();
    }
}
