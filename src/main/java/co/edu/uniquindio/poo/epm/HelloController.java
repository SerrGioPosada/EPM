package co.edu.uniquindio.poo.epm;

import co.edu.uniquindio.poo.epm.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Controller básico para navegación entre vistas de EPM
 * Este controller maneja la navegación simple sin validaciones
 */
public class HelloController {

    // Singleton instance para compartir entre vistas
    private static HelloController instance;

    // ===== Index.fxml Components =====
    @FXML
    private StackPane paneIndex;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Button btnNavLogin;

    @FXML
    private Button btnNavDashboard;

    // ===== Login.fxml Components =====
    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPasswordVisible;

    @FXML
    private CheckBox chkKeepSignedIn;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    private Label lblForgotPassword;

    @FXML
    private Label lblEmailFloat;

    @FXML
    private Label lblPasswordFloat;

    // ===== Sidebar.fxml Components =====
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnColillaPago;

    @FXML
    private Button btnVacaciones;

    @FXML
    private Button btnVista360;

    @FXML
    private Button btnPQR;

    @FXML
    private Button btnActivos;

    @FXML
    private Button btnLogout;

    @FXML
    private Label lblUserName;

    // ===== Sidebar Module Components =====
    @FXML
    private Button btnModuloFinanciero;
    @FXML
    private VBox vboxModuloFinanciero;
    
    @FXML
    private Button btnModuloTalento;
    @FXML
    private VBox vboxModuloTalento;
    
    @FXML
    private Button btnModuloComercial;
    @FXML
    private VBox vboxModuloComercial;
    
    @FXML
    private Button btnModuloProyectos;
    @FXML
    private VBox vboxModuloProyectos;
    
    @FXML
    private Button btnModuloDocumental;
    @FXML
    private VBox vboxModuloDocumental;
    
    @FXML
    private Button btnModuloIDi;
    @FXML
    private VBox vboxModuloIDi;
    
    @FXML
    private Button btnModuloAmbiental;
    @FXML
    private VBox vboxModuloAmbiental;

    // ===== Sidebar Subitem Buttons =====
    @FXML
    private Button btnControlPresupuestal;
    @FXML
    private Button btnEstadosFinancieros;
    @FXML
    private Button btnGestionPersonal;
    @FXML
    private Button btnReporteRRHH;
    @FXML
    private Button btnGestionPQRS;
    @FXML
    private Button btnContratos;
    @FXML
    private Button btnAsignacionRecursos;
    @FXML
    private Button btnControlAvance;
    @FXML
    private Button btnBusquedaDocumentos;
    @FXML
    private Button btnControlVersiones;
    @FXML
    private Button btnBancoIdeas;
    @FXML
    private Button btnMedicionImpacto;
    @FXML
    private Button btnMonitoreoAmbiental;
    @FXML
    private Button btnGestionResiduos;

    // ===== TableView References =====
    @FXML
    private TableView<Empleado> tblEmployees;

    @FXML
    private TableView<PQR> tblPQRHistory;

    @FXML
    private TableView<MovimientoPresupuestal> tblBudgetMovements;

    @FXML
    private TableView<RegistroMantenimiento> tblMaintenanceHistory;

    @FXML
    private TableView<Factura> tblBillingHistory;

    @FXML
    private TableView<Factura> tblBilling;

    @FXML
    private TableView<Recurso> tblResources;

    @FXML
    private TableView<Documento> tblResults;

    @FXML
    private TableView<Version> tblVersions;

    @FXML
    private TableView<ProyectoIDi> tblProjects;

    @FXML
    private TableView<RAEE> tblRAEE;

    @FXML
    private TableView<ProyectoSocial> tblSocialProjects;

    @FXML
    private TableView<Departamento> tblDepartments;

    @FXML
    private TableView<BalanceSheet> tblBalanceSheet;

    @FXML
    private TableView<PQRGestion> tblPQRS;

    @FXML
    private TableView<Contrato> tblContratos;

    @FXML
    private TableView<SolicitudVacaciones> tblVacationHistory;

    @FXML
    private TableView<PQR> tblRecentPQR;

    // ===== Chart References =====
    @FXML
    private LineChart<String, Number> chartEnvironmental;

    @FXML
    private javafx.scene.chart.BarChart<String, Number> chartCapacitacion;

    @FXML
    private javafx.scene.chart.BarChart<String, Number> chartGantt;

    @FXML
    private javafx.scene.chart.BarChart<String, Number> chartDigitalization;

    @FXML
    private javafx.scene.chart.BarChart<String, Number> chartImpacto;

    /**
     * Toggle para Módulo Financiero
     */
    @FXML
    public void toggleModuloFinanciero(ActionEvent event) {
        toggleModule(vboxModuloFinanciero, btnModuloFinanciero);
    }

    /**
     * Toggle para Módulo Talento Humano
     */
    @FXML
    public void toggleModuloTalento(ActionEvent event) {
        toggleModule(vboxModuloTalento, btnModuloTalento);
    }

    /**
     * Toggle para Módulo Comercial
     */
    @FXML
    public void toggleModuloComercial(ActionEvent event) {
        toggleModule(vboxModuloComercial, btnModuloComercial);
    }

    /**
     * Toggle para Módulo Proyectos
     */
    @FXML
    public void toggleModuloProyectos(ActionEvent event) {
        toggleModule(vboxModuloProyectos, btnModuloProyectos);
    }

    /**
     * Toggle para Módulo Documental
     */
    @FXML
    public void toggleModuloDocumental(ActionEvent event) {
        toggleModule(vboxModuloDocumental, btnModuloDocumental);
    }

    /**
     * Toggle para Módulo I+D+i
     */
    @FXML
    public void toggleModuloIDi(ActionEvent event) {
        toggleModule(vboxModuloIDi, btnModuloIDi);
    }

    /**
     * Toggle para Módulo Ambiental
     */
    @FXML
    public void toggleModuloAmbiental(ActionEvent event) {
        toggleModule(vboxModuloAmbiental, btnModuloAmbiental);
    }

    /**
     * Método auxiliar para expandir/colapsar módulos
     */
    private void toggleModule(VBox moduleBox, Button moduleButton) {
        if (moduleBox != null && moduleButton != null) {
            boolean isVisible = moduleBox.isVisible();
            moduleBox.setVisible(!isVisible);
            moduleBox.setManaged(!isVisible);
            
            // Cambiar el ícono de flecha
            String currentText = moduleButton.getText();
            if (isVisible) {
                moduleButton.setText(currentText.replace("▲", "▼"));
            } else {
                moduleButton.setText(currentText.replace("▼", "▲"));
            }
        }
    }

    /**
     * Métodos para mostrar las vistas de cada módulo
     */
    @FXML
    public void handleShowControlPresupuestal(ActionEvent event) {
        showSidebar(true);
        loadView("ControlPresupuestal.fxml");
        updateSidebarActiveState(btnControlPresupuestal);
    }

    @FXML
    public void handleShowEstadosFinancieros(ActionEvent event) {
        showSidebar(true);
        loadView("EstadosFinancieros.fxml");
        updateSidebarActiveState(btnEstadosFinancieros);
    }

    @FXML
    public void handleShowGestionPersonal(ActionEvent event) {
        showSidebar(true);
        loadView("GestionPersonal.fxml");
        updateSidebarActiveState(btnGestionPersonal);
    }

    @FXML
    public void handleShowReporteRRHH(ActionEvent event) {
        showSidebar(true);
        loadView("ReporteRRHH.fxml");
        updateSidebarActiveState(btnReporteRRHH);
    }

    @FXML
    public void handleShowGestionPQRS(ActionEvent event) {
        showSidebar(true);
        loadView("GestionPQRS.fxml");
        updateSidebarActiveState(btnGestionPQRS);
    }

    @FXML
    public void handleShowContratos(ActionEvent event) {
        showSidebar(true);
        loadView("Contratos.fxml");
        updateSidebarActiveState(btnContratos);
    }

    @FXML
    public void handleShowAsignacionRecursos(ActionEvent event) {
        showSidebar(true);
        loadView("AsignacionRecursos.fxml");
        updateSidebarActiveState(btnAsignacionRecursos);
    }

    @FXML
    public void handleShowControlAvance(ActionEvent event) {
        showSidebar(true);
        loadView("ControlAvance.fxml");
        updateSidebarActiveState(btnControlAvance);
    }

    @FXML
    public void handleShowBusquedaDocumentos(ActionEvent event) {
        showSidebar(true);
        loadView("BusquedaDocumentos.fxml");
        updateSidebarActiveState(btnBusquedaDocumentos);
    }

    @FXML
    public void handleShowControlVersiones(ActionEvent event) {
        showSidebar(true);
        loadView("ControlVersiones.fxml");
        updateSidebarActiveState(btnControlVersiones);
    }

    @FXML
    public void handleShowBancoIdeas(ActionEvent event) {
        showSidebar(true);
        loadView("BancoIdeas.fxml");
        updateSidebarActiveState(btnBancoIdeas);
    }

    @FXML
    public void handleShowMedicionImpacto(ActionEvent event) {
        showSidebar(true);
        loadView("MedicionImpacto.fxml");
        updateSidebarActiveState(btnMedicionImpacto);
    }

    @FXML
    public void handleShowMonitoreoAmbiental(ActionEvent event) {
        showSidebar(true);
        loadView("MonitoreoAmbiental.fxml");
        updateSidebarActiveState(btnMonitoreoAmbiental);
    }

    @FXML
    public void handleShowGestionResiduos(ActionEvent event) {
        showSidebar(true);
        loadView("GestionResiduos.fxml");
        updateSidebarActiveState(btnGestionResiduos);
    }

    /**
     * Inicialización del controller
     */
    @FXML
    public void initialize() {
        // Establecer esta instancia como la instancia singleton si tiene el paneIndex
        if (paneIndex != null) {
            instance = this;
            showSidebar(false); // Ocultar sidebar en el login
            loadView("Login.fxml");
            // NO inicializar tablas en la instancia principal
            return;
        }

        // Esta es una vista secundaria - inicializar sus datos
        initializeCurrentView();
    }

    /**
     * Inicializa las tablas y gráficos de la vista actual
     */
    private void initializeCurrentView() {
        if (tblEmployees != null) {
            initializeEmployeeTable();
        }
        if (tblPQRHistory != null) {
            initializePQRHistoryTable();
        }
        if (tblBudgetMovements != null) {
            initializeBudgetMovementsTable();
        }
        if (tblMaintenanceHistory != null) {
            initializeMaintenanceHistoryTable();
        }
        if (tblBillingHistory != null) {
            initializeBillingHistoryTable();
        }
        if (tblBilling != null) {
            initializeBillingTable();
        }
        if (tblResources != null) {
            initializeResourcesTable();
        }
        if (tblResults != null) {
            initializeDocumentsTable();
        }
        if (tblVersions != null) {
            initializeVersionsTable();
        }
        if (tblProjects != null) {
            initializeProjectsTable();
        }
        if (tblRAEE != null) {
            initializeRAEETable();
        }
        if (tblSocialProjects != null) {
            initializeSocialProjectsTable();
        }
        if (chartEnvironmental != null) {
            initializeEnvironmentalChart();
        }
        if (chartDigitalization != null) {
            initializeDigitalizationChart();
        }
        if (tblDepartments != null) {
            initializeDepartmentsTable();
        }
        if (tblBalanceSheet != null) {
            initializeBalanceSheetTable();
        }
        if (tblPQRS != null) {
            initializePQRSTable();
        }
        if (tblContratos != null) {
            initializeContratosTable();
        }
        if (chartCapacitacion != null) {
            initializeCapacitacionChart();
        }
        if (chartGantt != null) {
            initializeGanttChart();
        }
        if (chartImpacto != null) {
            initializeImpactoChart();
        }
        if (tblVacationHistory != null) {
            initializeVacationHistoryTable();
        }
        if (tblRecentPQR != null) {
            initializeRecentPQRTable();
        }
    }

    /**
     * Obtener la instancia principal del controller
     */
    public static HelloController getInstance() {
        return instance;
    }

    /**
     * Maneja el evento de login (sin validación, solo cambia la vista)
     */
    @FXML
    public void handleLogin(ActionEvent event) {
        // Navegación simple: al hacer login, mostrar Dashboard
        showSidebar(true);
        loadView("Dashboard.fxml");
    }

    /**
     * Muestra la vista de Login
     */
    @FXML
    public void handleShowLogin(ActionEvent event) {
        showSidebar(false);
        loadView("Login.fxml");
    }

    /**
     * Muestra el Dashboard
     */
    @FXML
    public void handleShowDashboard(ActionEvent event) {
        showSidebar(true);
        loadView("Dashboard.fxml");
        updateSidebarActiveState(btnDashboard);
    }

    /**
     * Muestra la vista de Consultar Colilla de Pago
     */
    @FXML
    public void handleShowColillaPago(ActionEvent event) {
        showSidebar(true);
        loadView("ConsultarColillaPago.fxml");
        updateSidebarActiveState(btnColillaPago);
    }

    /**
     * Muestra la vista de Solicitar Vacaciones
     */
    @FXML
    public void handleShowVacaciones(ActionEvent event) {
        showSidebar(true);
        loadView("SolicitarVacaciones.fxml");
        updateSidebarActiveState(btnVacaciones);
    }

    /**
     * Muestra la Vista 360 del Cliente
     */
    @FXML
    public void handleShowVista360(ActionEvent event) {
        showSidebar(true);
        loadView("Vista360Cliente.fxml");
        updateSidebarActiveState(btnVista360);
    }

    /**
     * Muestra la vista de Registrar PQR
     */
    @FXML
    public void handleShowPQR(ActionEvent event) {
        showSidebar(true);
        loadView("RegistrarPQR.fxml");
        updateSidebarActiveState(btnPQR);
    }

    /**
     * Muestra la Ficha de Activo
     */
    @FXML
    public void handleShowFichaActivo(ActionEvent event) {
        showSidebar(true);
        loadView("FichaActivo.fxml");
        updateSidebarActiveState(btnActivos);
    }

    /**
     * Toggle del sidebar (para el botón hamburger del menú)
     */
    @FXML
    public void handleToggleSidebar(MouseEvent event) {
        BorderPane targetRoot = (rootPane != null) ? rootPane : (instance != null ? instance.rootPane : null);
        if (targetRoot != null) {
            if (targetRoot.getLeft() == null) {
                showSidebar(true);
            } else {
                showSidebar(false);
            }
        }
    }
    /**
     * Controla la visibilidad del sidebar
     * @param show true para mostrar el sidebar, false para ocultarlo
     */
    private void showSidebar(boolean show) {
        BorderPane targetRoot = (rootPane != null) ? rootPane : (instance != null ? instance.rootPane : null);

        if (targetRoot != null) {
            if (show) {
                // Mostrar el sidebar si no está visible
                if (targetRoot.getLeft() == null) {
                    try {
                        System.out.println("Cargando Sidebar...");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sidebar.fxml"));
                        Node sidebar = loader.load();
                        targetRoot.setLeft(sidebar);
                        System.out.println("Sidebar cargado exitosamente");
                    } catch (IOException e) {
                        System.err.println("Error al cargar el sidebar:");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("El sidebar ya está visible");
                }
            } else {
                // Ocultar el sidebar
                System.out.println("Ocultando sidebar...");
                targetRoot.setLeft(null);
            }
        } else {
            System.err.println("Error: rootPane es null, no se puede controlar el sidebar");
        }
    }

    /**
     * Métodos de inicialización de tablas con datos de ejemplo
     */
    private void initializeEmployeeTable() {
        // Configurar las columnas con CellValueFactory usando lambdas simples que retornan ReadOnlyStringWrapper
        TableColumn<Empleado, String> col0 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getId()));

        TableColumn<Empleado, String> col1 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getNombre()));

        TableColumn<Empleado, String> col2 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCedula()));

        TableColumn<Empleado, String> col3 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCargo()));

        TableColumn<Empleado, String> col4 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getArea()));

        TableColumn<Empleado, String> col5 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getSalario()));

        TableColumn<Empleado, String> col6 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getDesempeno()));

        TableColumn<Empleado, String> col7 = (TableColumn<Empleado, String>) tblEmployees.getColumns().get(7);
        col7.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        // Establecer altura de fila explícita
        tblEmployees.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblEmployees.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Crear y agregar datos
        ObservableList<Empleado> empleados = FXCollections.observableArrayList(
            new Empleado("1001", "Ana María López García", "43.256.789", "Ingeniero Civil", "Proyectos", "$5.800.000", "4.5", "Activo"),
            new Empleado("1002", "Carlos Andrés Gómez", "71.345.678", "Técnico Electricista", "Operaciones", "$3.200.000", "4.2", "Activo"),
            new Empleado("1003", "María Fernanda Ruiz", "52.678.901", "Contador Senior", "Finanzas", "$6.500.000", "4.8", "Activo"),
            new Empleado("1004", "Jorge Luis Martínez", "1.023.456.789", "Analista de Sistemas", "TI", "$4.800.000", "4.1", "Activo"),
            new Empleado("1005", "Laura Patricia Sánchez", "39.876.543", "Especialista Ambiental", "Sostenibilidad", "$5.200.000", "4.6", "Activo"),
            new Empleado("1006", "Diego Fernando Torres", "80.123.456", "Supervisor Técnico", "Mantenimiento", "$4.500.000", "3.9", "Activo"),
            new Empleado("1007", "Valentina Rodríguez", "1.098.765.432", "Abogada Corporativa", "Legal", "$7.200.000", "4.7", "Activo"),
            new Empleado("1008", "Santiago Pérez Díaz", "16.789.012", "Ingeniero Ambiental", "Sostenibilidad", "$5.600.000", "4.3", "Vacaciones")
        );

        tblEmployees.setItems(empleados);
    }

    private void initializeBudgetMovementsTable() {
        if (tblBudgetMovements == null) return;

        // Configurar columnas
        TableColumn<MovimientoPresupuestal, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<MovimientoPresupuestal, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<MovimientoPresupuestal, String> colConcepto = new TableColumn<>("Concepto");
        colConcepto.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getConcepto()));
        colConcepto.setPrefWidth(250);

        TableColumn<MovimientoPresupuestal, String> colMonto = new TableColumn<>("Monto");
        colMonto.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getMonto()));

        TableColumn<MovimientoPresupuestal, String> colSaldo = new TableColumn<>("Saldo");
        colSaldo.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getSaldo()));

        TableColumn<MovimientoPresupuestal, String> colResponsable = new TableColumn<>("Responsable");
        colResponsable.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getResponsable()));
        colResponsable.setPrefWidth(150);

        tblBudgetMovements.getColumns().addAll(colFecha, colTipo, colConcepto, colMonto, colSaldo, colResponsable);

        // Establecer altura de fila explícita
        tblBudgetMovements.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblBudgetMovements.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<MovimientoPresupuestal> movimientos = FXCollections.observableArrayList(
            new MovimientoPresupuestal("01/Nov/2025", "Asignación Inicial", "Presupuesto Proyecto Expansión Red", "12.500.000.000", "12.500.000.000", "Dir. Financiera"),
            new MovimientoPresupuestal("05/Nov/2025", "Ejecución", "Compra de transformadores ABB", "-2.800.000.000", "9.700.000.000", "Ing. Carlos Gómez"),
            new MovimientoPresupuestal("08/Nov/2025", "Ejecución", "Contratación cuadrillas técnicas", "-3.200.000.000", "6.500.000.000", "Jefe RRHH"),
            new MovimientoPresupuestal("10/Nov/2025", "Ejecución", "Materiales de construcción", "-1.500.000.000", "5.000.000.000", "Ing. Ana Martínez"),
            new MovimientoPresupuestal("12/Nov/2025", "Ejecución", "Equipos de medición y control", "-2.500.000.000", "2.500.000.000", "Ing. Carlos Gómez")
        );

        tblBudgetMovements.setItems(movimientos);
    }

    private void initializePQRHistoryTable() {
        if (tblPQRHistory == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<PQR, String> col0 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getRadicado()));

        TableColumn<PQR, String> col1 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<PQR, String> col2 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<PQR, String> col3 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getServicio()));

        TableColumn<PQR, String> col4 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getMotivo()));

        TableColumn<PQR, String> col5 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<PQR, String> col6 = (TableColumn<PQR, String>) tblPQRHistory.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaRespuesta()));

        // Establecer altura de fila explícita
        tblPQRHistory.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblPQRHistory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<PQR> pqrs = FXCollections.observableArrayList(
            new PQR("PQR-2025-08976", "15/Oct/2025", "Reclamo", "Energía", "Facturación elevada sin justificación", "Resuelto", "Ana López"),
            new PQR("PQR-2025-08654", "20/Sep/2025", "Queja", "Agua", "Baja presión en las horas pico", "En Proceso", "Carlos Gómez"),
            new PQR("PQR-2025-07823", "10/Ago/2025", "Petición", "Gas", "Solicitud de revisión de instalación", "Resuelto", "María Ruiz"),
            new PQR("PQR-2025-06754", "05/Jul/2025", "Sugerencia", "General", "Mejora en atención al cliente", "Cerrado", "Jorge Martínez")
        );

        tblPQRHistory.setItems(pqrs);
    }

    private void initializeBillingHistoryTable() {
        if (tblBillingHistory == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<Factura, String> col0 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<Factura, String> col1 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getServicio()));

        TableColumn<Factura, String> col2 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getPeriodo()));

        TableColumn<Factura, String> col3 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getConsumo()));

        TableColumn<Factura, String> col4 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getValor()));

        TableColumn<Factura, String> col5 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<Factura, String> col6 = (TableColumn<Factura, String>) tblBillingHistory.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaPago()));

        // Establecer altura de fila explícita
        tblBillingHistory.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblBillingHistory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Factura> facturas = FXCollections.observableArrayList(
            new Factura("01/Nov/2025", "Energía", "Oct 2025", "245 kWh", "156.800", "Pagada", "05/Nov/2025"),
            new Factura("01/Nov/2025", "Agua", "Oct 2025", "18 m3", "89.500", "Pagada", "04/Nov/2025"),
            new Factura("01/Nov/2025", "Gas", "Oct 2025", "12 m3", "45.200", "Pagada", "03/Nov/2025"),
            new Factura("01/Oct/2025", "Energía", "Sep 2025", "238 kWh", "152.100", "Pagada", "06/Oct/2025"),
            new Factura("01/Oct/2025", "Agua", "Sep 2025", "16 m3", "79.800", "Pagada", "05/Oct/2025"),
            new Factura("01/Oct/2025", "Gas", "Sep 2025", "10 m3", "38.900", "Pagada", "04/Oct/2025")
        );

        tblBillingHistory.setItems(facturas);
    }

    private void initializeMaintenanceHistoryTable() {
        if (tblMaintenanceHistory == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<RegistroMantenimiento, String> col0 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getOrden()));

        TableColumn<RegistroMantenimiento, String> col1 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<RegistroMantenimiento, String> col2 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<RegistroMantenimiento, String> col3 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getDescripcion()));

        TableColumn<RegistroMantenimiento, String> col4 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getResponsable()));

        TableColumn<RegistroMantenimiento, String> col5 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<RegistroMantenimiento, String> col6 = (TableColumn<RegistroMantenimiento, String>) tblMaintenanceHistory.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCosto()));

        // Establecer altura de fila explícita
        tblMaintenanceHistory.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblMaintenanceHistory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<RegistroMantenimiento> registros = FXCollections.observableArrayList(
            new RegistroMantenimiento("OT-2025-1234", "10/Nov/2025", "Preventivo", "Inspección general y limpieza del transformador", "Ing. Carlos Gómez", "Completado", "2.500.000"),
            new RegistroMantenimiento("OT-2025-1180", "15/Sep/2025", "Preventivo", "Cambio de aceite dieléctrico", "Cuadrilla A", "Completado", "4.800.000"),
            new RegistroMantenimiento("OT-2025-1056", "20/Jun/2025", "Correctivo", "Reparación de sistema de enfriamiento", "Cuadrilla B", "Completado", "6.200.000"),
            new RegistroMantenimiento("OT-2025-0892", "10/Mar/2025", "Preventivo", "Inspección termográfica", "Ing. Ana Martínez", "Completado", "1.800.000"),
            new RegistroMantenimiento("OT-2024-2145", "15/Dic/2024", "Mejora", "Instalación de sensores IoT", "Cuadrilla A", "Completado", "8.500.000")
        );

        tblMaintenanceHistory.setItems(registros);
    }

    private void initializeBillingTable() {
        if (tblBilling == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<Factura, String> col0 = (TableColumn<Factura, String>) tblBilling.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<Factura, String> col1 = (TableColumn<Factura, String>) tblBilling.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getServicio()));

        TableColumn<Factura, String> col2 = (TableColumn<Factura, String>) tblBilling.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getPeriodo()));

        TableColumn<Factura, String> col3 = (TableColumn<Factura, String>) tblBilling.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getConsumo()));

        TableColumn<Factura, String> col4 = (TableColumn<Factura, String>) tblBilling.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getValor()));

        TableColumn<Factura, String> col5 = (TableColumn<Factura, String>) tblBilling.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<Factura, String> col6 = (TableColumn<Factura, String>) tblBilling.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaPago()));

        // Establecer altura de fila explícita
        tblBilling.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblBilling.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Factura> facturas = FXCollections.observableArrayList(
            new Factura("05/Nov/2025", "Energía", "Oct 2025", "15.890 kWh", "28.800.000", "Pagada", "10/Nov/2025"),
            new Factura("05/Oct/2025", "Energía", "Sep 2025", "14.230 kWh", "25.600.000", "Pagada", "12/Oct/2025"),
            new Factura("05/Sep/2025", "Energía", "Ago 2025", "16.450 kWh", "29.900.000", "Pagada", "09/Sep/2025"),
            new Factura("05/Ago/2025", "Energía", "Jul 2025", "15.120 kWh", "27.400.000", "Pagada", "11/Ago/2025"),
            new Factura("05/Jul/2025", "Energía", "Jun 2025", "14.890 kWh", "26.900.000", "Pagada", "10/Jul/2025")
        );

        tblBilling.setItems(facturas);
    }

    private void initializeResourcesTable() {
        if (tblResources == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<Recurso, String> col0 = (TableColumn<Recurso, String>) tblResources.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipoRecurso()));

        TableColumn<Recurso, String> col1 = (TableColumn<Recurso, String>) tblResources.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getRecurso()));

        TableColumn<Recurso, String> col2 = (TableColumn<Recurso, String>) tblResources.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCantidadHoras()));

        TableColumn<Recurso, String> col3 = (TableColumn<Recurso, String>) tblResources.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCostoEstimado()));

        TableColumn<Recurso, String> col4 = (TableColumn<Recurso, String>) tblResources.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<Recurso, String> col5 = (TableColumn<Recurso, String>) tblResources.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaAsignacion()));

        // Establecer altura de fila explícita
        tblResources.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblResources.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Recurso> recursos = FXCollections.observableArrayList(
            new Recurso("Humano", "Cuadrilla Técnica A (5 personas)", "480 horas", "18.500.000", "Asignado", "01/Nov/2025"),
            new Recurso("Material", "Transformadores 500kVA (x3)", "3 unidades", "85.000.000", "Asignado", "03/Nov/2025"),
            new Recurso("Equipamiento", "Excavadora CAT 320", "120 horas", "12.000.000", "Asignado", "05/Nov/2025"),
            new Recurso("Humano", "Ingeniero Supervisor", "160 horas", "9.600.000", "Asignado", "01/Nov/2025"),
            new Recurso("Material", "Cable de media tensión (500m)", "500 metros", "15.800.000", "Pendiente", "08/Nov/2025")
        );

        tblResources.setItems(recursos);
    }

    private void initializeDocumentsTable() {
        if (tblResults == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<Documento, String> col0 = (TableColumn<Documento, String>) tblResults.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTitulo()));

        TableColumn<Documento, String> col1 = (TableColumn<Documento, String>) tblResults.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<Documento, String> col2 = (TableColumn<Documento, String>) tblResults.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getArea()));

        TableColumn<Documento, String> col3 = (TableColumn<Documento, String>) tblResults.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getVersion()));

        TableColumn<Documento, String> col4 = (TableColumn<Documento, String>) tblResults.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getAutor()));

        TableColumn<Documento, String> col5 = (TableColumn<Documento, String>) tblResults.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<Documento, String> col6 = (TableColumn<Documento, String>) tblResults.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCodigo()));

        // Establecer altura de fila explícita
        tblResults.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblResults.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Documento> documentos = FXCollections.observableArrayList(
            new Documento("DOC-FIN-2025-089", "Manual de Procedimientos Financieros", "Procedimiento", "Finanzas", "v3.2", "10/Nov/2025", "Dir. Financiera"),
            new Documento("DOC-OPE-2025-145", "Protocolo de Seguridad en Subestaciones", "Protocolo", "Operaciones", "v2.1", "08/Nov/2025", "Jefe de Seguridad"),
            new Documento("DOC-AMB-2025-067", "Política de Gestión Ambiental EPM", "Política", "Sostenibilidad", "v4.0", "05/Nov/2025", "Dir. Ambiental"),
            new Documento("DOC-TEC-2025-234", "Especificaciones Técnicas Transformadores", "Especificación", "Ingeniería", "v1.5", "03/Nov/2025", "Ing. Carlos Gómez"),
            new Documento("DOC-LEG-2025-012", "Contrato Marco Proveedores 2025", "Contrato", "Legal", "v2.0", "01/Nov/2025", "Depto. Legal")
        );

        tblResults.setItems(documentos);
    }

    private void initializeVersionsTable() {
        if (tblVersions == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<Version, String> col0 = (TableColumn<Version, String>) tblVersions.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getVersion()));

        TableColumn<Version, String> col1 = (TableColumn<Version, String>) tblVersions.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getVersion()));

        TableColumn<Version, String> col2 = (TableColumn<Version, String>) tblVersions.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<Version, String> col3 = (TableColumn<Version, String>) tblVersions.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getAutor()));

        TableColumn<Version, String> col4 = (TableColumn<Version, String>) tblVersions.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCambios()));

        TableColumn<Version, String> col5 = (TableColumn<Version, String>) tblVersions.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        // Establecer altura de fila explícita
        tblVersions.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblVersions.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Version> versiones = FXCollections.observableArrayList(
            new Version("v4.0", "05/Nov/2025", "Dir. Ambiental", "Actualización completa de políticas ambientales según ISO 14001:2024", "Actual"),
            new Version("v3.2", "15/Sep/2025", "Dir. Ambiental", "Inclusión de nuevas métricas de huella de carbono", "Histórica"),
            new Version("v3.1", "20/Jun/2025", "Comité Ambiental", "Correcciones menores en procedimientos de reciclaje", "Histórica"),
            new Version("v3.0", "10/Mar/2025", "Dir. Ambiental", "Reestructuración completa del documento", "Histórica"),
            new Version("v2.5", "05/Ene/2025", "Equipo Sostenibilidad", "Adición de sección sobre RAEE", "Histórica")
        );

        tblVersions.setItems(versiones);
    }

    private void initializeProjectsTable() {
        if (tblProjects == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<ProyectoIDi, String> col0 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getNombre()));

        TableColumn<ProyectoIDi, String> col1 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<ProyectoIDi, String> col2 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getObjetivo()));

        TableColumn<ProyectoIDi, String> col3 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<ProyectoIDi, String> col4 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCodigo()));

        TableColumn<ProyectoIDi, String> col5 = (TableColumn<ProyectoIDi, String>) tblProjects.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getResultado()));

        // Establecer altura de fila explícita
        tblProjects.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblProjects.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<ProyectoIDi> proyectos = FXCollections.observableArrayList(
            new ProyectoIDi("IDI-2025-008", "Sistema de Predicción de Demanda con IA", "Investigación", "92 por ciento precisión", "90 por ciento", "Alto", "En Ejecución"),
            new ProyectoIDi("IDI-2025-012", "Baterías de Almacenamiento Domiciliario", "Desarrollo", "15 kWh capacidad", "12 kWh", "Muy Alto", "Piloto"),
            new ProyectoIDi("IDI-2024-045", "Monitoreo IoT de Redes Eléctricas", "Innovación", "1.200 sensores", "1.000 sensores", "Alto", "Completado"),
            new ProyectoIDi("IDI-2024-067", "Purificación de Agua con Grafeno", "Investigación", "99.8 por ciento pureza", "99.5 por ciento", "Muy Alto", "Completado"),
            new ProyectoIDi("IDI-2025-003", "Sistema de Detección de Fugas con Drones", "Desarrollo", "95 por ciento detección", "85 por ciento", "Medio", "En Ejecución")
        );

        tblProjects.setItems(proyectos);
    }

    private void initializeRAEETable() {
        if (tblRAEE == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<RAEE, String> col0 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getId()));

        TableColumn<RAEE, String> col1 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipoEquipo()));

        TableColumn<RAEE, String> col2 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCantidad()));

        TableColumn<RAEE, String> col3 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaRecepcion()));

        TableColumn<RAEE, String> col4 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getUbicacion()));

        TableColumn<RAEE, String> col5 = (TableColumn<RAEE, String>) tblRAEE.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        // Establecer altura de fila explícita
        tblRAEE.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblRAEE.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<RAEE> raees = FXCollections.observableArrayList(
            new RAEE("RAEE-2025-1234", "Computadores de escritorio", "45 unidades", "Bodega Central Medellín", "08/Nov/2025", "Recicladora ECOTEK", "En Bodega"),
            new RAEE("RAEE-2025-1189", "Monitores CRT", "28 unidades", "Bodega Norte", "05/Nov/2025", "Recicladora ECOTEK", "En Bodega"),
            new RAEE("RAEE-2025-1145", "Transformadores pequeños", "12 unidades", "Subestación La Alpujarra", "01/Nov/2025", "Fundición MetalCorp", "Procesado"),
            new RAEE("RAEE-2025-1098", "Baterías UPS", "67 unidades", "Bodega Central Medellín", "28/Oct/2025", "Recicladora ECOTEK", "Recolectado"),
            new RAEE("RAEE-2025-1023", "Teléfonos fijos", "89 unidades", "Bodega Sur", "20/Oct/2025", "Recicladora ECOTEK", "Procesado")
        );

        tblRAEE.setItems(raees);
    }

    private void initializeSocialProjectsTable() {
        if (tblSocialProjects == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<ProyectoSocial, String> col0 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getNombre()));

        TableColumn<ProyectoSocial, String> col1 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCodigo()));

        TableColumn<ProyectoSocial, String> col2 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getInversion()));

        TableColumn<ProyectoSocial, String> col3 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getBeneficiarios()));

        TableColumn<ProyectoSocial, String> col4 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<ProyectoSocial, String> col5 = (TableColumn<ProyectoSocial, String>) tblSocialProjects.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getComunidad()));

        // Establecer altura de fila explícita
        tblSocialProjects.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblSocialProjects.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<ProyectoSocial> proyectos = FXCollections.observableArrayList(
            new ProyectoSocial("SOC-2025-045", "Electrificación Rural Vereda El Bosque", "Vereda El Bosque", "120 familias", "450.000.000", "15/Oct/2025", "En Ejecución"),
            new ProyectoSocial("SOC-2025-038", "Agua Potable Comunidad San Antonio", "San Antonio", "85 familias", "320.000.000", "01/Sep/2025", "Completado"),
            new ProyectoSocial("SOC-2025-029", "Capacitación en Uso Eficiente de Energía", "8 comunas de Medellín", "500 personas", "180.000.000", "10/Ago/2025", "Completado"),
            new ProyectoSocial("SOC-2025-052", "Restauración Microcuenca La Cascada", "Corregimiento Santa Elena", "200 beneficiarios", "280.000.000", "01/Nov/2025", "Planificación")
        );

        tblSocialProjects.setItems(proyectos);
    }

    private void initializeVacationHistoryTable() {
        if (tblVacationHistory == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<SolicitudVacaciones, String> col0 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaSolicitud()));

        TableColumn<SolicitudVacaciones, String> col1 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getInicio()));

        TableColumn<SolicitudVacaciones, String> col2 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFin()));

        TableColumn<SolicitudVacaciones, String> col3 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getDias()));

        TableColumn<SolicitudVacaciones, String> col4 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<SolicitudVacaciones, String> col5 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<SolicitudVacaciones, String> col6 = (TableColumn<SolicitudVacaciones, String>) tblVacationHistory.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getAprobadoPor()));

        // Establecer altura de fila explícita
        tblVacationHistory.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblVacationHistory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<SolicitudVacaciones> vacaciones = FXCollections.observableArrayList(
            new SolicitudVacaciones("01/Oct/2025", "15/Dic/2025", "29/Dic/2025", "15", "Vacaciones", "Aprobada", "Dir. Talento Humano"),
            new SolicitudVacaciones("15/May/2025", "01/Jul/2025", "15/Jul/2025", "15", "Vacaciones", "Aprobada", "Dir. Talento Humano"),
            new SolicitudVacaciones("10/Mar/2025", "20/Jun/2025", "27/Jun/2025", "8", "Vacaciones", "Aprobada", "Jefe de Área"),
            new SolicitudVacaciones("05/Ene/2025", "15/Mar/2025", "22/Mar/2025", "8", "Vacaciones", "Aprobada", "Jefe de Área"),
            new SolicitudVacaciones("20/Dic/2024", "05/Ene/2025", "12/Ene/2025", "8", "Vacaciones", "Aprobada", "Dir. Talento Humano"),
            new SolicitudVacaciones("15/Sep/2024", "01/Nov/2024", "10/Nov/2024", "10", "Vacaciones", "Aprobada", "Jefe de Área"),
            new SolicitudVacaciones("10/Jun/2024", "15/Ago/2024", "29/Ago/2024", "15", "Vacaciones", "Aprobada", "Dir. Talento Humano"),
            new SolicitudVacaciones("05/Mar/2024", "20/May/2024", "27/May/2024", "8", "Vacaciones", "Aprobada", "Jefe de Área")
        );

        tblVacationHistory.setItems(vacaciones);
    }

    private void initializeRecentPQRTable() {
        if (tblRecentPQR == null) return;

        // Asignar CellValueFactory a columnas que YA existen en el FXML
        TableColumn<PQR, String> col0 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(0);
        col0.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getRadicado()));

        TableColumn<PQR, String> col1 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(1);
        col1.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<PQR, String> col2 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(2);
        col2.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<PQR, String> col3 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(3);
        col3.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getServicio()));

        TableColumn<PQR, String> col4 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(4);
        col4.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getMotivo()));

        TableColumn<PQR, String> col5 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(5);
        col5.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<PQR, String> col6 = (TableColumn<PQR, String>) tblRecentPQR.getColumns().get(6);
        col6.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaRespuesta()));

        // Establecer altura de fila explícita
        tblRecentPQR.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblRecentPQR.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<PQR> pqrs = FXCollections.observableArrayList(
            new PQR("PQR-2025-09876", "10/Nov/2025", "Reclamo", "Energía", "Facturación elevada sin justificación", "Abierto", "Ing. Carlos Martínez"),
            new PQR("PQR-2025-09654", "09/Nov/2025", "Queja", "Agua", "Demora en atención técnica", "En Proceso", "Cuadrilla Norte"),
            new PQR("PQR-2025-09432", "08/Nov/2025", "Petición", "Gas", "Solicitud de cambio de medidor", "Abierto", "Sin Asignar"),
            new PQR("PQR-2025-09210", "07/Nov/2025", "Sugerencia", "General", "Mejora en portal web", "En Proceso", "Depto. TI"),
            new PQR("PQR-2025-08998", "06/Nov/2025", "Reclamo", "Energía", "Interrupción del servicio", "Resuelto", "Ing. Ana López"),
            new PQR("PQR-2025-08776", "05/Nov/2025", "Queja", "Agua", "Atención deficiente en oficina", "En Proceso", "Depto. Comercial"),
            new PQR("PQR-2025-08554", "04/Nov/2025", "Petición", "Energía", "Solicitud de revisión de instalación", "Resuelto", "Ing. Carlos Martínez"),
            new PQR("PQR-2025-08332", "03/Nov/2025", "Reclamo", "Gas", "Factura incorrecta", "En Proceso", "Depto. Facturación")
        );

        tblRecentPQR.setItems(pqrs);
    }

    /**
     * Métodos de inicialización de gráficos
     */
    private void initializeEnvironmentalChart() {
        if (chartEnvironmental == null) return;

        // Serie CO2
        XYChart.Series<String, Number> seriesCO2 = new XYChart.Series<>();
        seriesCO2.setName("Emisiones CO₂ (Ton)");
        seriesCO2.getData().add(new XYChart.Data<>("May", 125));
        seriesCO2.getData().add(new XYChart.Data<>("Jun", 118));
        seriesCO2.getData().add(new XYChart.Data<>("Jul", 132));
        seriesCO2.getData().add(new XYChart.Data<>("Ago", 115));
        seriesCO2.getData().add(new XYChart.Data<>("Sep", 108));
        seriesCO2.getData().add(new XYChart.Data<>("Oct", 102));
        seriesCO2.getData().add(new XYChart.Data<>("Nov", 95));

        // Serie Agua
        XYChart.Series<String, Number> seriesAgua = new XYChart.Series<>();
        seriesAgua.setName("Consumo de Agua (m³)");
        seriesAgua.getData().add(new XYChart.Data<>("May", 8500));
        seriesAgua.getData().add(new XYChart.Data<>("Jun", 8200));
        seriesAgua.getData().add(new XYChart.Data<>("Jul", 7900));
        seriesAgua.getData().add(new XYChart.Data<>("Ago", 7600));
        seriesAgua.getData().add(new XYChart.Data<>("Sep", 7400));
        seriesAgua.getData().add(new XYChart.Data<>("Oct", 7100));
        seriesAgua.getData().add(new XYChart.Data<>("Nov", 6800));

        // Serie Energía
        XYChart.Series<String, Number> seriesEnergia = new XYChart.Series<>();
        seriesEnergia.setName("Consumo Energético (kWh)");
        seriesEnergia.getData().add(new XYChart.Data<>("May", 45000));
        seriesEnergia.getData().add(new XYChart.Data<>("Jun", 43500));
        seriesEnergia.getData().add(new XYChart.Data<>("Jul", 42800));
        seriesEnergia.getData().add(new XYChart.Data<>("Ago", 41200));
        seriesEnergia.getData().add(new XYChart.Data<>("Sep", 39800));
        seriesEnergia.getData().add(new XYChart.Data<>("Oct", 38500));
        seriesEnergia.getData().add(new XYChart.Data<>("Nov", 37200));

        chartEnvironmental.getData().addAll(seriesCO2, seriesAgua, seriesEnergia);
        chartEnvironmental.setLegendVisible(true);
        chartEnvironmental.setAnimated(true);
    }

    private void initializeDigitalizationChart() {
        if (chartDigitalization == null) return;

        // Serie de progreso de digitalización por área
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Porcentaje Digitalizado");
        series.getData().add(new XYChart.Data<>("Financiera", 85));
        series.getData().add(new XYChart.Data<>("RRHH", 72));
        series.getData().add(new XYChart.Data<>("Proyectos", 68));
        series.getData().add(new XYChart.Data<>("Legal", 91));
        series.getData().add(new XYChart.Data<>("Comercial", 78));
        series.getData().add(new XYChart.Data<>("Técnica", 63));
        series.getData().add(new XYChart.Data<>("Gestión Amb.", 58));

        chartDigitalization.getData().add(series);
        chartDigitalization.setLegendVisible(false);
        chartDigitalization.setAnimated(true);
    }

    /**
     * Actualiza el estilo visual del sidebar para resaltar la vista activa
     *
     * @param activeButton El botón que debe mostrarse como activo
     */
    private void updateSidebarActiveState(Button activeButton) {
        // Limpiar todos los estilos activos de botones principales
        if (btnDashboard != null) btnDashboard.getStyleClass().remove("sidebar-button-active");

        // Limpiar todos los estilos activos de subitems
        if (btnControlPresupuestal != null) btnControlPresupuestal.getStyleClass().remove("sidebar-subitem-active");
        if (btnEstadosFinancieros != null) btnEstadosFinancieros.getStyleClass().remove("sidebar-subitem-active");
        if (btnActivos != null) btnActivos.getStyleClass().remove("sidebar-subitem-active");
        if (btnGestionPersonal != null) btnGestionPersonal.getStyleClass().remove("sidebar-subitem-active");
        if (btnReporteRRHH != null) btnReporteRRHH.getStyleClass().remove("sidebar-subitem-active");
        if (btnColillaPago != null) btnColillaPago.getStyleClass().remove("sidebar-subitem-active");
        if (btnVacaciones != null) btnVacaciones.getStyleClass().remove("sidebar-subitem-active");
        if (btnGestionPQRS != null) btnGestionPQRS.getStyleClass().remove("sidebar-subitem-active");
        if (btnContratos != null) btnContratos.getStyleClass().remove("sidebar-subitem-active");
        if (btnPQR != null) btnPQR.getStyleClass().remove("sidebar-subitem-active");
        if (btnVista360 != null) btnVista360.getStyleClass().remove("sidebar-subitem-active");
        if (btnAsignacionRecursos != null) btnAsignacionRecursos.getStyleClass().remove("sidebar-subitem-active");
        if (btnControlAvance != null) btnControlAvance.getStyleClass().remove("sidebar-subitem-active");
        if (btnBusquedaDocumentos != null) btnBusquedaDocumentos.getStyleClass().remove("sidebar-subitem-active");
        if (btnControlVersiones != null) btnControlVersiones.getStyleClass().remove("sidebar-subitem-active");
        if (btnBancoIdeas != null) btnBancoIdeas.getStyleClass().remove("sidebar-subitem-active");
        if (btnMedicionImpacto != null) btnMedicionImpacto.getStyleClass().remove("sidebar-subitem-active");
        if (btnMonitoreoAmbiental != null) btnMonitoreoAmbiental.getStyleClass().remove("sidebar-subitem-active");
        if (btnGestionResiduos != null) btnGestionResiduos.getStyleClass().remove("sidebar-subitem-active");

        // Agregar clase activa al botón seleccionado
        if (activeButton != null) {
            if (activeButton == btnDashboard) {
                activeButton.getStyleClass().add("sidebar-button-active");
            } else {
                activeButton.getStyleClass().add("sidebar-subitem-active");
            }
        }
    }

    /**
     * Método genérico para cargar vistas con transición fade
     *
     * @param fxmlFile Nombre del archivo FXML a cargar
     */
    private void loadView(String fxmlFile) {
        // Obtener el paneIndex de la instancia principal si no está disponible en esta instancia
        StackPane targetPane = (paneIndex != null) ? paneIndex : (instance != null ? instance.paneIndex : null);

        if (targetPane == null) {
            System.err.println("Error: No hay paneIndex disponible para cargar la vista");
            return;
        }

        try {
            // Cargar el archivo FXML - cada vista tendrá su propio controlador
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node newView = loader.load();

            // Si hay contenido anterior, hacer fade out
            if (!targetPane.getChildren().isEmpty()) {
                Node oldView = targetPane.getChildren().get(0);

                FadeTransition fadeOut = new FadeTransition(Duration.millis(150), oldView);
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);
                fadeOut.setOnFinished(e -> {
                    targetPane.getChildren().clear();
                    targetPane.getChildren().add(newView);

                    // Fade in para la nueva vista
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(200), newView);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();
                });
                fadeOut.play();
            } else {
                // Si no hay contenido anterior, solo agregar
                targetPane.getChildren().add(newView);

                FadeTransition fadeIn = new FadeTransition(Duration.millis(200), newView);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista: " + fxmlFile);
        }
    }

    private void initializeDepartmentsTable() {
        if (tblDepartments == null) return;

        // Configurar columnas
        TableColumn<Departamento, String> colDepartamento = new TableColumn<>("Departamento");
        colDepartamento.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getNombre()));
        colDepartamento.setPrefWidth(200);

        TableColumn<Departamento, String> colNumEmpleados = new TableColumn<>("Nº Empleados");
        colNumEmpleados.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getNumEmpleados()));

        TableColumn<Departamento, String> colVacantes = new TableColumn<>("Vacantes Abiertas");
        colVacantes.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getVacantesAbiertas()));

        TableColumn<Departamento, String> colRotacion = new TableColumn<>("Rotación %");
        colRotacion.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getRotacion()));

        TableColumn<Departamento, String> colDesempenoPromedio = new TableColumn<>("Desempeño Promedio");
        colDesempenoPromedio.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getDesempeno()));
        colDesempenoPromedio.setPrefWidth(150);

        TableColumn<Departamento, String> colHorasCapacitacion = new TableColumn<>("Horas Capacitación");
        colHorasCapacitacion.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getHorasCapacitacion()));
        colHorasCapacitacion.setPrefWidth(150);

        tblDepartments.getColumns().addAll(colDepartamento, colNumEmpleados, colVacantes, colRotacion, colDesempenoPromedio, colHorasCapacitacion);

        // Establecer altura de fila explícita
        tblDepartments.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblDepartments.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Departamento> departamentos = FXCollections.observableArrayList(
            new Departamento("Ingeniería", "287", "5", "2.1%", "4.5/5.0", "1,245"),
            new Departamento("Operaciones", "412", "3", "2.8%", "4.3/5.0", "892"),
            new Departamento("Finanzas", "98", "1", "1.5%", "4.6/5.0", "456"),
            new Departamento("Recursos Humanos", "45", "2", "3.5%", "4.4/5.0", "678"),
            new Departamento("TI", "125", "4", "4.2%", "4.2/5.0", "1,089"),
            new Departamento("Legal", "23", "0", "1.8%", "4.7/5.0", "234"),
            new Departamento("Sostenibilidad", "67", "1", "2.3%", "4.5/5.0", "567"),
            new Departamento("Comercial", "188", "3", "3.1%", "4.1/5.0", "723")
        );

        tblDepartments.setItems(departamentos);
    }

    private void initializeBalanceSheetTable() {
        if (tblBalanceSheet == null) return;

        // Configurar columnas
        TableColumn<BalanceSheet, String> colCuenta = new TableColumn<>("Cuenta");
        colCuenta.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCuenta()));
        colCuenta.setPrefWidth(300);

        TableColumn<BalanceSheet, String> colCategoria = new TableColumn<>("Categoría");
        colCategoria.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCategoria()));

        TableColumn<BalanceSheet, String> colSaldoAnterior = new TableColumn<>("Saldo Anterior");
        colSaldoAnterior.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getSaldoAnterior()));

        TableColumn<BalanceSheet, String> colMovimientos = new TableColumn<>("Movimientos");
        colMovimientos.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getMovimientos()));

        TableColumn<BalanceSheet, String> colSaldoActual = new TableColumn<>("Saldo Actual");
        colSaldoActual.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getSaldoActual()));

        tblBalanceSheet.getColumns().addAll(colCuenta, colCategoria, colSaldoAnterior, colMovimientos, colSaldoActual);

        // Establecer altura de fila explícita
        tblBalanceSheet.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblBalanceSheet.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<BalanceSheet> balances = FXCollections.observableArrayList(
            new BalanceSheet("Efectivo y Equivalentes", "Activo Corriente", "$450M", "+$25M", "$475M"),
            new BalanceSheet("Cuentas por Cobrar", "Activo Corriente", "$380M", "+$15M", "$395M"),
            new BalanceSheet("Inventarios", "Activo Corriente", "$350M", "+$30M", "$380M"),
            new BalanceSheet("Propiedad, Planta y Equipo", "Activo No Corriente", "$2,800M", "-$50M", "$2,750M"),
            new BalanceSheet("Activos Intangibles", "Activo No Corriente", "$950M", "+$50M", "$1,000M"),
            new BalanceSheet("Cuentas por Pagar", "Pasivo Corriente", "$520M", "+$30M", "$550M"),
            new BalanceSheet("Deuda Corto Plazo", "Pasivo Corriente", "$230M", "+$20M", "$250M"),
            new BalanceSheet("Deuda Largo Plazo", "Pasivo No Corriente", "$1,150M", "+$50M", "$1,200M"),
            new BalanceSheet("Capital Social", "Patrimonio", "$2,500M", "$0", "$2,500M"),
            new BalanceSheet("Utilidades Retenidas", "Patrimonio", "$480M", "+$20M", "$500M")
        );

        tblBalanceSheet.setItems(balances);
    }

    private void initializePQRSTable() {
        if (tblPQRS == null) return;

        // Configurar columnas
        TableColumn<PQRGestion, String> colRadicado = new TableColumn<>("Radicado");
        colRadicado.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getRadicado()));

        TableColumn<PQRGestion, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFecha()));

        TableColumn<PQRGestion, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTipo()));

        TableColumn<PQRGestion, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCliente()));
        colCliente.setPrefWidth(180);

        TableColumn<PQRGestion, String> colAsunto = new TableColumn<>("Asunto");
        colAsunto.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getAsunto()));
        colAsunto.setPrefWidth(200);

        TableColumn<PQRGestion, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<PQRGestion, String> colResponsable = new TableColumn<>("Responsable");
        colResponsable.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getResponsable()));
        colResponsable.setPrefWidth(150);

        tblPQRS.getColumns().addAll(colRadicado, colFecha, colTipo, colCliente, colAsunto, colEstado, colResponsable);

        // Establecer altura de fila explícita
        tblPQRS.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblPQRS.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<PQRGestion> pqrs = FXCollections.observableArrayList(
            new PQRGestion("PQR-2025-09876", "10/Nov/2025", "Reclamo", "María Rodríguez", "Facturación elevada sin justificación", "Abierto", "Ing. Carlos Martínez"),
            new PQRGestion("PQR-2025-09654", "09/Nov/2025", "Queja", "Pedro Gómez", "Demora en atención técnica", "En Proceso", "Cuadrilla Norte"),
            new PQRGestion("PQR-2025-09432", "08/Nov/2025", "Petición", "Ana López", "Solicitud de cambio de medidor", "Abierto", "Sin Asignar"),
            new PQRGestion("PQR-2025-09210", "07/Nov/2025", "Sugerencia", "Luis Martínez", "Mejora en portal web", "En Proceso", "Depto. TI"),
            new PQRGestion("PQR-2025-08998", "06/Nov/2025", "Reclamo", "Carmen Silva", "Interrupción del servicio", "Abierto", "Ing. Ana López"),
            new PQRGestion("PQR-2025-08776", "05/Nov/2025", "Queja", "Jorge Pérez", "Atención deficiente en oficina", "En Proceso", "Depto. Comercial")
        );

        tblPQRS.setItems(pqrs);
    }

    private void initializeContratosTable() {
        if (tblBilling == null) return;

        // Configurar columnas
        TableColumn<Contrato, String> colFechaEmision = new TableColumn<>("Fecha Emisión");
        colFechaEmision.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getFechaEmision()));

        TableColumn<Contrato, String> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getCliente()));
        colCliente.setPrefWidth(200);

        TableColumn<Contrato, String> colServicio = new TableColumn<>("Servicio");
        colServicio.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getServicio()));

        TableColumn<Contrato, String> colTotal = new TableColumn<>("Total");
        colTotal.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getTotal()));

        TableColumn<Contrato, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getEstado()));

        TableColumn<Contrato, String> colVencimiento = new TableColumn<>("Vencimiento");
        colVencimiento.setCellValueFactory(cellData -> new javafx.beans.property.ReadOnlyStringWrapper(cellData.getValue().getVencimiento()));

        // Cast dinámico debido a que tblBilling está definido como TableView<Factura>
        @SuppressWarnings("unchecked")
        TableView<Contrato> tblBillingContrato = (TableView<Contrato>)(TableView<?>)tblBilling;
        tblBillingContrato.getColumns().addAll(colFechaEmision, colCliente, colServicio, colTotal, colEstado, colVencimiento);

        // Establecer altura de fila explícita
        tblBillingContrato.setFixedCellSize(40);

        // Hacer que las columnas ocupen todo el ancho de la tabla
        tblBillingContrato.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Contrato> contratos = FXCollections.observableArrayList(
            new Contrato("05/Nov/2025", "Industrias ABC S.A.", "Energía Eléctrica", "$28.800.000", "Vigente", "05/Dic/2025"),
            new Contrato("03/Nov/2025", "Edificio Residencial Los Alpes", "Agua + Alcantarillado", "$12.500.000", "Vigente", "03/Dic/2025"),
            new Contrato("01/Nov/2025", "Restaurant El Buen Sabor", "Gas Natural", "$3.200.000", "Vigente", "01/Dic/2025"),
            new Contrato("28/Oct/2025", "Hotel Plaza Mayor", "Energía + Agua + Gas", "$45.600.000", "Vigente", "28/Nov/2025"),
            new Contrato("25/Oct/2025", "Centro Comercial La Estación", "Energía Eléctrica", "$125.000.000", "Vigente", "25/Nov/2025"),
            new Contrato("20/Oct/2025", "Clínica San Rafael", "Energía + Agua", "$38.900.000", "Vigente", "20/Nov/2025")
        );

        tblBillingContrato.setItems(contratos);
    }

    private void initializeCapacitacionChart() {
        if (chartCapacitacion == null) return;

        javafx.scene.chart.XYChart.Series<String, Number> series = new javafx.scene.chart.XYChart.Series<>();
        series.setName("Horas de Capacitación");
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("Ingeniería", 1245));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("Operaciones", 892));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("TI", 1089));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("Comercial", 723));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("Sostenibilidad", 567));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>("Finanzas", 456));

        chartCapacitacion.getData().add(series);
        chartCapacitacion.setLegendVisible(false);
    }

    private void initializeGanttChart() {
        if (chartGantt == null) return;

        javafx.scene.chart.XYChart.Series<String, Number> seriesPlaneado = new javafx.scene.chart.XYChart.Series<>();
        seriesPlaneado.setName("Avance Planeado");
        seriesPlaneado.getData().add(new javafx.scene.chart.XYChart.Data<>("Diseño", 100));
        seriesPlaneado.getData().add(new javafx.scene.chart.XYChart.Data<>("Excavación", 85));
        seriesPlaneado.getData().add(new javafx.scene.chart.XYChart.Data<>("Instalación", 60));
        seriesPlaneado.getData().add(new javafx.scene.chart.XYChart.Data<>("Pruebas", 20));

        javafx.scene.chart.XYChart.Series<String, Number> seriesReal = new javafx.scene.chart.XYChart.Series<>();
        seriesReal.setName("Avance Real");
        seriesReal.getData().add(new javafx.scene.chart.XYChart.Data<>("Diseño", 100));
        seriesReal.getData().add(new javafx.scene.chart.XYChart.Data<>("Excavación", 90));
        seriesReal.getData().add(new javafx.scene.chart.XYChart.Data<>("Instalación", 55));
        seriesReal.getData().add(new javafx.scene.chart.XYChart.Data<>("Pruebas", 15));

        chartGantt.getData().addAll(seriesPlaneado, seriesReal);
    }

    private void initializeImpactoChart() {
        if (chartImpacto == null) return;

        javafx.scene.chart.XYChart.Series<String, Number> seriesMeta = new javafx.scene.chart.XYChart.Series<>();
        seriesMeta.setName("Meta Inicial");
        seriesMeta.getData().add(new javafx.scene.chart.XYChart.Data<>("Sistema Predictivo", 85));
        seriesMeta.getData().add(new javafx.scene.chart.XYChart.Data<>("Optimización Redes", 75));
        seriesMeta.getData().add(new javafx.scene.chart.XYChart.Data<>("App Móvil", 80));
        seriesMeta.getData().add(new javafx.scene.chart.XYChart.Data<>("IA Demanda", 90));

        javafx.scene.chart.XYChart.Series<String, Number> seriesResultado = new javafx.scene.chart.XYChart.Series<>();
        seriesResultado.setName("Resultado Obtenido");
        seriesResultado.getData().add(new javafx.scene.chart.XYChart.Data<>("Sistema Predictivo", 92));
        seriesResultado.getData().add(new javafx.scene.chart.XYChart.Data<>("Optimización Redes", 88));
        seriesResultado.getData().add(new javafx.scene.chart.XYChart.Data<>("App Móvil", 85));
        seriesResultado.getData().add(new javafx.scene.chart.XYChart.Data<>("IA Demanda", 95));

        chartImpacto.getData().addAll(seriesMeta, seriesResultado);
    }

    /**
     * Método de ejemplo para hello-view.fxml (no usado en producción)
     */
    @FXML
    public void onHelloButtonClick(ActionEvent event) {
        System.out.println("Hello button clicked");
    }
}
