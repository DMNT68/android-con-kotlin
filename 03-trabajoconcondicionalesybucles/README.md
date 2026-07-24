# Trabajo con Condicionales y Bucles

Este proyecto es una aplicación de Android desarrollada en Kotlin que implementa un juego de "Adivina el Número". Es parte del curso de Android con Kotlin de Píldoras Informáticas.

## Descripción

La aplicación genera un número aleatorio entre 1 y 100, y el usuario debe intentar adivinarlo. La aplicación proporciona pistas indicando si el número introducido es mayor o menor que el número secreto.

### Características

- **Generación de número aleatorio:** Utiliza `Random.nextInt(1, 101)`.
- **Control de intentos:** Cuenta cuántas veces ha intentado el usuario adivinar el número.
- **Validación de entrada:** Maneja casos donde el usuario no introduce un número válido.
- **Reiniciar juego:** Permite empezar una nueva partida una vez que se ha adivinado el número.
- **Interfaz de usuario simple:** Utiliza `EditText`, `Button`, `TextView` y `Toast`.

## Estructura del Proyecto

```text
.
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/trabajoconcondicionalesybucles/
│   │       │   └── MainActivity.kt (Lógica principal del juego)
│   │       ├── res/layout/
│   │       │   └── activity_main.xml (Diseño de la interfaz)
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

- `MainActivity.kt`: Contiene la lógica principal del juego, incluyendo el manejo de eventos de los botones y la lógica de comparación.
- `activity_main.xml`: Define el diseño de la interfaz de usuario.

## Aprendizajes

Este ejercicio pone en práctica conceptos fundamentales de Kotlin y Android:
- Declaración de variables (`val`, `var`).
- Estructuras condicionales (`if`, `else if`, `else`).
- Manejo de nulidad (`toIntOrNull()`).
- Interacción con componentes de la UI (View Binding manual con `findViewById`).
- Manejo de eventos (`setOnClickListener`).
- Uso de `Toast` para notificaciones breves.
