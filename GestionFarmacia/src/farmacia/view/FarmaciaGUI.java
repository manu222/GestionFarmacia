package farmacia.view;
import common.IRepo;
import farmacia.model.Farmacia;
import farmacia.model.FarmaciaGuardia;
import farmacia.model.FarmaciaNormal;
import farmacia.model.RepoFileBinFarmacia;
import farmacia.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;


/**
 * The type Farmacia gui.
 */
public class FarmaciaGUI extends Application {

    private IRepo<Farmacia> farmacias;
    private Scanner sc;

    /**
     * Instantiates a new Farmacia gui.
     */
    public FarmaciaGUI() {
        farmacias=new RepoFileBinFarmacia();
        sc=new Scanner(System.in);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        // Crear controles
        Label titleLabel = new Label("Farmacia App");
        Button createButton = new Button("Crear");
        Button readButton = new Button("Leer");
        Button updateButton = new Button("Actualizar");
        Button deleteButton = new Button("Eliminar");
        Button backButton = new Button("Atras");

        // Crear diseño
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, createButton, readButton, updateButton, deleteButton);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));

        // Crear escena
        Scene scene = new Scene(layout, 600, 300);

        // Asignar escena al escenario principal
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();


        createButton.setOnAction(e -> {
            // Solicitar al usuario el tipo
            TextInputDialog typeDialog = new TextInputDialog();
            typeDialog.setTitle("Tipo de Farmacia");
            typeDialog.setHeaderText("Normal(1) or Guardia(other):");
            Optional<String> typeResult = typeDialog.showAndWait();
            if (typeResult.isPresent()) {
                String type = typeResult.get();

                // Solicitar al usuario el ID de la farmacia
                TextInputDialog idDialog = new TextInputDialog();
                idDialog.setTitle("ID de la Farmacia");
                idDialog.setHeaderText("Introduce el ID de la farmacia:");
                Optional<String> idResult = idDialog.showAndWait();
                if (idResult.isPresent()) {
                    int id = Integer.parseInt(idResult.get());

                    Farmacia c;
                    if (type.equals("1")) {
                        // Solicitar al usuario la dirección
                        TextInputDialog direccionDialog = new TextInputDialog();
                        direccionDialog.setTitle("Dirección de la Farmacia");
                        direccionDialog.setHeaderText("Introduce la dirección de la farmacia:");
                        Optional<String> direccionResult = direccionDialog.showAndWait();
                        if (direccionResult.isPresent()) {
                            String direccion = direccionResult.get();

                            // Solicitar al usuario el nombre del farmacéutico
                            TextInputDialog farmaceuticoDialog = new TextInputDialog();
                            farmaceuticoDialog.setTitle("Nombre del Farmacéutico");
                            farmaceuticoDialog.setHeaderText("Introduce el nombre del farmacéutico:");
                            Optional<String> farmaceuticoResult = farmaceuticoDialog.showAndWait();
                            if (farmaceuticoResult.isPresent()) {
                                String farmaceutico = farmaceuticoResult.get();

                                // Solicitar al usuario los productos
                                TextInputDialog productosDialog = new TextInputDialog();
                                productosDialog.setTitle("Productos de la Farmacia");
                                productosDialog.setHeaderText("Introduce los productos de la farmacia:");
                                Optional<String> productosResult = productosDialog.showAndWait();
                                if (productosResult.isPresent()) {
                                    String producto = productosResult.get();

                                    // Solicitar al usuario los clientes
                                    TextInputDialog clientesDialog = new TextInputDialog();
                                    clientesDialog.setTitle("Clientes de la Farmacia");
                                    clientesDialog.setHeaderText("Introduce los clientes de la farmacia:");
                                    Optional<String> clientesResult = clientesDialog.showAndWait();
                                    if (clientesResult.isPresent()) {
                                        String cliente = clientesResult.get();

                                        // Solicitar al usuario el horario
                                        TextInputDialog horarioDialog = new TextInputDialog();
                                        horarioDialog.setTitle("Horario de la Farmacia");
                                        horarioDialog.setHeaderText("Horario:");
                                        Optional<String> horarioResult = horarioDialog.showAndWait();
                                        if (horarioResult.isPresent()) {
                                            String horario = horarioResult.get();
                                            Vector<String> farmaceuticos=new Vector<>();
                                            Vector<String> productos=new Vector<>();
                                            Vector<String> clientes=new Vector<>();
                                            farmaceuticos.add(farmaceutico);
                                            productos.add(producto);
                                            clientes.add(cliente);
                                            c = new FarmaciaNormal(farmaceuticos, productos, clientes, direccion, id, horario);

                                            //c = new FarmaciaNormal(Collections.singletonList(farmaceutico, Collections.singletonList(productos), Collections.singletonList(clientes), direccion, id, horario);
                                            if (farmacias.create(c))
                                                System.out.println("Created");
                                            else
                                                System.out.println("Error");
                                        } else {
                                            System.out.println("No se proporcionó el horario");
                                        }
                                    } else {
                                        System.out.println("No se proporcionaron los clientes");
                                    }
                                } else { System.out.println("No se proporcionaron los productos");
                                }
                            } else {
                                System.out.println("No se proporcionó el nombre del farmacéutico");
                            }
                        } else {
                            System.out.println("No se proporcionó la dirección de la farmacia");
                        }
                    } else {
                        // Solicitar al usuario la dirección
                        TextInputDialog direccionDialog = new TextInputDialog();
                        direccionDialog.setTitle("Dirección de la Farmacia");
                        direccionDialog.setHeaderText("Introduce la dirección de la farmacia:");
                        Optional<String> direccionResult = direccionDialog.showAndWait();
                        if (direccionResult.isPresent()) {
                            String direccion = direccionResult.get();

                            // Solicitar al usuario el nombre del farmacéutico
                            TextInputDialog farmaceuticoDialog = new TextInputDialog();
                            farmaceuticoDialog.setTitle("Nombre del Farmacéutico");
                            farmaceuticoDialog.setHeaderText("Introduce el nombre del farmacéutico:");
                            Optional<String> farmaceuticoResult = farmaceuticoDialog.showAndWait();
                            if (farmaceuticoResult.isPresent()) {
                                String farmaceutico = farmaceuticoResult.get();

                                // Solicitar al usuario los productos
                                TextInputDialog productosDialog = new TextInputDialog();
                                productosDialog.setTitle("Productos de la Farmacia");
                                productosDialog.setHeaderText("Introduce los productos de la farmacia:");
                                Optional<String> productosResult = productosDialog.showAndWait();
                                if (productosResult.isPresent()) {
                                    String producto = productosResult.get();

                                    // Solicitar al usuario los clientes
                                    TextInputDialog clientesDialog = new TextInputDialog();
                                    clientesDialog.setTitle("Clientes de la Farmacia");
                                    clientesDialog.setHeaderText("Introduce los clientes de la farmacia:");
                                    Optional<String> clientesResult = clientesDialog.showAndWait();
                                    if (clientesResult.isPresent()) {
                                        String cliente = clientesResult.get();

                                        // Solicitar al usuario si es Guardia
                                        TextInputDialog guardiaDialog = new TextInputDialog();
                                        guardiaDialog.setTitle("Guardia de la Farmacia");
                                        guardiaDialog.setHeaderText("Guardia:");
                                        Optional<String> guardiaResult = guardiaDialog.showAndWait();
                                        if (guardiaResult.isPresent()) {
                                            boolean isGuardia = Boolean.parseBoolean(guardiaResult.get());
                                            Vector<String> farmaceuticos=new Vector<>();
                                            Vector<String> productos=new Vector<>();
                                            Vector<String> clientes=new Vector<>();
                                            farmaceuticos.add(farmaceutico);
                                            productos.add(producto);
                                            clientes.add(cliente);
                                            c = new FarmaciaGuardia(farmaceuticos, productos, clientes, direccion, id, isGuardia);
                                            if (farmacias.create(c))
                                                System.out.println("Created");
                                            else
                                                System.out.println("Error");
                                        } else {
                                            System.out.println("No se proporcionó si es Guardia");
                                        }
                                    } else {
                                        System.out.println("No se proporcionaron los clientes");
                                    }
                                } else {
                                    System.out.println("No se proporcionaron los productos");
                                }
                            } else {
                                System.out.println("No se proporcionó el nombre del farmacéutico");
                            }
                        } else {
                            System.out.println("No se proporcionó la dirección de la farmacia");
                        }
                    }
                } else {
                    System.out.println("No se proporcionó el ID de la farmacia");
                }
            } else {
                System.out.println("No se proporcionó el tipo de farmacia");
            }
        });


        readButton.setOnAction(e -> {
            List<Farmacia> tmp = farmacias.read();
            if (tmp.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lista de Farmacias");
                alert.setHeaderText(null);
                alert.setContentText("Empty");
                alert.showAndWait();
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                Stage stage = new Stage();
                stage.setTitle("Lista de Farmacias");

                ListView<String> farmaciasListView = new ListView<>();
                for (Farmacia farmacia : tmp) {
                    farmaciasListView.getItems().add(farmacia.toString());
                }

                VBox vbox = new VBox(farmaciasListView);
                vbox.setPadding(new Insets(10));

                Scene scene2 = new Scene(vbox, 400, 300);
                stage.setScene(scene2);
                stage.show();
            }
        });

        updateButton.setOnAction(e->{
            List<Farmacia> tmp = farmacias.read();
            if (tmp.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lista de Farmacias");
                alert.setHeaderText(null);
                alert.setContentText("Empty");
                alert.showAndWait();
            } else {
                Stage stage = new Stage();
                stage.setTitle("Lista de Farmacias");

                ListView<String> farmaciasListView = new ListView<>();
                for (Farmacia farmacia : tmp) {
                    farmaciasListView.getItems().add(farmacia.toString());
                }

                VBox vbox = new VBox(farmaciasListView);
                vbox.setPadding(new Insets(10));

                Scene scene2 = new Scene(vbox, 400, 300);
                stage.setScene(scene2);
                stage.show();
            }

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Editar Farmacia");
            dialog.setHeaderText(null);
            dialog.setContentText("Introduce el ID de la farmacia a editar:");

            // Obtener la respuesta del usuario
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                String idText = result.get();
                try {
                    int idFarmacia = Integer.parseInt(idText);
                    // Buscar la farmacia correspondiente
                    Farmacia farmaciaSeleccionada = null;
                    for (Farmacia farmacia : tmp) {
                        if (farmacia.getId() == idFarmacia) {
                            farmaciaSeleccionada = farmacia;
                            break;
                        }
                    }
                    if (farmaciaSeleccionada == null) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("La farmacia no existe");
                        alert.showAndWait();
                    } else {

                        // Crear controles
                        Button dirButton = new Button("Direccion");
                        Button idButton = new Button("ID");
                        Button farmaceuticosButton = new Button("Farmaceuticos");
                        Button productosButton = new Button("productos");
                        Button clientesButton = new Button("Clientes");
                        Button horaButton = new Button("Horario");
                        Button principalBack = new Button("Back");

                        // Crear diseño
                        VBox layout2 = new VBox(10);
                        layout2.getChildren().addAll(titleLabel, dirButton, idButton, farmaceuticosButton, productosButton, clientesButton, horaButton,principalBack);
                        layout2.setSpacing(10);
                        layout2.setPadding(new Insets(10));

                        // Crear escena
                        Scene scene2 = new Scene(layout2, 600, 300);

                        // Asignar escena al escenario principal
                        primaryStage.setScene(scene2);

                        // Mostrar la ventana
                        primaryStage.show();

                        Farmacia farmacia = farmaciaSeleccionada;

                        List<String> farmaceuticos = farmacia.getFarmaceuticos();

                        List<String> clientes = farmacia.getClientes();

                        Vector<String> productos = (Vector) farmacia.getProductos();

                        TextInputDialog inputDialog = new TextInputDialog();

                        dirButton.setOnAction(ex -> {
                            inputDialog.setTitle("Editar Dirección");
                            Optional<String> direccionResult = inputDialog.showAndWait();
                            if (direccionResult.isPresent()) {
                                String direccionUpdate = direccionResult.get();
                                farmacia.setDireccion(direccionUpdate);
                                farmacias.update(idFarmacia, farmacia);

                            }
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });

                        idButton.setOnAction(ex -> {
                            inputDialog.setTitle("Editar ID");
                            Optional<String> idResult = inputDialog.showAndWait();
                            if (idResult.isPresent()) {
                                try {
                                    int idUpdate = Integer.parseInt(idResult.get());
                                    farmacia.setId(idUpdate);
                                    farmacias.update(idFarmacia, farmacia);
                                } catch (NumberFormatException ea) {
                                    throw new RuntimeException(ea);
                                }

                            }
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });

                        // Crear controles
                        Button addBtnFarm = new Button("Add ");
                        Button deleteBtnFarm = new Button("Delete ");

                        Button addBtnProd = new Button("Add ");
                        Button deleteBtnProd = new Button("Delete ");

                        Button addBtnClient = new Button("Add ");
                        Button deleteBtnClient = new Button("Delete ");


                        farmaceuticosButton.setOnAction(ex -> {


                            // Crear diseño
                            VBox layoutFarmaceuticos = new VBox(10);
                            layoutFarmaceuticos.getChildren().addAll(titleLabel, addBtnFarm,deleteBtnFarm);
                            layoutFarmaceuticos.setSpacing(10);
                            layoutFarmaceuticos.setPadding(new Insets(10));

                            // Crear escena
                            Scene sceneFarmaceuticos = new Scene(layoutFarmaceuticos, 600, 300);

                            // Asignar escena al escenario principal
                            primaryStage.setScene(sceneFarmaceuticos);

                            // Mostrar la ventana
                            primaryStage.show();

                            addBtnFarm.setOnAction(exe->{
                                boolean seguirAgregando=true;
                                while (seguirAgregando){
                                    TextInputDialog farmaceuticoDialog = new TextInputDialog();
                                    farmaceuticoDialog.setTitle("Añadir Farmacéutico");
                                    farmaceuticoDialog.setHeaderText(null);
                                    farmaceuticoDialog.setContentText("Introduce el nombre del farmacéutico o escribe '0' para terminar:");
                                    Optional<String> farmaceuticoResult = farmaceuticoDialog.showAndWait();
                                    String agregarFarmaceutico = farmaceuticoResult.get();
                                    if (farmaceuticoResult.get().equals("0")){
                                        seguirAgregando=false;
                                    }else{
                                        farmaceuticos.add(agregarFarmaceutico);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacia.setFarmaceutico(farmaceuticos);
                            deleteBtnFarm.setOnAction(exe->{
                                boolean seguirQuitando=true;
                                while (seguirQuitando){
                                    TextInputDialog farmaceuticoDialog = new TextInputDialog();
                                    farmaceuticoDialog.setTitle("Quitar Farmacéutico");
                                    farmaceuticoDialog.setHeaderText(null);
                                    farmaceuticoDialog.setContentText("Introduce el nombre del farmacéutico o escribe '0' para terminar:");
                                    Optional<String> farmaceuticoResult = farmaceuticoDialog.showAndWait();
                                    String agregarFarmaceutico = farmaceuticoResult.get();
                                    if (farmaceuticoResult.get().equals("0")){
                                        seguirQuitando=false;
                                    }else{
                                        farmaceuticos.remove(agregarFarmaceutico);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacias.update(idFarmacia, farmacia);

                        });

                        productosButton.setOnAction(ex -> {


                            // Crear diseño
                            VBox layoutProductos = new VBox(10);
                            layoutProductos.getChildren().addAll(titleLabel, addBtnProd,deleteBtnProd);
                            layoutProductos.setSpacing(10);
                            layoutProductos.setPadding(new Insets(10));

                            // Crear escena
                            Scene sceneProductos = new Scene(layoutProductos, 600, 300);

                            // Asignar escena al escenario principal
                            primaryStage.setScene(sceneProductos);

                            // Mostrar la ventana
                            primaryStage.show();

                            addBtnProd.setOnAction(exe->{
                                boolean seguirAgregando=true;
                                while (seguirAgregando){
                                    TextInputDialog productoDialog = new TextInputDialog();
                                    productoDialog.setTitle("Añadir Producto");
                                    productoDialog.setHeaderText(null);
                                    productoDialog.setContentText("Introduce el nombre del producto o escribe '0' para terminar:");
                                    Optional<String> productResult = productoDialog.showAndWait();
                                    String agregarProducto = productResult.get();
                                    if (productResult.get().equals("0")){
                                        seguirAgregando=false;
                                    }else{
                                        productos.add(agregarProducto);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacias.update(idFarmacia, farmacia);

                            deleteBtnProd.setOnAction(exe->{
                                boolean seguirAgregando=true;
                                while (seguirAgregando){
                                    TextInputDialog productoDialog = new TextInputDialog();
                                    productoDialog.setTitle("Quitar Producto");
                                    productoDialog.setHeaderText(null);
                                    productoDialog.setContentText("Introduce el nombre del producto o escribe '0' para terminar:");
                                    Optional<String> productResult = productoDialog.showAndWait();
                                    String agregarProducto = productResult.get();
                                    if (productResult.get().equals("0")){
                                        seguirAgregando=false;
                                    }else{
                                        productos.remove(agregarProducto);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacias.update(idFarmacia, farmacia);



                        });


                        clientesButton.setOnAction(ex -> {

                            // Crear diseño
                            VBox layoutClient = new VBox(10);
                            layoutClient.getChildren().addAll(titleLabel, addBtnClient,deleteBtnClient);
                            layoutClient.setSpacing(10);
                            layoutClient.setPadding(new Insets(10));

                            // Crear escena
                            Scene sceneClient = new Scene(layoutClient, 600, 300);

                            // Asignar escena al escenario principal
                            primaryStage.setScene(sceneClient);

                            // Mostrar la ventana
                            primaryStage.show();

                            addBtnProd.setOnAction(exe->{
                                boolean seguirAgregando=true;
                                while (seguirAgregando){
                                    TextInputDialog clientDialog = new TextInputDialog();
                                    clientDialog.setTitle("Añadir Cliente");
                                    clientDialog.setHeaderText(null);
                                    clientDialog.setContentText("Introduce el nombre del Cliente o escribe '0' para terminar:");
                                    Optional<String> clientResult = clientDialog.showAndWait();
                                    String agregarCliente = clientResult.get();
                                    if (clientResult.get().equals("0")){
                                        seguirAgregando=false;
                                    }else{
                                        clientes.add(agregarCliente);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacias.update(idFarmacia, farmacia);

                            deleteBtnProd.setOnAction(exe->{
                                boolean seguirAgregando=true;
                                while (seguirAgregando){
                                    TextInputDialog clientDialog = new TextInputDialog();
                                    clientDialog.setTitle("Quitar Cliente");
                                    clientDialog.setHeaderText(null);
                                    clientDialog.setContentText("Introduce el nombre del Cliente o escribe '0' para terminar:");
                                    Optional<String> clientResult = clientDialog.showAndWait();
                                    String quitarCliente = clientResult.get();
                                    if (clientResult.get().equals("0")){
                                        seguirAgregando=false;
                                    }else{
                                        clientes.remove(quitarCliente);
                                    }
                                }
                                primaryStage.setScene(scene2);
                            });
                            farmacias.update(idFarmacia, farmacia);


                        });

                        horaButton.setOnAction(ex -> {
                            if (farmacia instanceof FarmaciaNormal) {
                                FarmaciaNormal farmaciaNormal = (FarmaciaNormal) farmacia;

                                TextInputDialog horarioDialog = new TextInputDialog();
                                horarioDialog.setTitle("Editar Horario");
                                horarioDialog.setHeaderText(null);
                                horarioDialog.setContentText("Introduce el nuevo horario:");

                                Optional<String> horarioResult = horarioDialog.showAndWait();
                                if (horarioResult.isPresent()) {
                                    String nuevoHorario = horarioResult.get();
                                    farmaciaNormal.setHorario(nuevoHorario);
                                    farmacias.update(idFarmacia, farmacia);
                                }
                            } else{
                                // showErrorAlert("Error", "La farmacia seleccionada no es una farmacia normal.");
                            }
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });

                        principalBack.setOnAction(ex->{
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });


                    }
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        deleteButton.setOnAction(e -> {
            List<Farmacia> tmp = farmacias.read();
            if (tmp.size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Lista de Farmacias");
                alert.setHeaderText(null);
                alert.setContentText("Empty");
                alert.showAndWait();
                primaryStage.setScene(scene);
                primaryStage.show();
            }

            // Obtener la ID de la farmacia a eliminar
            // Solicitar al usuario el tipo
            TextInputDialog typeDialog = new TextInputDialog();
            typeDialog.setTitle("ID Eliminar");
            typeDialog.setHeaderText("Id de la farmacia a eliminar");
            Optional<String> typeResult = typeDialog.showAndWait();

            // Convertir el ID de String a int
            int idToDelete = Integer.parseInt(typeResult.orElse("-1"));

            // Buscar la farmacia correspondiente
            boolean found = false;
            for (int i = 0; i < tmp.size(); i++) {
                if (idToDelete==tmp.get(i).getId()) {
                    farmacias.delete(i);
                    System.out.println("La farmacia ha sido eliminada");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Lista de Farmacias");
                    alert.setHeaderText(null);
                    alert.setContentText("Farmacia eliminada");
                    alert.showAndWait();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    found=true;
                    break;
                }
            }
            if (!found) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("No se encontró ninguna farmacia con el ID especificado");
                alert.showAndWait();
            }

        });
    }


}

