# Proyecto Casas - Android con Kotlin

Este es un proyecto de práctica desarrollado como parte del curso de **Píldoras Informáticas** para aprender desarrollo de aplicaciones Android utilizando **Kotlin** y **Jetpack Compose**.

El Objetivo del proyecto es aprender a navegar entre pantallas

##  Descripción
La aplicación es una galería interactiva de casas que permite a los usuarios:
- Visualizar una lista de diferentes tipos de viviendas (mediterráneas, rústicas, modernas, etc.).
- Ver detalles específicos de cada casa, incluyendo una imagen ampliada y una descripción.
- Interactuar con la interfaz mediante cambios de colores dinámicos.
- Navegación fluida entre pantallas mediante Jetpack Navigation.

##  Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal.
- **Jetpack Compose**: Toolkit moderno para construir interfaces de usuario nativas.
- **Material Design 3**: Sistema de diseño para una interfaz moderna y coherente.
- **Jetpack Navigation**: Para la gestión de rutas y pantallas.
  - **NavController**: Es el motor principal que gestiona el flujo entre pantallas. Funciona como el "director de orquesta" que sabe en qué pantalla estamos y a cuál queremos ir, manteniendo el historial (la pila) de navegación.
  - **NavHost**: Actúa como el mapa de la aplicación, donde se definen todas las rutas y se vinculan con sus respectivos Composables.
- **State Management**: Uso de `remember`, `mutableStateOf` y `Animatable` para una UI reactiva.

#Pantalla de Inicio
Es el punto central de navegación de la aplicación, diseñada para ser intuitiva y clara.
- **Hub de Navegación**: Uso estratégico de `navController` para dirigir al usuario a las distintas secciones (Galería, Información y Registro).
- **Layout Limpio**: Implementación de `Scaffold` y `Arrangement.Center` para una presentación profesional y equilibrada.

## Pantalla de Galería
Muestra el catálogo completo de casas utilizando componentes optimizados de Jetpack Compose.
- **Lazy Loading**: Uso de `LazyColumn` para garantizar un rendimiento fluido incluso con listas extensas.
- **Navegación con Argumentos**: Las tarjetas (`Card`) son interactivas y envían el ID de la casa a la pantalla de detalle mediante rutas dinámicas (`detalle/{id}`).
- **Diseño de Listas**: Integración de imágenes escaladas y textos con límites de líneas para mantener la uniformidad visual.

## Pantalla de Detalle y Gestos Avanzados
Es la pantalla más interactiva, donde se profundiza en la información de una vivienda específica.
- **Zoom Interactivo**: Implementación de `pointerInput` con `detectTransformGestures` para permitir pellizcar y ampliar las imágenes.
- **Animaciones de Estado**: Uso de `animateFloatAsState` para que los cambios de escala sean suaves y naturales.
- **Interacción con el Color**: Capacidad de cambiar el color de fondo dinámicamente, demostrando la reactividad de Compose ante cambios de estado.
- **Detección de Taps**: Uso de `onDoubleTap` para resetear el zoom de la imagen de forma instantánea.
- **Manejo de Errores**: Pantalla de contingencia integrada para IDs de casas no existentes.

## Pantalla de Información
Una sección dedicada a los detalles del proyecto y créditos.
- **Flujo de Retorno**: Implementación clara de `popBackStack()` para una navegación hacia atrás coherente.
- **Jerarquía Tipográfica**: Uso de los estilos de `MaterialTheme.typography` para comunicar información de forma estructurada.

## Registro de Casa y Formularios Avanzados
Recientemente se ha integrado una nueva pantalla de **Registro de Casa**, donde se han aplicado conceptos avanzados de formularios en Jetpack Compose:

### Nuevas Tecnologías y Conceptos
- **API de `TextFieldState` (Opción B)**: Migración de la gestión tradicional de texto a la nueva API de Foundation, que ofrece un mejor rendimiento, gestión nativa de selección/cursor y soporte para deshacer/rehacer.
- **Validación Inteligente ("Touched State")**: Implementación de lógica para mostrar errores solo después de que el usuario haya interactuado con el campo (`onFocusChanged`), evitando ruidos visuales al cargar la pantalla.
- **Configuración de Teclado Avanzada**: 
  - **Capitalización**: Uso de `KeyboardCapitalization.Words` para nombres y `.Sentences` para descripciones.
  - **Navegación Fluida**: Implementación de `ImeAction.Next` e `ImeAction.Done` junto con `LocalFocusManager` para saltar entre campos automáticamente.
- **Áreas de Texto (Text Area)**: Uso de `lineLimits` con `TextFieldLineLimits.MultiLine` para permitir descripciones extensas con altura mínima y máxima controlada.
- **Mensajes de Soporte Dinámicos**: Uso de `supportingText` para mostrar mensajes de error específicos y contextuales debajo de cada campo.

## Estructura del Proyecto
```text
proyectocasas/
├── app/
│   └── src/main/java/com/example/proyectocasas/
│       ├── data/
│       │   └── Casa.kt (Modelo y Repositorio)
│       ├── ui/
│       │   ├── pantallas/
│       │   │   ├── PantallaDetalle.kt
│       │   │   ├── PantallaGaleria.kt
│       │   │   ├── PantallaInfo.kt
│       │   │   ├── PantallaInicio.kt
│       │   │   └── PantallaRegistroCasa.kt
│       │   └── theme/
│       │       ├── Color.kt
│       │       ├── Theme.kt
│       │       └── Type.kt
│       └── MainActivity.kt
└── README.md
```

- `ui/pantallas/`: Contiene los composables de cada pantalla (`Inicio`, `Galeria`, `Detalle`, `Info`, `RegistroCasa`).
- `data/`: Repositorio y modelos de datos para las casas.
- `ui/theme/`: Configuración de colores, tipografía y temas de la aplicación.

---
Desarrollado con ❤️ durante el aprendizaje de Android con Kotlin.
