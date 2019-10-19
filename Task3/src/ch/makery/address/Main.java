package ch.makery.address;


import ch.makery.address.model.Group;
import ch.makery.address.model.Subject;
import ch.makery.address.view.StudentEditController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ch.makery.address.view.Controller;
import ch.makery.address.model.Student;

import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.io.IOException;

public  class Main extends Application {

    private static Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * The data as an observable list of Persons.
     */
   private static ObservableList<Group> groupData= FXCollections.observableArrayList();
    private static ObservableList<Student> studentData = FXCollections.observableArrayList();
    private static ObservableList<Subject> subjectData =FXCollections.observableArrayList();



    public Main() {
        // Add some sample data

        studentData.add(new Student("Mich", "Fenderson",9,3,9,6,9,6,8,3,7,3));
        studentData.add(new Student("Ralph", "Jack",8,3,7,3,4,3,6,3,5,3));
        studentData.add(new Student("Nicole", "Jackson",5,6,8,6,9,3,7,3,9,3));
        studentData.add(new Student("Diego", "Levine",6,3,6,3,6,3,6,3,6,3));


    }
    public static ObservableList<Student> getStudentData(){ return studentData; }



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Student system App");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/sample.fxml"));
            AnchorPane sample = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(sample);

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean showPersonEditDialog(Student student) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/StudentEdit.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            StudentEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(student);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}