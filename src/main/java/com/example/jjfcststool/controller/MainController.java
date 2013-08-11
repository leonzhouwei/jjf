package com.example.jjfcststool.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import javax.annotation.Resource;

import com.example.jjfcststool.view.model.GuiElemDefine;

public class MainController extends SuperController {
	
	@FXML
	private Parent root;
	@FXML
	private Tab tab1;
	@Resource
	private A_3_1_Controller a_3_1_Controller;

	@Override
	public Parent getView() {
		return root;
	}
	
	public void init() {
		stage.setTitle(GuiElemDefine.MAIN_WINDOW_TTTLE);
		tab1.setContent(a_3_1_Controller.getView());
	}
	
}
