package mc322.lab06;

public class AppMundoWumpus {
    public static void main(String[] args) {
        Montador montador = new Montador();
        Controle controle = new Controle();

        Heroi heroi = montador.montar(args[0]);

        controle.setHeroi(heroi);

        boolean jogando = true;

        while (jogando == true) {
            jogando = controle.jogada();
            controle.imprimirEstado();
        }
    }
}
