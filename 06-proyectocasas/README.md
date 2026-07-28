# Proyecto Casas - Android con Kotlin

Este es un proyecto de práctica desarrollado como parte del curso de **Píldoras Informáticas** para aprender desarrollo de aplicaciones Android utilizando **Kotlin** y **Jetpack Compose**.

El objetivo del proyecto es aprender a construir interfaces modernas, gestionar el estado y navegar entre pantallas de forma eficiente.

## Descripción
La aplicación es una galería interactiva de casas que permite a los usuarios:
- Visualizar una lista de diferentes tipos de viviendas (mediterráneas, rústicas, modernas, etc.).
- Ver detalles específicos de cada casa, incluyendo una imagen ampliada y una descripción.
- Interactuar con la interfaz mediante cambios de colores dinámicos y gestos.
- Registrar nuevas casas mediante un formulario avanzado con validaciones.

## Tecnologías y Conceptos Aplicados

### Arquitectura y UI
- **Jetpack Compose**: El toolkit moderno de Android para interfaces declarativas.
- **Material Design 3**: Implementación de temas dinámicos, tipografía y componentes (Scaffold, Card, Button, TopAppBar).
- **Lazy Loading**: Uso de LazyColumn para renderizar listas eficientes con reciclaje de vistas.

### Navegación (Jetpack Navigation)
- **NavController**: Gestión centralizada del flujo de la aplicación y la pila de retroceso (backstack).
- **NavHost**: Definición del grafo de navegación y mapeo de rutas.
- **Navegación con Argumentos**: Paso de parámetros dinámicos entre pantallas (detalle/{casaId}).
- **popBackStack**: Gestión de retorno programático a pantallas anteriores.

### Gestión de Estado (State Management)
- **remember & mutableStateOf**: Preservación del estado local durante la recomposición.
- **Hoisting de Estado**: Patrón para mover el estado a composables superiores y mejorar la reusabilidad.
- **TextFieldState**: Uso de la nueva API de Foundation para una gestión de texto más potente y eficiente.
- **Listas Mutables Observables**: Uso de `mutableStateListOf` en el repositorio para garantizar que la interfaz se actualice automáticamente al añadir nuevas casas.

### Animaciones y Gestos
- **animateFloatAsState**: Animaciones fluidas para propiedades como la escala y la transparencia.
- **pointerInput**: Captura de eventos de bajo nivel para gestos personalizados.
  - **detectTransformGestures**: Implementación de zoom (pellizco) en imágenes.
  - **detectTapGestures**: Detección de toques dobles para resetear el estado de la UI.
- **graphicsLayer**: Aplicación de transformaciones visuales (escala, rotación) sin afectar el layout general.

### Formularios y Validación
- **ImeAction & FocusManager**: Control avanzado del teclado y salto automático entre campos.
- **Validación en Tiempo Real**: Uso de estados de "tocado" (onFocusChanged) para mostrar errores solo cuando es necesario.
- **lineLimits**: Configuración de áreas de texto con límites de crecimiento dinámicos.
- **ActivityResult API**: Uso de rememberLauncherForActivityResult para seleccionar imágenes de la galería del dispositivo.
- **Habilitación Condicional**: Lógica para habilitar el botón de acción solo cuando los datos cumplen con los requisitos mínimos (nombre, longitud de descripción e imagen seleccionada).
- **Persistencia Dinámica**: Implementación de la creación de objetos de datos en tiempo de ejecución y su inserción en el repositorio global.

### Librerías Externas
- **Coil**: Carga de imágenes asíncrona desde URLs o recursos locales (rememberAsyncImagePainter).

## Estructura del Proyecto
```text
proyectocasas/
├── app/
│   └── src/main/java/com/example/proyectocasas/
│       ├── data/
│       │   └── Casa.kt (Modelo y Repositorio de datos)
│       ├── ui/
│       │   ├── pantallas/
│       │   │   ├── PantallaDetalle.kt      (Zoom, Gestos, Animaciones)
│       │   │   ├── PantallaGaleria.kt      (Listas, Cards)
│       │   │   ├── PantallaInfo.kt         (Créditos)
│       │   │   ├── PantallaInicio.kt       (Menú Principal)
│       │   │   └── PantallaRegistroCasa.kt (Formulario, Validaciones, Cámara/Galería)
│       │   └── theme/
│       │       ├── Color.kt, Theme.kt, Type.kt (Diseño de Marca)
│       └── MainActivity.kt (Configuración de NavHost)
└── README.md
```

---
Desarrollado durante el aprendizaje de Android con Kotlin.
