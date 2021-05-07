package mc322.lab06;

import java.util.Scanner;
import java.util.Random;

public class Controle {
    // Atributos
    private String nome, status;
    private int pontuacao;
    private Caverna caverna;
    private Heroi heroi;
    private boolean jogando, ganhou;
    private Scanner teclado;

    // Construtor
    public Controle() {
       teclado = new Scanner(System.in);
       nome = teclado.nextLine();
       pontuacao = 0;
       jogando = true;
       ganhou = false;
    }

    // Setters
    public void setCaverna(Caverna caverna) {
        this.caverna = caverna;
    }
    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    // Verifica se o herói está em (0, 0) com o ouro
    private void verificaVitoria() {
        if (heroi.getOuro() == true) {
            if ((heroi.getX() == 0) && (heroi.getY() == 0)) {
                pontuacao += 1000;
                jogando = false;
                ganhou = true;
                status = "Você ganhou! =D";
            }
        }
    }

    // O herói tem 50% de chance de matar o Wumpus. Atualiza o estado do jogo de acordo com o resultado. 
    private void atacarWumpus() {
        Random random = new Random();
        int sucesso = random.nextInt(2);
        int x = heroi.getX(), y = heroi.getY();
        if (sucesso == 0) {
            pontuacao -= 1100;
            jogando = false;
            status = "O Wumpus se defendeu da flecha e matou o herói!\nVocê perdeu! =(";
        } else {
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
        String comando = teclado.nextLine();
        comando.toLowerCase();
        int x = heroi.getX(), y = heroi.getY();

        if (comando == "q") {
            jogando = false;
            status = "Volte sempre!";
        } else if (comando == "c") {
            if (caverna.getComponenteNaSala(x, y) == 'O') {
                caverna.pegarOuro(x, y);
                status = "O herói pegou o ouro!";
            } else {
                status = "Não há ouro nesta sala!";
            }
        } else if (comando == "k") {
            heroi.equiparFlecha();
            if (heroi.getFlechaEquipada() == true) {
                status = "O herói equipou a flecha!";
            } else {
                status = "O herói não possui mais flechas para equipar!";
            }
        } else if ((comando == "w") || (comando == "a") || (comando == "s") || (comando == "d")) {
            if (comando == "w") {
                if (x > 0) {
                    heroi.setX(x - 1);
                    x -= 1;
                } else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            } else if (comando == "a") {
                if (y > 0) {
                    heroi.setY(y - 1);
                    y -= 1;
                } else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            } else if (comando == "s") {
                if (x < 3) {
                    heroi.setX(x + 1);
                    x += 1;
                } else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            } else {
                if (y < 3) {
                    heroi.setY(y + 1);
                    y += 1;
                } else {
                    status = "O herói tenta atravessar uma parede, mas não consegue...";
                    return jogando;
                }
            }

            pontuacao -= 15;
            char componente = caverna.getComponenteNaSala(x, y);

            if (componente == 'B') {
                pontuacao -= 1000;
                jogando = false;
                status = "O herói caiu em um buraco terrivelmente fundo!\nVocê perdeu! =(";
            } else if (componente == 'O') {
                status = "O herói vê uma pilha de ouro muito brilhante no centro da sala!";
            } else if (componente == 'W') {
                if (heroi.getFlechaEquipada() == true) {
                    atacarWumpus();
                } else {
                    pontuacao -= 1000;
                    jogando = false;
                    status = "No cantinho da sala, estava o fedorento Wumpus, que mata o herói!\nVocê perdeu! =(";
                }
            } else {
                if (heroi.getFlechaEquipada() == true) {
                    heroi.setFlechaEquipada(false);
                    pontuacao -= 100;
                }
                verificaVitoria();
                if (ganhou == false) {
                    if (componente == 'f') {
                        status = "O herói sente um forte fedor na sala...";
                    } else if (componente == 'b') {
                        status = "O herói sente uma brisa assustadora na sala...";
                    } else {
                        status = "O herói encontra uma sala vazia, escura, silenciosa e assustadora...";
                    }
                }
            }
        } else {
            status = "O herói está confuso e não entendeu o comando...";
        }
        return jogando;
    }

    public void imprimirEstado() {
        caverna.imprimirCaverna();
        System.out.println("Player: " + nome);
        System.out.println("Score: " + pontuacao);
        System.out.println("Status: " + status);
        System.out.println();
    }
}
