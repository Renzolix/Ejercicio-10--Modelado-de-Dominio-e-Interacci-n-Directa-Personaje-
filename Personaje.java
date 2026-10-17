public class Personaje {
    private String nombre;
    private int puntosVida;
    private int puntosAtaque;

    public Personaje(String nombre, int puntosVida, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }

    public void atacar(Personaje objetivo) {
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " provocando " + this.puntosAtaque + " puntos de daño.");
        
        objetivo.puntosVida -= this.puntosAtaque;
        if (objetivo.puntosVida < 0) {
            objetivo.puntosVida = 0;
        }

        System.out.println("-> Salud restante de " + objetivo.getNombre() + ": " + objetivo.puntosVida + " HP\n");
    }

    public boolean estaVivo() {
        return this.puntosVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public static void main(String[] args) {
        Personaje guerrero = new Personaje("Guerrero", 100, 25);
        Personaje orco = new Personaje("Orco", 80, 20);

        System.out.println("=== ¡INICIO DEL COMBATE ===");
        System.out.println(guerrero.getNombre() + " (HP: " + guerrero.getPuntosVida() + ") vs " + orco.getNombre() + " (HP: " + orco.getPuntosVida() + ")\n");

        int turno = 1;
        while (guerrero.estaVivo() && orco.estaVivo()) {
            System.out.println("--- Turno " + turno + " ---");
            
            // Ataca el guerrero
            guerrero.atacar(orco);

            // Si el orco sobrevive, contraataca
            if (orco.estaVivo()) {
                orco.atacar(guerrero);
            }
            turno++;
        }

        System.out.println("=== FIN DEL COMBATE ===");
        if (guerrero.estaVivo()) {
            System.out.println("¡" + guerrero.getNombre() + " ha salido victorioso!");
        } else {
            System.out.println("¡" + orco.getNombre() + " ha ganado la batalla!");
        }
    }
}