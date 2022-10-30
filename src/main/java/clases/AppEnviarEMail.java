package clases;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppEnviarEMail extends Application { 
	
	static Stage primaryStage;
	private ControllerEnviarEMail controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AppEnviarEMail.primaryStage = primaryStage;
		
		controller = new ControllerEnviarEMail();
		
		primaryStage.setTitle("Enviar email");
		primaryStage.getIcons().add(new Image("/images/email-send-icon-32x32.png"));
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
