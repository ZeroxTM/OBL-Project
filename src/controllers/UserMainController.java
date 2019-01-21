package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Account;
import entities.UserAccount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UserMainController implements Initializable {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label lblUsername;

	@FXML
	private Label lblStatus;

	@FXML
	private ImageView imgLogout;

	@FXML
	private ImageView imgSearch;

	@FXML
	private ImageView imgHistory;

	@FXML
	private ImageView imgSettings;

	@FXML
	private ImageView imgExtendBook;

	private static Stage stage;
	private static Scene scene;

	private static UserAccount loggedAccount;

	@FXML
	void imgExtendBookClicked(MouseEvent event) {
		SceneController.push(scene);
		// stage.initModality(Modality.APPLICATION_MODAL);
		ExtendLendController ExtendLendForm = new ExtendLendController();
		try {
			ExtendLendForm.start(stage, loggedAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void imgHistoryClicked(MouseEvent event) {
		SceneController.push(scene);
		// stage.initModality(Modality.APPLICATION_MODAL);
		ActivityController ActivityForm = new ActivityController();
		try {
			ActivityForm.start(stage, loggedAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void imgLogoutClicked(MouseEvent event) {
		// DatabaseController.userLogIO();
	}

	@FXML
	void imgSearchClicked(MouseEvent event) {
		SceneController.push(scene);
		// stage.initModality(Modality.APPLICATION_MODAL);
		SearchController SearchForm = new SearchController();
		try {
			SearchForm.start(stage, loggedAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void imgSettingsClicked(MouseEvent event) {
		SceneController.push(scene);
		// stage.initModality(Modality.APPLICATION_MODAL);
		AccountDetailsController AccountDetailsForm = new AccountDetailsController();
		try {
			AccountDetailsForm.start(stage, loggedAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblUsername.setText(loggedAccount.getFirstName());
	}

	void start(Stage primaryStage, Account loggedAccount) throws Exception {
		this.loggedAccount = (UserAccount) loggedAccount;
		stage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("../gui/UserMainForm.fxml"));
		scene = new Scene(root);
		primaryStage.setTitle("User Main");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
