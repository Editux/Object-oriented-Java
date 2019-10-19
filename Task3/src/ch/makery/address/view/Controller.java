package ch.makery.address.view;
import ch.makery.address.Main;
import ch.makery.address.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {
    @FXML
    private TableView<Student> personTable;
    @FXML
    private TableColumn<Student, String> NameColumn;
    @FXML
    private TableColumn<Student, String> SurnameColumn;
    @FXML
    private Label namelabel;
    @FXML
    private Label surnamelabel;
    @FXML
    private Label grouplabel;
    @FXML
    private Label semester;
    @FXML
    private Label englishgrade;
    @FXML
    private Label englishcredit;
    @FXML
    private Label mathgrade;
    @FXML
    private Label mathcredit;
    @FXML
    private Label physicsgrade;
    @FXML
    private Label physicscredit;
    @FXML
    private Label historygrade;
    @FXML
    private Label historycredit;
    @FXML
    private Label computergrade;
    @FXML
    private Label computercredit;

    private Main mainapp;
    public Controller(){
    }

    @FXML
    private void initialize() {

        NameColumn.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        SurnameColumn.setCellValueFactory(cellData->cellData.getValue().surnameProperty());
        showStudentdetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener((observarble,oldValue,newValue)->showStudentdetails(newValue));
    }

    public void setMainApp(Main main) {
        this.mainapp= main;

        // Add observable list data to the table
        personTable.setItems(main.getStudentData());
    }
    private void showStudentdetails(Student student) {
        if (student != null) {

            namelabel.setText(student.getName());
            surnamelabel.setText(student.getSurname());
            grouplabel.setText(student.getGroup());
            semester.setText(Integer.toString(student.getSemester()));
            englishgrade.setText(Integer.toString(student.getSubjectEgrade()));
            englishcredit.setText(Integer.toString(student.getSubjectEcredit()));
            mathgrade.setText(Integer.toString(student.getSubjectMgrade()));
            mathcredit.setText(Integer.toString(student.getSubjectMcredit()));
            physicsgrade.setText(Integer.toString((student.getSubjectPgrade())));
            physicscredit.setText(Integer.toString(student.getSubjectPcredit()));
            historygrade.setText(Integer.toString(student.getSubjectHgrade()));
            historycredit.setText(Integer.toString(student.getSubjectHcredit()));
            computergrade.setText(Integer.toString((student.getSubjectCgrade())));
            computercredit.setText(Integer.toString(student.getSubjectCcredit()));




        } else {
            // Person is null, remove all the text.
            //firstNameLabel.setText("");
            namelabel.setText("");
            surnamelabel.setText("");
            grouplabel.setText("");
            semester.setText("");
            englishgrade.setText("");
            englishcredit.setText("");
            mathgrade.setText("");
            mathcredit.setText("");
            physicsgrade.setText("");
            physicscredit.setText("");
            historygrade.setText("");
            historycredit.setText("");
            computergrade.setText("");
            computercredit.setText("");

        }
    }
    @FXML
    private void handleNewPerson() {
        Student tempPerson = new Student();
        boolean okClicked = Main.showPersonEditDialog(tempPerson);
        if (okClicked) {
            Main.getStudentData().add(tempPerson);
        }
    }
    @FXML
    private void handleEditPerson() {
        Student selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = Main.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showStudentdetails(selectedPerson);
            }
        }
    }
    @FXML
    private void deleteStudent(){
        int selectedIndex= personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }


    }}


