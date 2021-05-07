package mc322.lab06;

public class Montador {
    private int qtdBuracos, qtdWumpus, qtdOuro, qtdHeroi;
    private Heroi heroi;
    private Caverna mapa;

    public Montador() {
        qtdBuracos = 0;
        qtdWumpus = 0;
        qtdOuro = 0;
        qtdHeroi = 0;
        mapa = new Caverna();
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public boolean montarJogo(String caminho) {
        CSVHandling csv = new CSVHandling();
        String comandos[][];
        int i, j;
        String representacao;

        csv.setDataSource(caminho);

        comandos = csv.requestCommands();

        for (int k = 0; k < 16; k++) {
            i = comandos[k][0].charAt(0) - 49;
            j = comandos[k][0].charAt(2) - 49;
            representacao = comandos[k][1];

            if (representacao.equals("P")) {
                if (i == 0 && j == 0 && qtdHeroi == 0) {
                    qtdHeroi++;
                    heroi = new Heroi(i, j, 1, mapa);
                }
                else {
                    return false;
                }
            }
            else if (representacao.equals("W")) {
                if (qtdWumpus == 0) {
                    Componente wumpus = new Wumpus(i, j, mapa);

                    qtdWumpus++;

                    mapa.getSala(i, j).setWumpus(wumpus);

                    wumpus.criarFedor();
                }
                else {
                    return false;
                }
            }
            else if (representacao.equals("B")) {
                if (qtdBuracos < 3) {
                    Componente buraco = new Buraco(i, j, mapa);

                    qtdBuracos++;

                    mapa.getSala(i, j).setBuraco(buraco);

                    buraco.criarBrisa();
                }
                else {
                    return false;
                }
            }
            else if (representacao.equals("O")) {
                if (qtdOuro == 0) {
                    Componente ouro = new Ouro(i, j, mapa);

                    qtdOuro++;

                    mapa.getSala(i, j).setOuro(ouro);
                }
                else {
                    return false;
                }
            }
        }

        if (qtdBuracos >= 2 && qtdHeroi == 1 && qtdWumpus == 1 && qtdOuro == 1) {
            return true;
        }

        return false;
    }
}
