package mc322.lab06;

public class AppMundoWumpus {
    public static void main(String[] args) {
        Montador montador = new Montador();
        Controle controle = new Controle();

        boolean jogo = montador.montarJogo(args[0]);

        if (!jogo) {
            System.out.println("Caverna inválida!");
        } else {
            controle.setHeroi(montador.getHeroi());

            controle.imprimirEstado();

            boolean jogando = true;
            
            while (jogando) {
                jogando = controle.jogada();
                controle.imprimirEstado();
            }
        }
    }
}
