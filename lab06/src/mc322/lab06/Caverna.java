package mc322.lab06;

public class Caverna {
    // Atributos
    private Sala salas[][];
    private Heroi heroi;

    // Construtor
    public Caverna() {
        salas = new Sala[4][4];
    }

    // Setters
    public void setSala(int x, int y, Sala sala) {
        salas[x][y] = sala;
    }
    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    // Getters
    public char getComponenteNaSala(int x, int y) {
        return salas[x][y].getComponente();
    }
    public Sala getSala(int x, int y) {
        return salas[x][y];
    }

    // "Pega o ouro" (atualiza o estado do herói e da sala)
    public void pegarOuro(int x, int y) {
        salas[x][y].pegarOuro();
        heroi.setOuro(true);
    }

    // Imprime o estado atual da caverna no console
    public void imprimirCaverna() {
        for (int i = 0; i < 4; i ++) {
            System.out.print(i + 1);
            for (int j = 0; j < 4; j ++) {
                if (salas[i][j].getVisitado() == true) {
                    char componente = salas[i][j].getComponente();
                    if ((componente == 'O') || (componente == 'B') || (componente == 'W')) {
                        System.out.print(" " + componente);
                    } else if ((i == heroi.getX()) && (j == heroi.getY())) {
                        System.out.print(" P");
                    } else if ((componente == 'f') || (componente == 'b')) {
                        System.out.print(" " + componente);
                    } else {
                        System.out.print(" #");
                    }
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println("  1 2 3 4");
        System.out.println();
    }
}
