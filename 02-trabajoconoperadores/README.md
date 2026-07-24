# Trabajo con Operadores en Kotlin

Este proyecto es una aplicación Android sencilla desarrollada como parte del curso "Android con Kotlin" de Píldoras Informáticas. El objetivo principal es demostrar el uso de operadores lógicos, relacionales y estructuras de control en Kotlin.

## Descripción

La aplicación permite al usuario ingresar una edad y, basándose en ese valor, muestra diferentes mensajes utilizando lógica condicional (`if`, `else`, `when`) y operadores (`&&`, `||`, `!`).

### Funcionalidades
- Ingreso de edad a través de un campo de texto.
- Botones para incrementar y decrementar la edad manualmente.
- Evaluación dinámica de la edad para mostrar mensajes como:
    - Verificación de mayoría de edad.
    - Descuentos en abonos de transporte según rangos de edad.
    - Validación de rangos lógicos para permisos de conducir.

## Tecnologías Utilizadas

- **Lenguaje:** Kotlin
- **Plataforma:** Android
- **UI:** XML con ViewBinding
- **Mínimo SDK:** 24
- **Target SDK:** 34

## Estructura del Proyecto

- `MainActivity.kt`: Contiene la lógica principal de la aplicación, manejo de eventos de clic y evaluación de condiciones.
- `ActivityMainBinding`: Utilizado para acceder de forma segura a los componentes de la interfaz de usuario.

---
*Este proyecto es para fines educativos.*
