package edu.mum.library.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.mum.library.common.LibraryException;
import edu.mum.library.service.LibraryService;
import edu.mum.library.view.base.BaseFxModalController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PrintCheckoutRecordController extends BaseFxModalController {

	@Override
	public void postInit() {
	}

	@FXML
	private TextField memberIdField;

	@Autowired
	private LibraryService libraryService;

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			try {
				libraryService.printCheckoutRecord(memberIdField.getText());
			} catch (LibraryException e) {
				fxViewManager.showError(this.getCurrentStage(), e.getMessage(), "Error", "Database error");
			}
		}
	}

}
