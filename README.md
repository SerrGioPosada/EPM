# Sistema de Gestión EPM

Sistema de gestión empresarial para EPM (Empresas Públicas de Medellín) desarrollado con JavaFX 17.0.6.

> **Nota:** Este proyecto contiene únicamente las interfaces de usuario (vistas) desarrolladas con JavaFX, Java y CSS. La lógica de negocio y conexión a base de datos no están implementadas.

## 🚀 Tecnologías

- **Java 25**
- **JavaFX 17.0.6**
- **Maven** (gestión de dependencias)
- **CSS** (estilos personalizados)

## 📋 Requisitos

- JDK 25 o superior
- Maven 3.8+
- JavaFX 17.0.6 (incluido en dependencias)

## 🏗️ Estructura del Proyecto

### Módulos Principales

El sistema está organizado en 7 módulos funcionales:

#### 1. **Gestión Financiera y Contable**
- Control Presupuestal
- Estados Financieros
- Ficha de Activo

#### 2. **Gestión del Talento Humano**
- Gestión de Personal y Nómina
- Reportes de RRHH
- Consulta de Colilla de Pago
- Solicitud de Vacaciones

#### 3. **Gestión Comercial y de Clientes**
- Gestión de PQRS (Peticiones, Quejas, Reclamos y Sugerencias)
- Contratos y Facturación
- Registro de PQR
- Vista 360° del Cliente

#### 4. **Gestión de Proyectos y Planeación**
- Asignación de Recursos
- Control de Avance de Proyectos

#### 5. **Gestión Documental y Archivo**
- Búsqueda de Documentos
- Control de Versiones y Digitalización

#### 6. **I+D+i (Investigación, Desarrollo e Innovación)**
- Banco de Ideas
- Medición de Impacto

#### 7. **Gestión Ambiental y Sostenibilidad**
- Monitoreo Ambiental y Consumo Energético
- Gestión de Residuos RAEE

### Vistas Adicionales

- **Login** - Pantalla de autenticación
- **Dashboard** - Panel principal con información del empleado
- **Inicio** - Vista de bienvenida con acciones rápidas

## 📁 Estructura de Archivos

```
src/main/
├── java/co/edu/uniquindio/poo/epm/
│   ├── HelloApplication.java       # Clase principal
│   ├── HelloController.java        # Controlador principal
│   └── model/                      # Modelos de datos
│       ├── Empleado.java
│       ├── MovimientoPresupuestal.java
│       ├── PQR.java
│       ├── Factura.java
│       ├── Mantenimiento.java
│       ├── Recurso.java
│       ├── Documento.java
│       ├── Version.java
│       ├── Proyecto.java
│       ├── RAEE.java
│       ├── ProyectoSocial.java
│       ├── Departamento.java
│       ├── EstadoFinanciero.java
│       ├── Contrato.java
│       └── Vacacion.java
│
└── resources/co/edu/uniquindio/poo/epm/
    ├── *.fxml                      # Archivos de vista (28 archivos)
    ├── Style.css                   # Estilos globales
    ├── Epm-1.png                   # Logo circular EPM
    └── images.png                  # Logo cuadrado EPM
```

## 🎨 Características de la UI

- **Diseño Responsivo** - La ventana se adapta al tamaño de la pantalla
- **Navegación Lateral** - Sidebar con módulos desplegables
- **Indicadores Visuales** - Resaltado de la vista activa en el menú
- **Tablas Dinámicas** - 17 tablas con datos de ejemplo
- **Gráficos** - Charts para visualización de datos
- **Tema Corporativo** - Colores verde EPM (#1B5E20, #43A047, #66BB6A)
- **Logo Institucional** - Presente en login, header, sidebar y dashboard

## 🚀 Ejecución

### Compilar el proyecto

```bash
./mvnw clean compile
```

### Ejecutar la aplicación

```bash
./mvnw javafx:run
```

O desde tu IDE favorito, ejecutar la clase `HelloApplication.java`

## 📊 Datos de Ejemplo

Todas las tablas y vistas contienen datos quemados (hardcoded) para demostración:
- Empleados de ejemplo
- Movimientos presupuestales ficticios
- PQRs de muestra
- Facturas simuladas
- Proyectos demo
- Y más...

## 🎯 Estado del Proyecto

**Completado:**
- ✅ Todas las interfaces de usuario (28 vistas)
- ✅ Navegación entre vistas
- ✅ Estilos CSS personalizados
- ✅ Datos de ejemplo en todas las tablas
- ✅ Gráficos funcionales
- ✅ Sidebar interactivo
- ✅ Branding corporativo

**Pendiente:**
- ⏳ Lógica de negocio
- ⏳ Conexión a base de datos
- ⏳ Validaciones de formularios
- ⏳ Autenticación real
- ⏳ Exportación de reportes
- ⏳ Persistencia de datos

## 📝 Notas

Este proyecto fue desarrollado como ejercicio académico para la materia de Programación 2. Se enfoca en el diseño de interfaces de usuario con JavaFX y no incluye funcionalidad backend.

## 👥 Autor

Desarrollado para EPM - Empresas Públicas de Medellín

---

**Universidad del Quindío**
Programación 2 - 2025
