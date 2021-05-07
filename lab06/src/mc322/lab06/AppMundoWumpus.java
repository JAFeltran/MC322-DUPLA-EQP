package mc322.lab06;

public class AppMundoWumpus {
    public static void main(String[] args) {
        Montador montador = new Montador();
        Controle controle = new Controle();

        boolean jogo = montador.montarJogo(args[0]);

        if (jogo == false) {
            System.out.println("Caverna inválida!");
        } else {
            controle.setCaverna(montador.getCaverna());
            controle.setHeroi(montador.getHeroi());
            
            boolean jogando = true;
            
            while (jogando) {
                jogando = controle.jogada();
                controle.imprimirEstado();
            }
        }
    }
}
