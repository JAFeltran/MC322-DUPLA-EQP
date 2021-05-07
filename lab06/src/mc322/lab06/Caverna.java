package mc322.lab06;

public class Caverna {
    private Sala salas[][];
    private Heroi heroi;

    public Caverna() {
        salas = new Sala[4][4];
    }

    public void setSala(int x, int y, Sala sala) {
        salas[x][y] = sala;
    }

    public void setHeroi(Heroi heroi) {
        this.heroi = heroi;
    }

    public sala getSala(int x, int y) {
        return salas[x][y];
    }

    public void pegarOuro(int x, int y) {
        salas[x][y].pegarOuro();
    }

    public void imprimirCaverna() {
        for (int i = 0; i < 4; i ++) {
            System.out.print(i + 1);
            for (int j = 0; j < 4; j ++) {
                if (salas[i][j].getVisitado() == true) {
                    if (salas[i][j].getComponente() == 'O') {
                        System.out.print(" O");
                    } else if (salas[i][j].getComponente() == 'B') {
                        System.out.print(" B");
                    } else if (salas[i][j].getComponente() == 'W') {
                        System.out.print(" W");
                    } else if (i == heroi.getX() && j == heroi.getY()) {
                        System.out.print(" P");
                    } else if (salas[i][j].getComponente() == 'f') {
                        System.out.print(" f");
                    } else if (salas[i][j].getComponente() == 'b') {
                        System.out.print(" b");
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
