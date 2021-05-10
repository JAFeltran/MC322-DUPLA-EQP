package mc322.lab06;

import java.util.ArrayList;

public class Sala {
    // Atributos
    private ArrayList<Componente> componentes = new ArrayList<Componente>();
    private boolean visitado;

    // Construtor
    public Sala() {
        visitado = false;
    }

    // Setters
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    // Getters
    public boolean getVisitado() {
        return visitado;
    }

    public Componente getComponente() {
        if (componentes.isEmpty()) {
            return null;
        }
        return componentes.get(0);
    }

    public Componente getComponenteSecundario() {
        if (componentes.isEmpty() || componentes.size() == 1) {
            return null;
        }
        return componentes.get(1);
    }

    // Adiciona o componente recebido à sala
    public boolean adicionarComponente(Componente componente) {
        if (componentes.isEmpty()) {
            componentes.add(componente);
            return true;
        }

        char tipoComponente = componente.getTipo();
        char tipoComponente0 = componentes.get(0).getTipo();
        
        if (tipoComponente == 'O') {
            if ((tipoComponente0 != 'B') && (tipoComponente0 != 'W')) {
                componentes.add(0, componente);
                return true;
            }
            return false;
        } else if (tipoComponente == 'W') {
            if ((tipoComponente0 != 'O') && (tipoComponente0 != 'B')) {
                componentes.add(0, componente);
                return true;
            }
            return false;
        } else if (tipoComponente == 'B') {
            if ((tipoComponente0 != 'O') && (tipoComponente0 != 'W')) {
                componentes.add(0, componente);
                return true;
            }
            return false;
        } else if (tipoComponente == 'P') {
            if ((tipoComponente0 == 'O') || (tipoComponente0 == 'W') || (tipoComponente0 == 'B')) {
                componentes.add(1, componente);
            } else {
                componentes.add(0, componente);
            }
            return true;
        } else if (tipoComponente == 'f') {
            for (int i = 0; i < componentes.size(); i ++) {
                if (componentes.get(i).getTipo() == 'b') {
                    componentes.add(i, componente);
                    return true;
                }
            }
        }
        componentes.add(componente);
        return true;
    }

    // Remove o ouro da sala
    public void removerOuro() {
        if (componentes.get(0).getTipo() == 'O') {
            componentes.remove(0);
        }
    }

    // Remove o Herói da sala
    public Componente removerHeroi() {
        for (int i = 0; i < componentes.size(); i ++) {
            if (componentes.get(i).getTipo() == 'P') {
                return componentes.remove(i);
            }
        }
        return null;
    }

    // Remove o Wumpus da sala
    public void removerWumpus() {
        if (componentes.get(0).getTipo() == 'W') {
            componentes.remove(0);
        }
    }

    // Remove o fedor da sala
    public void removerFedor() {
        for (int i = 0; i < componentes.size(); i ++) {
            if (componentes.get(i).getTipo() == 'f') {
                componentes.remove(i);
            }
        }
    }
}
