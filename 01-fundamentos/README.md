# Fundamentos de Kotlin

Este proyecto contiene ejercicios básicos de Kotlin. Cada archivo de `src/` es
independiente y tiene su propio punto de entrada `main`, por lo que se puede
ejecutar desde IntelliJ IDEA de forma individual.

## Objetivo

El objetivo es practicar los fundamentos del lenguaje Kotlin antes de avanzar
al desarrollo de aplicaciones Android. Los ejercicios están pensados para
aprender la sintaxis, resolver problemas sencillos y familiarizarse con la
programación orientada a objetos.

## Requisitos

- IntelliJ IDEA o Android Studio.
- Un JDK compatible con Kotlin.
- El complemento de Kotlin habilitado en el IDE.

Este repositorio contiene actualmente un módulo de Kotlin puro. Todavía no es
una aplicación Android y no utiliza Gradle ni una interfaz gráfica.

## Cómo ejecutar los ejercicios

1. Abre la carpeta del proyecto en IntelliJ IDEA o Android Studio.
2. Abre uno de los archivos de la carpeta `src/`.
3. Busca la función `main` del archivo.
4. Pulsa el icono de ejecución que aparece junto a `main`.
5. Consulta el resultado en la consola.

Cada archivo tiene su propio `main`, por lo que los ejercicios se ejecutan de
forma independiente.

## Estructura del proyecto

```text
Fundamentos/
├── README.md
├── Fundamentos.iml
└── src/
  ├── ArrayLoops.kt
  ├── Clases.kt
  ├── VariablesFunciones.kt
  └── piramide.kt
```

## Contenido del proyecto

- `VariablesFunciones.kt`: variables, constantes, tipos de datos, interpolación
  de cadenas y funciones.
- `ArrayLoops.kt`: arrays, bucles y cálculo iterativo de factoriales.
- `Clases.kt`: clases, propiedades, constructores, bloques `init` y métodos.
- `piramide.kt`: funciones con parámetros por defecto y generación de texto con
  bucles anidados.

## Tipos de datos y variables

Kotlin puede inferir el tipo de una variable:

```kotlin
val nombre = "Andrés" // El tipo String se infiere automáticamente
var edad: Short = 30
val esMayorDeEdad = true
```

- `val` declara una referencia de solo lectura.
- `var` declara una variable cuyo valor puede cambiar.
- Tipos frecuentes: `Byte`, `Short`, `Int`, `Long`, `Float`, `Double`,
  `Boolean`, `Char` y `String`.
- La interpolación (`"Hola, $nombre"`) suele ser más legible que concatenar
  cadenas con `+`.

## Null safety

Kotlin distingue entre valores que pueden ser nulos y valores que no:

```kotlin
var ciudad: String? = null
println(ciudad?.length)
```

- `String?` permite `null`.
- `?.` ejecuta una operación solo si el valor no es nulo.
- `?:` proporciona un valor alternativo: `ciudad?.length ?: 0`.
- `!!` fuerza un valor no nulo y puede provocar una excepción; debe evitarse
  salvo que la condición esté garantizada.

## Operadores y control de flujo

Kotlin incluye operadores aritméticos, de comparación y lógicos:

```kotlin
if (edad >= 18 && esMayorDeEdad) {
    println("Es mayor de edad")
} else {
    println("Es menor de edad")
}
```

También se pueden usar expresiones `when` para seleccionar entre varias
opciones:

```kotlin
val resultado = when (edad) {
    in 0..17 -> "Menor de edad"
    else -> "Mayor de edad"
}
```

Bucles habituales:

```kotlin
for (numero in 1..4) println(numero)
while (condicion) { /* repetir mientras se cumpla la condición */ }
```

Los rangos pueden ser descendentes (`4 downTo 1`) o avanzar de dos en dos
(`1..10 step 2`).

## Arrays y colecciones

Un `Array` tiene un tamaño fijo:

```kotlin
val numeros = arrayOf(1, 2, 3, 4, 5)
println(numeros[0])
```

Para colecciones de uso general:

- `List`: colección ordenada de solo lectura.
- `MutableList`: lista cuyos elementos se pueden añadir o eliminar.
- `Set`: colección sin elementos repetidos.
- `Map`: colección de pares clave-valor.

```kotlin
val nombres = listOf("Ana", "Luis")
val edades = mapOf("Ana" to 30, "Luis" to 25)
```

## Funciones

Una función agrupa instrucciones y puede recibir parámetros y devolver un
resultado:

```kotlin
fun sumar(primerNumero: Int, segundoNumero: Int): Int {
    return primerNumero + segundoNumero
}
```

La última expresión puede utilizarse como retorno:

```kotlin
fun doble(numero: Int) = numero * 2
```

También existen parámetros con valores por defecto, argumentos con nombre y
funciones de extensión. El archivo `piramide.kt` incluye un parámetro por
defecto en `piramide(niveles: Int = 1)`.

## Programación orientada a objetos

La programación orientada a objetos organiza el código en clases y objetos.

- **Clase**: plantilla que define propiedades y comportamientos.
- **Objeto**: instancia concreta de una clase.
- **Propiedad**: dato asociado a un objeto.
- **Método**: función definida dentro de una clase.
- **Constructor primario**: se declara junto al nombre de la clase.
- **Constructor secundario**: se declara dentro del cuerpo de la clase y debe
  delegar en otro constructor mediante `this`.
- **`init`**: bloque que se ejecuta al crear una instancia y permite validar o
  preparar su estado inicial.

Ejemplo:

```kotlin
class Persona(val nombre: String, var edad: Int) {
    init {
        require(edad >= 0) { "La edad no puede ser negativa" }
    }

    fun presentarse() = "Soy $nombre y tengo $edad años"
}
```

## Modificadores de acceso

- `public`: visibilidad predeterminada; se puede acceder desde cualquier lugar
  donde el elemento sea visible.
- `private`: limita el acceso al archivo o a la clase que lo declara.
- `protected`: permite el acceso dentro de la clase y de sus subclases.
- `internal`: permite el acceso dentro del mismo módulo de Kotlin.

## Herencia y palabras reservadas

Las clases y métodos son `final` por defecto. Para permitir herencia se utiliza
`open`, y para proporcionar una implementación nueva se utiliza `override`:

```kotlin
open class Animal {
    open fun sonido() = "..."
}

class Perro : Animal() {
    override fun sonido() = "Guau"
}
```

Otros modificadores importantes:

- `abstract`: declara clases o funciones sin implementación completa.
- `operator`: permite definir el comportamiento de operadores para un tipo.
- `infix`: permite llamar ciertas funciones con una sintaxis más breve.
- `data`: genera automáticamente métodos útiles para clases que representan
  datos, como `toString`, `equals` y `copy`.
- `sealed`: restringe las subclases permitidas y resulta útil junto con
  `when`.
- `tailrec`: marca funciones recursivas de cola que el compilador puede
  optimizar.
- `suspend`: marca funciones que pueden suspenderse dentro de corrutinas.

## Buenas prácticas

- Usa `val` siempre que no necesites reasignar una variable.
- Prefiere nombres descriptivos en `camelCase`, como `calcularFactorial`.
- Valida los datos de entrada en los límites de las funciones y clases.
- Evita `!!` cuando puedas resolver el caso nulo de forma segura.
- Separa la lógica de cálculo de la impresión por consola cuando el código
  crezca.
- Añade pruebas para casos normales, valores límite y entradas inválidas.

## Ejercicios propuestos

Después de revisar los ejemplos actuales, puedes practicar con estos retos:

- Crear una función que indique si un número es par o impar.
- Calcular el promedio de los elementos de un array.
- Encontrar el número mayor y el menor de una colección.
- Invertir una cadena de texto.
- Crear una clase `Libro` con título, autor y año de publicación.
- Crear una clase `CuentaBancaria` con operaciones para ingresar y retirar
  dinero.
- Modificar `piramide` para que reciba el carácter que debe imprimir.
- Generar una pirámide invertida.

## Progreso

- [x] Variables y constantes
- [x] Tipos de datos
- [x] Funciones
- [x] Arrays
- [x] Bucles
- [x] Clases y constructores
- [x] Bloques `init`
- [ ] Colecciones avanzadas
- [ ] Herencia e interfaces
- [ ] Excepciones
- [ ] Funciones lambda
- [ ] Corrutinas
- [ ] Pruebas unitarias

## Próximos pasos hacia Android

Una vez consolidados estos fundamentos, el siguiente paso puede ser crear un
proyecto Android con Gradle y aprender a:

- Diseñar interfaces con XML o Jetpack Compose.
- Responder a eventos de botones y otros controles.
- Comprender el ciclo de vida de una actividad.
- Separar la interfaz y la lógica mediante `ViewModel`.
- Gestionar datos y estados de la aplicación.