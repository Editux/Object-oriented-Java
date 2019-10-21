package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Student;

public class StudentEditController {




        @FXML
        private TextField NameField;
        @FXML
        private TextField SurnameField;
        @FXML
        private TextField GroupField;
    @FXML
    private TextField SemesterField;
    @FXML
    private TextField EnglishGField;
    @FXML
    private TextField EnglishCField;
    @FXML
    private TextField MathGField;
    @FXML
    private TextField MathCField;
    @FXML
    private TextField PhysicsGField;
    @FXML
    private TextField PhysicsCField;
    @FXML
    private TextField HistoryGField;
    @FXML
    private TextField HistoryCField;
    @FXML
    private TextField ComputerGField;
    @FXML
    private TextField ComputerCField;




        private Stage dialogStage;
        private Student student;
        private boolean okClicked = false;
        public static int number=4;

        /**
         * Initializes the controller class. This method is automatically called
         * after the fxml file has been loaded.
         */
        @FXML
        private void initialize() {
        }

        /**
         * Sets the stage of this dialog.
         *
         * @param dialogStage
         */
        public void setDialogStage(Stage dialogStage) {
            this.dialogStage = dialogStage;
        }

        /**
         * Sets the person to be edited in the dialog.
         *
         * @param student
         */
        public void setPerson(Student student) {
            this.student = student;

            NameField.setText(student.getName());
            SurnameField.setText(student.getSurname());
            GroupField.setText(student.getGroup());
            SemesterField.setText(Integer.toString(student.getSemester()));
            EnglishGField.setText(Integer.toString(student.getSubjectEgrade()));
            EnglishCField.setText(Integer.toString(student.getSubjectEcredit()));
            MathGField.setText(Integer.toString(student.getSubjectMgrade()));
            MathCField.setText(Integer.toString(student.getSubjectMcredit()));
            PhysicsGField.setText(Integer.toString(student.getSubjectPgrade()));
            PhysicsCField.setText(Integer.toString(student.getSubjectPcredit()));
            HistoryGField.setText(Integer.toString(student.getSubjectHgrade()));
            HistoryCField.setText(Integer.toString(student.getSubjectHcredit()));
            ComputerGField.setText(Integer.toString(student.getSubjectCgrade()));
            ComputerCField.setText(Integer.toString(student.getSubjectCcredit()));
            number++;
        }

        /**
         * Returns true if the user clicked OK, false otherwise.
         *
         * @return
         */
        public boolean isOkClicked() {
            return okClicked;
        }


        @FXML
        private void handleOk() {
            if (isInputValid()) {

                student.setName(NameField.getText());
                student.setSurname(SurnameField.getText());
                student.setGroup(GroupField.getText());
                student.setSubjectEgrade(Integer.parseInt(EnglishGField.getText()));
                student.setSubjectEcredit(Integer.parseInt(EnglishCField.getText()));
                student.setSubjectMgrade(Integer.parseInt(MathGField.getText()));
                student.setSubjectMcredit(Integer.parseInt(MathCField.getText()));
                student.setSubjectPgrade(Integer.parseInt(PhysicsGField.getText()));
                student.setSubjectPcredit(Integer.parseInt(PhysicsCField.getText()));
                student.setSubjectHgrade(Integer.parseInt(HistoryGField.getText()));
                student.setSubjectHcredit(Integer.parseInt(HistoryCField.getText()));
                student.setSubjectCgrade(Integer.parseInt(ComputerGField.getText()));
                student.setSubjectCcredit(Integer.parseInt(ComputerCField.getText()));

                okClicked = true;
                dialogStage.close();
            }
        }

        /**
         * Called when the user clicks cancel.
         */
        @FXML
        private void handleCancel() {
            dialogStage.close();
        }

        /**
         * Validates the user input in the text fields.
         *
         * @return true if the input is valid
         */
        private boolean isInputValid() {
            String errorMessage = "";

            if (NameField.getText() == null || NameField.getText().length() == 0) {
                errorMessage += "No valid first name!\n";
            }
            if (SurnameField.getText() == null || SurnameField.getText().length() == 0) {
                errorMessage += "No valid last name!\n";
            }
            if (GroupField.getText() == null || GroupField.getText().length() == 0) {
                errorMessage += "No valid street!\n";
            }


            if (errorMessage.length() == 0) {
                return true;
            } else {
                // Show the error message.
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText(errorMessage);

                alert.showAndWait();

                return false;
            }
        }
    }

