package clases;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelEnviarEMail {

	private StringProperty servidorSMTP = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private StringProperty emailRemitente = new SimpleStringProperty();
	private StringProperty contrasenia = new SimpleStringProperty();
	private StringProperty emailDestinatario = new SimpleStringProperty();
	private StringProperty asuntoMensaje = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	
	private BooleanProperty conexionSSL = new SimpleBooleanProperty();

	public final StringProperty servidorSMTPProperty() {
		return this.servidorSMTP;
	}
	

	public final String getServidorSMTP() {
		return this.servidorSMTPProperty().get();
	}
	

	public final void setServidorSMTP(final String servidorSMTP) {
		this.servidorSMTPProperty().set(servidorSMTP);
	}
	

	
	public final StringProperty puertoProperty() {
		return this.puerto;
	}
	

	public final String getPuerto() {
		return this.puertoProperty().get();
	}
	

	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	

	
	public final StringProperty emailRemitenteProperty() {
		return this.emailRemitente;
	}
	

	public final String getEmailRemitente() {
		return this.emailRemitenteProperty().get();
	}
	

	public final void setEmailRemitente(final String emailRemitente) {
		this.emailRemitenteProperty().set(emailRemitente);
	}
	

	
	public final StringProperty contraseniaProperty() {
		return this.contrasenia;
	}
	

	public final String getContrasenia() {
		return this.contraseniaProperty().get();
	}
	

	public final void setContrasenia(final String contrasenia) {
		this.contraseniaProperty().set(contrasenia);
	}
	

	
	public final StringProperty emailDestinatarioProperty() {
		return this.emailDestinatario;
	}
	

	public final String getEmailDestinatario() {
		return this.emailDestinatarioProperty().get();
	}
	

	public final void setEmailDestinatario(final String emailDestinatario) {
		this.emailDestinatarioProperty().set(emailDestinatario);
	}
	

	
	public final StringProperty asuntoMensajeProperty() {
		return this.asuntoMensaje;
	}
	

	public final String getAsuntoMensaje() {
		return this.asuntoMensajeProperty().get();
	}
	

	public final void setAsuntoMensaje(final String asuntoMensaje) {
		this.asuntoMensajeProperty().set(asuntoMensaje);
	}
	

	
	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}
	

	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	

	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	

	
	public final BooleanProperty conexionSSLProperty() {
		return this.conexionSSL;
	}
	

	public final boolean isConexionSSL() {
		return this.conexionSSLProperty().get();
	}
	

	public final void setConexionSSL(final boolean conexionSSL) {
		this.conexionSSLProperty().set(conexionSSL);
	}
}
