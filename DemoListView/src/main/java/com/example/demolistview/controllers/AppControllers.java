package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    @FXML
    private ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAdd(){
        String name = txtName.getText();
        String email = txtEmail.getText();
        try {
            service.addPerson(name,email);
            lblMsg.setStyle("-fx-text-fill: green");
            lblMsg.setText("Persona creada con exito.");
            txtEmail.clear();
            txtName.clear();
        }catch (IOException IOException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con el archivo.");
        }catch (IllegalArgumentException argumentException){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error con los datos.");
        }

    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setStyle("-fx-text-fill: green");
            lblMsg.setText("Datos cargados con exito");
        }catch (IOException e){
            lblMsg.setStyle("-fx-text-fill: red");
            lblMsg.setText("Error al cargar los archivos.");
        }

    }
}