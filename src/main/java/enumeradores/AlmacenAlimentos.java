package enumeradores;

public enum AlmacenAlimentos {
    SOPA(15), ASADO(25), CHORIPAN(10), ENSALADA(20), PORORO(5);

    private int energiaAportada;
    AlmacenAlimentos(int energia) {
        this.energiaAportada = energia;
    }
    public int getEnergiaAportada() {
        return energiaAportada;
    }
}
