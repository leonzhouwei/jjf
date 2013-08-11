package com.example.jjfcststool.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.jjfcststool.util.Util;

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
	@FXML
	private TextField resultTextFiled;
	
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
		List<Double> list = getInput();
		Double standardVariance = Util.getDoubleStandardVariance(list);
		String text = Util.toString(standardVariance*1000);
		resultTextFiled.setText(text);
	}
	
	private List<Double> getInput() {
		List<Double> list = new ArrayList<Double>();
		Double d = null;
		d = Util.getDouble(textField1);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField2);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField3);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField4);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField5);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField6);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField7);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField8);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField9);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField10);
		if (d != null) {
			list.add(d);
		}
		return list;
	}
	
}
