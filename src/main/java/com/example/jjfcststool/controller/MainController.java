package com.example.jjfcststool.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class MainController extends SuperController {
	
	@FXML
	private Parent root;
	@FXML
	private Tab tab1;

	@Override
	public Parent getView() {
		System.out.println(root);
		return root;
	}
	
}
