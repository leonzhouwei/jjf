package com.example.jjfcststool.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class A_3_1_Controller {
	
	private Stage parent;
	@FXML
	private Parent root;
	@FXML
	private TextField textField1;
	@FXML
	private TextField textField2;
	@FXML
	private TextField textField3;
	@FXML
	private TextField textField4;
	@FXML
	private TextField textField5;
	@FXML
	private TextField textField6;
	@FXML
	private TextField textField7;
	@FXML
	private TextField textField8;
	@FXML
	private TextField textField9;
	@FXML
	private TextField textField10;
	
	public Parent getView() {
		return root;
	}

	public Stage getParent() {
		return parent;
	}

	public void setParent(Stage parent) {
		this.parent = parent;
	}
	
	@FXML
	private void calculate(ActionEvent actionEvent) {
		textField1.setText("haha");
	}
}
