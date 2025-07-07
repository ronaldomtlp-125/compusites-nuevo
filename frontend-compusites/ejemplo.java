













interface Observador {
    void actualizar();
}
class Notificador implements Observador {
    public void actualizar() { System.out.println("Notificado"); }
}
