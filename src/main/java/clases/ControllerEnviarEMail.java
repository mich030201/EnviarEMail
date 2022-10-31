package clases;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControllerEnviarEMail implements Initializable {
	
	private AppEnviarEMail app = new AppEnviarEMail();
	
	//Model
	private ModelEnviarEMail model = new ModelEnviarEMail();
	
	//View
    @FXML
    private Label asuntoLabel;

    @FXML
    private TextField asuntoTextField;

    @FXML
    private VBox botoneraVBox;

    @FXML
    private GridPane camposGridPane;

    @FXML
    private Button cerrarButton;

    @FXML
    private Label conexionSSLLabel;

    @FXML
    private PasswordField contrasenisPasswordField;

    @FXML
    private Label destinatarioLabel;

    @FXML
    private TextField destinatarioTextField;

    @FXML
    private TextField emailRemitenteTextField;

    @FXML
    private Button enviarButton;

    @FXML
    private TextArea mensajeTextArea;

    @FXML
    private TextField puertoTextField;

    @FXML
    private Label remitenteLabel;

    @FXML
    private HBox root;

    @FXML
    private Label servidorSMTPLabel;

    @FXML
    private TextField servidorTextField;

    @FXML
    private CheckBox sslCheckBox;

    @FXML
    private Button vaciarButton;
			
	public ControllerEnviarEMail() throws IOException {
		
		//Cargar el FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		
		//Listeners
		
	}

	public void initialize(URL location, ResourceBundle resources) {

		//Bindings
		model.conexionSSLProperty().bind(sslCheckBox.selectedProperty());
		model.servidorSMTPProperty().bind(servidorTextField.textProperty());
		model.puertoProperty().bind(puertoTextField.textProperty());
		model.emailRemitenteProperty().bind(emailRemitenteTextField.textProperty());
		model.contraseniaProperty().bind(contrasenisPasswordField.textProperty());
		model.emailDestinatarioProperty().bind(destinatarioTextField.textProperty());
		model.asuntoMensajeProperty().bind(asuntoTextField.textProperty());
		model.mensajeProperty().bind(mensajeTextArea.textProperty());
		model.conexionSSLProperty().bind(sslCheckBox.selectedProperty());
	}
	
	@FXML
	private void onEnviar(ActionEvent e) throws EmailException {
		boolean enviar = true;
		Email email = new SimpleEmail();
		
		try {
			int puerto = Integer.parseInt(model.getPuerto());
			email.setHostName(model.getServidorSMTP());
			email.setSmtpPort(puerto);
			email.setAuthenticator(new DefaultAuthenticator(model.getEmailRemitente(), model.getContrasenia()));
			email.setSSLOnConnect(true);
			email.setFrom(model.getEmailRemitente());
			email.setSubject(model.getAsuntoMensaje());
			email.setMsg(model.getMensaje());
			email.addTo(model.getEmailDestinatario());
			email.send();
		} catch(EmailException emailError) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText("No se pudo enviar el email.");
			error.setContentText("Ooops, there was an error!");

			error.showAndWait();
			enviar = false;
		}
		 if(enviar == true) {
			 Alert enviado = new Alert(AlertType.INFORMATION);
			enviado.setTitle("Mensaje enviado");
			enviado.setHeaderText(null);
			enviado.setContentText("Mensaje enviado con exito a '" + model.getEmailDestinatario() + "'");

			enviado.showAndWait(); 
		 }
	}
	
	@FXML
	private void onCerrar(ActionEvent e) throws EmailException {
		app.primaryStage.close();
	}
	
	@FXML
	private void onVaciar(ActionEvent e) throws EmailException {
//		model.setAsuntoMensaje(" ");
//		model.setConexionSSL(false);
//		model.setContrasenia(" ");
//		model.setEmailDestinatario(" ");
//		model.setEmailRemitente(" ");
//		model.setMensaje(" ");
//		model.setPuerto(" ");
//		model.setServidorSMTP(" ");
		
		asuntoTextField.setText("");
		contrasenisPasswordField.setText("");
		destinatarioTextField.setText("");
		emailRemitenteTextField.setText("");
		mensajeTextArea.setText("");
		puertoTextField.setText("");
		servidorTextField.setText("");
		sslCheckBox.setSelected(false);
	}
	
	public HBox getView() {
		return root;
	}
}
