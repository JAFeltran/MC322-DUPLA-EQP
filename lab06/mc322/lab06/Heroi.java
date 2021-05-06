package mc322.lab06;

public class Heroi extends Componente {
    private boolean vivo;
    private boolean ouro;
    private int flechas;
    private boolean flechaEquipada;

    public Heroi(int x, int y, int flechas) {
        super(x, y, 'P');
        vivo = true;
        ouro = false;
        this.flechas = flechas;
        flechaEquipada = false;
    }

    public void setVivo(boolean vivo)
    {
        this.vivo = vivo;
    }

    public void setOuro(boolean ouro) {
        this.ouro = ouro;
    }

    public void setFlechas(int flechas)
    {
        this.flechas = flechas;
    }

    public void setFlechaEquipada(boolean flechaEquipada)
    {
        this.flechaEquipada = flechaEquipada;
    }

    public boolean getVivo()
    {
        return vivo;
    }

    public boolean getOuro() {
        return ouro;
    }

    public int getFlechas() {
        return flechas;
    }

    public boolean getFlechaEquipada()
    {
        return flechaEquipada;
    }

    public void equiparFlecha() {
        if (flechas > 0) {
            flechaEquipada = true;
            flechas--;
        }
    }
}
