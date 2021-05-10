package mc322.lab06;

public class Caverna {
    // Atributos
    private Sala salas[][];

    // Construtor
    public Caverna() {
        salas = new Sala[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                setSala(i, j, new Sala());
            }
        }
    }

    // Setters
    public void setSala(int x, int y, Sala sala) {
        salas[x][y] = sala;
    }

    // Getters
    public char getComponenteNaSala(int x, int y) {
        Componente componente = salas[x][y].getComponente();
        if (componente == null) {
            return '#';
        }
        return componente.getTipo();
    }

    public char getComponenteSecundarioNaSala(int x, int y) {
        Componente componente = salas[x][y].getComponenteSecundario();
        if (componente == null) {
            return '#';
        }
        return componente.getTipo();
    }

    public Sala getSala(int x, int y) {
        return salas[x][y];
    }

    // Imprime o estado atual da caverna no console
    public void imprimirCaverna() {
        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 4; j++) {
                if (salas[i][j].getVisitado()) {
                    System.out.print(" " + getComponenteNaSala(i, j));
                }
                else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
        System.out.println("  1 2 3 4");
        System.out.println();
    }
}
