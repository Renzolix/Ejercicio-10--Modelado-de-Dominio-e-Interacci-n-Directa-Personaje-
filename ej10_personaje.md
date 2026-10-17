# Ejercicio 10: Personaje

## Explicación Lógica
1. **Interacción entre Objetos:** En el método `atacar(Personaje objetivo)`, una instancia de `Personaje` recibe a otra por parámetro y le descuenta puntos de vida basados en sus propios puntos de ataque.
2. **Protección de Atributo:** Si los puntos de vida de la víctima bajan de `0`, se reajustan automáticamente a `0` para mantener la coherencia del estado.
3. **Simulación en Bucle:** En el `main`, un ciclo `while` ejecuta los ataques por turnos evaluando continuamente `estaVivo()` (`puntosVida > 0`) hasta que la salud de uno de los personajes llegue a cero.