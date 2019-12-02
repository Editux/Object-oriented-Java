package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static java.lang.String.*;
import static sample.Main.*;

public class Controller {
    @FXML
    private TableView<Menu> menuTable;
    @FXML
    private TableColumn<Menu, String> NameColumn;
    @FXML
    private TableView<Orderfood> orderTable;
    @FXML
    private TableColumn<Orderfood,String> OrderColumn;
    @FXML
    private Label namelabel;
    @FXML
    private Label descriptionlabel;
    @FXML
    private Label pricelabel;
    @FXML
    private Label totallabel;
    @FXML
    private Label totalVatlabel;

    private Main mainapp;



    @FXML
    private void initialize() {

        NameColumn.setCellValueFactory(cellData -> cellData.getValue().dishnameProperty());
        OrderColumn.setCellValueFactory(cellData->cellData.getValue().dishnameProperty());



        showMenu(null);
        showOrder(null);


        menuTable.getSelectionModel().selectedItemProperty().addListener((observarble,oldValue,newValue)->showMenu(newValue));
        orderTable.getSelectionModel().selectedItemProperty().addListener((observarble,oldValue,newValue)->showOrder(newValue));
    }

    private void showMenu(Menu menu){
        if(menu != null){
        //namelabel.setText(student.getName());
            namelabel.setText(menu.getDishname());
            descriptionlabel.setText(menu.getDescription());
            pricelabel.setText(Integer.toString(menu.getPrice()));
        } else {

            namelabel.setText("");
            descriptionlabel.setText("");
            pricelabel.setText("");
        }

    }
    private void showOrder(Orderfood orderfood) {
        if (orderfood != null) {
           totallabel.setText(Double.toString(orderfood.getTotal()));
           totalVatlabel.setText(Double.toString(orderfood.getTotalVat()));
        }else {
            totallabel.setText("");
            totalVatlabel.setText("");
        }
    }

    @FXML
    private void AddtotheBasket(){
        Menu selection = menuTable.getSelectionModel().getSelectedItem();

        if (selection != null) {

            orderTable.getItems().add(new Orderfood(selection.getDishname(),selection.getDescription(),selection.getPrice()));
        }
    }


    @FXML
    private void handleDelete(){
        Orderfood selectedItem = orderTable.getSelectionModel().getSelectedItem();
        orderTable.getItems().remove(selectedItem);
    }
    @FXML
    private void handleRefresh(){
        orderTable.refresh();

    }


    public void setMainApp(Main main) {
        this.mainapp = main;

        // Add observable list data to the table
        menuTable.setItems(main.getMenuData());
        orderTable.setItems(main.getOrderData());

    }
}
