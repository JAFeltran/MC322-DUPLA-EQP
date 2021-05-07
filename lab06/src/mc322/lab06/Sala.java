package mc322.lab06;

public class Sala {
    // Atributos
    private Componente buraco, ouro, wumpus, fedor, brisa;
    private boolean visitado;

    // Construtor
    public Sala() {
        buraco = null;
        ouro = null;
        wumpus = null;
        fedor = null;
        brisa = null;
        visitado = false;
    }

    // Setters
    public boolean setBuraco(Componente buraco) {
        if ((wumpus == null) && (ouro == null)) {
            this.buraco = buraco;
            return true;
        }
        return false;
    }
    public boolean setOuro(Componente ouro) {
        if ((buraco == null) && (wumpus == null)) {
            this.ouro = ouro;
            return true;
        }
        return false;
    }
    public boolean setWumpus(Componente wumpus) {
        if ((buraco == null) && (ouro == null)) {
            this.wumpus = wumpus;
            return true;
        }
        return false;
    }
    public void setFedor(Componente fedor) {
        this.fedor = fedor;
    }
    public void setBrisa(Componente brisa) {
        this.brisa = brisa;
    }
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Getters
    public char getComponente() {
        if (buraco != null) {
            return 'B';
        }
        if (ouro != null) {
            return 'O';
        }
        if (wumpus != null) {
            return 'W';
        }
        if (fedor != null) {
            return 'f';
        }
        if (brisa != null) {
            return 'b';
        }
        return '-';
    }
    public boolean getVisitado() {
        return visitado;
    }

    // Remove o ouro da sala, se houver, e avisa à caverna
    public boolean pegarOuro() {
        if (ouro != null) {
            ouro = null;
            return true;
        }
        return false;
    }
}
