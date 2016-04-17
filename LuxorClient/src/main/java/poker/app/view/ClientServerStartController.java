package poker.app.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import poker.app.MainApp;
import pokerBase.Action;
import pokerEnums.eAction;

public class ClientServerStartController {
	
	@FXML private TextField txtPlayerName;
	@FXML private RadioButton rbtnServer;
	@FXML private RadioButton rbtnClient;
	@FXML private TextField txtServerPort;
	@FXML private TextField txtClientPort;
	@FXML private TextField txtComputerName;

	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void optServerClientSelected(ActionEvent event)
	{
		RadioButton rbServerClient = (RadioButton) event.getSource();
		switch (rbServerClient.getId().toString())
		{
		case "rbtnServer":
			txtServerPort.setDisable(!rbServerClient.isSelected());
			txtClientPort.setDisable(rbServerClient.isSelected());
			txtComputerName.setDisable(rbServerClient.isSelected());
			break;
		case "rbtnClient":
			txtServerPort.setDisable(rbServerClient.isSelected());
			txtClientPort.setDisable(!rbServerClient.isSelected());
			txtComputerName.setDisable(!rbServerClient.isSelected());
			
			break;
		}
	}
	
	@FXML
	public void btnOK(ActionEvent event)
	{
		int iPort = 0;
		String strComputerName = "localhost";
		boolean bServer = false;		
		if (rbtnServer.isSelected())
		{
			bServer = true;
			iPort = Integer.parseInt(txtServerPort.getText());
		}
		else if (rbtnClient.isSelected())
		{
			strComputerName = txtComputerName.getText();
			iPort = Integer.parseInt(txtClientPort.getText());
		}		
		mainApp.showPoker(bServer, strComputerName, iPort, txtPlayerName.getText());
	}
	
	@FXML
	public void btnCancel(ActionEvent event)
	{
		Platform.exit();
        System.exit(0);
        
		System.out.println("End Program");

	}
}
