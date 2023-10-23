package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private Label username;
    @FXML
    private AnchorPane main_form;
    @FXML
    private Button availableFD_addBtn;

    @FXML
    private Button availableFD_clearBtn;

    @FXML
    private TableColumn<?, ?> availableFD_col_price;

    @FXML
    private TableColumn<?, ?> availableFD_col_productID;

    @FXML
    private TableColumn<?, ?> availableFD_col_productName;

    @FXML
    private TableColumn<?, ?> availableFD_col_status;

    @FXML
    private TableColumn<?, ?> availableFD_col_type;

    @FXML
    private Button availableFD_deleteBtn;

    @FXML
    private AnchorPane availableFD_form;

    @FXML
    private TextField availableFD_productID;

    @FXML
    private TextField availableFD_productName;

    @FXML
    private TextField availableFD_productPrice;

    @FXML
    private ComboBox<?> availableFD_productStatus;

    @FXML
    private ComboBox<?> availableFD_productType;

    @FXML
    private TextField availableFD_search;

    @FXML
    private Button availableFD_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private ComboBox<?> orderProductID;

    @FXML
    private ComboBox<?> orderProductName;

    @FXML
    private Button order_addBtn;

    @FXML
    private TextField order_amount;

    @FXML
    private TableColumn<?, ?> order_col_price;

    @FXML
    private TableColumn<?, ?> order_col_productID;

    @FXML
    private TableColumn<?, ?> order_col_productName;

    @FXML
    private TableColumn<?, ?> order_col_quantity;

    @FXML
    private TableColumn<?, ?> order_col_type;

    @FXML
    private AnchorPane order_form;

    @FXML
    private Button order_payBtn;

    @FXML
    private Spinner<?> order_quantity;

    @FXML
    private Button order_receiptBtn;

    @FXML
    private Button order_removeBtn;

    @FXML
    private TableView<?> order_tableView;

    @FXML
    private Label order_total;

    private double x=0;
    private double y=0;
    public void logout(){
        try{
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option=alert.showAndWait();

            if(option.equals(ButtonType.OK)){
                Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage stage=new Stage();
                Scene scene=new Scene(root);

                root.setOnMousePressed((MouseEvent event) ->{
                    x=event.getSceneX();
                    y=event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) ->{
                    stage.setX(event.getSceneX() + x);
                    stage.setY(event.getSceneY() + y);

                    stage.setOpacity(1);
                });

                root.setOnMouseReleased((MouseEvent event) ->{
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void displayUsername(){
        String user=data.username;
        user=user.substring(0,1).toUpperCase()+user.substring(1);

        username.setText(user);
    }

    public void close(){
        System.exit(0);
    }

    public void minimize(){
        Stage stage=(Stage)main_form.getScene().getWindow();
        stage.setIconified(true);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        displayUsername();
    }
}
