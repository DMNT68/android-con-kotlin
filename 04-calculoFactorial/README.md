# Cálculo Factorial

Esta es una aplicación Android sencilla escrita en Kotlin que calcula el factorial de un número ingresado por el usuario.

## Características

- Interfaz de usuario simple para ingresar un número.
- Cálculo de factorial mediante un bucle iterativo.
- Manejo básico de errores para entradas no numéricas.

## Conceptos Aprendidos

Durante el desarrollo de este proyecto se pusieron en práctica los siguientes conceptos de Android y Kotlin:

- **Vinculación de Vistas:** Uso de `findViewById` para interactuar con elementos del layout XML.
- **Manejo de Eventos:** Implementación de `setOnClickListener` para capturar la interacción del usuario con botones.
- **Captura de Datos:** Obtención y procesamiento de texto desde un `EditText`.
- **Lógica en Kotlin:** Uso de bucles (`for`), tipos de datos de gran tamaño (`Long`) y funciones personalizadas.
- **Seguridad de Tipos:** Conversión de Strings a Números usando `toIntOrNull()` para evitar cierres inesperados (crashes).
- **Diseño Moderno:** Implementación de `enableEdgeToEdge()` para una interfaz que aprovecha toda la pantalla.
- **Plantillas de Strings:** Uso de la interpolación de variables en cadenas de texto.

## Tecnologías Utilizadas

- **Lenguaje:** Kotlin
- **Framework:** Android SDK (AppCompat, Activity KTX)
- **UI:** XML Layouts con Edge-to-Edge habilitado.

## Estructura del Proyecto

```text
CalculoFactorial/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/calculofactorial/
│   │       │   └── MainActivity.kt        # Lógica principal y cálculo
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml  # Interfaz de usuario
│   │       │   └── values/                # Strings y temas
│   │       └── AndroidManifest.xml        # Configuración de la app
│   └── build.gradle.kts                   # Dependencias del módulo
├── build.gradle.kts                       # Configuración raíz
├── settings.gradle.kts                    # Configuración de módulos
└── README.md                              # Documentación
```
