# TiendaEnLinea

Aplicación de consola en Java que simula una tienda en línea. Permite registrar clientes y productos (físicos y digitales), crear pedidos, listar entidades y realizar consultas usando Java Streams.

## Requisitos

- Java JDK 17 o superior (recomendado)
- Sistema operativo: Windows, macOS o Linux
- Opcional: IntelliJ IDEA o cualquier IDE compatible con proyectos Java

## Estructura del proyecto

```
TiendaEnLinea/
├─ src/
│  └─ co/tiendaenlinea/
│     ├─ Main.java
│     ├─ util/
│     │  └─ Menu.java
│     ├─ patron/
│     │  ├─ Tienda.java
│     │  └─ ProductoFactory.java
│     └─ modelo/
│        ├─ Usuario.java
│        ├─ Cliente.java
│        ├─ Producto.java
│        ├─ ProductoFisico.java
│        ├─ ProductoDigital.java
│        └─ Pedido.java
└─ README.md
```

## Descripción y funcionalidades

- __Menú interactivo__ (`co.tiendaenlinea.util.Menu`):
  - Registrar cliente
  - Registrar producto (tipo "fisico" o "digital")
  - Crear pedido para un cliente
  - Ver productos con precio mayor a un límite
  - Buscar clientes por texto contenido en el nombre
  - Mostrar solo nombres de productos
  - Listar clientes y pedidos

- __Punto de entrada__ (`co.tiendaenlinea.Main`): inicia el menú con `new Menu().iniciar()`.

- __Lógica de negocio__ (`co.tiendaenlinea.patron.Tienda`):
  - Patrón Singleton para mantener instancias únicas de listas en memoria.
  - Maneja colecciones de `Cliente`, `Producto` y `Pedido`.
  - Uso de Streams para filtros y mapeos (por ejemplo, `mostrarProductosCaros`, `buscarClientesPorNombre`, `obtenerNombresDeProductos`).

- __Factory de productos__ (`co.tiendaenlinea.patron.ProductoFactory`):
  - Crea instancias de `ProductoFisico` o `ProductoDigital` según el tipo.

- __Modelo__ (`co.tiendaenlinea.modelo`):
  - `Usuario` (base), `Cliente` (extiende Usuario),
    `Producto` (abstracta), `ProductoFisico`, `ProductoDigital`, `Pedido`.

## Cómo compilar y ejecutar (línea de comandos)

Desde la raíz del proyecto (`TiendaEnLinea/`):

1) Compilar:

```bash
# Windows PowerShell o CMD
javac -d out -sourcepath src src/co/tiendaenlinea/Main.java
```

2) Ejecutar:

```bash
# Windows PowerShell o CMD
java -cp out co.tiendaenlinea.Main
```

Notas:
- La opción `-d out` generará los `.class` en la carpeta `out/` respetando el paquete.
- Si prefieres limpiar `out/` antes de compilar, elimínala manualmente.

## Cómo ejecutar en IntelliJ IDEA

1. Abrir el directorio del proyecto `TiendaEnLinea/` en IntelliJ.
2. Asegurarte de que `src/` está marcado como "Sources Root" (clic derecho > Mark Directory as > Sources Root).
3. Abrir `co/tiendaenlinea/Main.java` y ejecutar la clase `Main` (botón ▶).

## Uso del programa (flujo básico)

Al ejecutar, verás el menú:

```
========= MENÚ TIENDA EN LÍNEA =========
1. Registrar cliente
2. Registrar producto
3. Crear pedido
4. Ver productos caros
5. Buscar clientes por nombre
6. Mostrar nombres de productos
7. Mostrar lista de Clientes
8. Mostrar lista de Pedidos
9. Salir
```

- Para productos:
  - Tipo: escribe `fisico` o `digital`.
  - Para `fisico`, el campo extra solicitado es Peso (kg).
  - Para `digital`, el campo extra solicitado es Tamaño (MB).

- Para crear pedido:
  - Ingresa el ID del cliente existente.
  - Elige un producto por nombre de la lista mostrada.

## Decisiones de diseño y patrones

- __Singleton__ en `Tienda`: garantiza una sola instancia que centraliza las listas y operaciones.
- __Factory Method__ en `ProductoFactory`: encapsula la creación de productos por tipo.
- __Streams API__: consultas y transformaciones concisas sobre colecciones.

## Limitaciones y mejoras sugeridas

- Persistencia en memoria: los datos se pierden al cerrar el programa. Podría agregarse almacenamiento en archivo/BD.
- Validaciones: hoy se asume entrada válida en varios puntos, se puede fortalecer manejo de errores.
- IDs: `Pedido` usa un ID aleatorio simple; se puede migrar a un generador incremental o UUID.
- Carrito por pedido: actualmente agrega un solo producto por flujo; se podría permitir múltiples productos durante la creación del pedido.

## Licencia

Proyecto académico. Para el Curso de Programación Orientada a Objetos II de la IU Digital de Antioquia.
