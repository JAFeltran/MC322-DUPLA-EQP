package mc322.lab06;

import java.util.Scanner;
import java.util.Random;

public class Controle {
    // Atributos
    private String nome, mensagem;
    private int pontuacao;
    private Caverna caverna;
    private Heroi heroi;
    private boolean jogando, vivo, ganhou;
    private Scanner teclado;

    // Construtor
    public Controle() {
       teclado = new Scanner(System.in);
       nome = teclado.nextLine();
       pontuacao = 0;
       jogando = true;
       vivo = true;
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
                mensagem = "Você ganhou! =D";
            }
        }
    }

    // Ataca o Wumpus
    private void atacarWumpus() {
        Random random = new Random();
        int sucesso = random.nextInt(2);
        if (sucesso == 0) {
            pontuacao -= 1100;
            vivo = false;
            jogando = false;
            mensagem = "O Wumpus se defendeu da flecha e matou o herói!\nVocê perdeu! =(";
        } else {
            pontuacao += 400;
            mensagem = "O herói matou o Wumpus!";
            // PRECISA REMOVER O WUMPUS E OS FEDORES DO TABULEIRO!!!!!!!!!!
        }
    }

    // Lê um comando do teclado e o executa
    public boolean jogada() {
        String comando = teclado.nextLine();
        comando.toLowerCase();
        int x = heroi.getX(), y = heroi.getY();

        if (comando == "q") {
            jogando = false;
            mensagem = "Volte sempre!";
        } else if (comando == "c") {
            if (caverna.getComponenteNaSala(x, y) == 'O') {
                caverna.pegarOuro(x, y);
                mensagem = "O herói pegou o ouro!";
            } else {
                mensagem = "Não há ouro nesta sala!";
            }
        } else if (comando == "k") {
            heroi.equiparFlecha();
            if (heroi.getFlechaEquipada() == true) {
                mensagem = "O herói equipou a flecha!";
            } else {
                mensagem = "O herói não possui mais flechas!";
            }
        } else if ((comando == "w") || (comando == "a") || (comando == "s") || (comando == "d")) {
            if (comando == "w") {
                if (x > 0) {
                    heroi.setX(x - 1);
                    x -= 1;
                } else {
                    mensagem = "O herói não pode atravessar a parede da caverna!";
                    return jogando;
                }
            } else if (comando == "a") {
                if (y > 0) {
                    heroi.setY(y - 1);
                    y -= 1;
                } else {
                    mensagem = "O herói não pode atravessar a parede da caverna!";
                    return jogando;
                }
            } else if (comando == "s") {
                if (x < 3) {
                    heroi.setX(x + 1);
                    x += 1;
                } else {
                    mensagem = "O herói não pode atravessar a parede da caverna!";
                    return jogando;
                }
            } else {
                if (y < 3) {
                    heroi.setY(y + 1);
                    y += 1;
                } else {
                    mensagem = "O herói não pode atravessar a parede da caverna!";
                    return jogando;
                }
            }

            pontuacao -= 15;
            char componente = caverna.getComponenteNaSala(x, y);

            if (componente == 'B') {
                pontuacao -= 1000;
                jogando = false;
                vivo = false;
                mensagem = "O herói caiu em um buraco!\nVocê perdeu! =(";
            } else if (componente == 'O') {
                mensagem = "O herói vê uma pilha de ouro na sala!";
            } else if (componente == 'W') {
                if (heroi.getFlechaEquipada() == true) {
                    atacarWumpus();
                } else {
                    pontuacao -= 1000;
                    jogando = false;
                    vivo = false;
                    mensagem = "O Wumpus matou o herói!\nVocê perdeu! =(";
                }
            } else {
                if (heroi.getFlechaEquipada() == true) {
                    heroi.setFlechaEquipada(false);
                    pontuacao -= 100;
                }
                verificaVitoria();
                if (ganhou == false) {
                    if (componente == 'f') {
                        mensagem = "O herói sente um forte fedor na sala...";
                    } else if (componente == 'b') {
                        mensagem = "O herói sente uma brisa assustadora na sala...";
                    } else {
                        mensagem = "O herói encontra uma sala vazia...";
                    }
                }
            }
        } else {
            mensagem = "Comando inválido!";
        }
        return jogando;
    }

    public void imprimirEstado() {
        caverna.imprimirCaverna();
        System.out.println("Player: " + nome);
        System.out.println("Score: " + pontuacao);
        if (ganhou == true) {
            System.out.println(mensagem);
        } else if (vivo == false) {
            System.out.println(mensagem);
        } else if (jogando == false) {
            System.out.println(mensagem);
        } else {
            System.out.println("Status: " + mensagem);
        }
        System.out.println();
    }
}
