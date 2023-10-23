package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x=0;
    private double y=0;

    public void Login(){
        String sql="SELECT * FROM admin WHERE username = ? AND password = ?";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2,password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if(username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }
            else{
                if(result.next()){

                    data.username=username.getText();
                    // Not really needed
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successfully!");
                    alert.showAndWait();
                    
                    
                    login.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) ->
                    {
                        x=event.getSceneX();
                        y=event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) ->
                    {
                        stage.setX(event.getSceneX()-x);
                        stage.setY(event.getSceneY()-y);
                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        System.exit(0);
    }

    public void initiliaze(URL url, ResourceBundle rb){

    }
}