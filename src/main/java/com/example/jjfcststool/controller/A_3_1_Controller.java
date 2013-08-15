package com.example.jjfcststool.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import com.example.jjfcststool.Shiyanshai.shiyanshai;
import com.example.jjfcststool.util.Util;

public class A_3_1_Controller {
	
	private MainController parent;
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
	@FXML
	private TextField textFieldLength;
	@FXML
	private TextField textFieldLength2;
	@FXML
	private TextField textFieldLength3;
	@FXML
	private TextField textFieldDistributionK1;
	@FXML
	private TextField textFieldDistributionK2;
	@FXML
	private TextField textFieldDistributionK3;
	@FXML
	private TextField textFieldserialMaxDiff;
	@FXML
	private TextField textFieldLinearSerial;
	@FXML
	private TextField textFieldTempDiff1;
	@FXML
	private TextField textFieldTempDiff2;
	@FXML
	private TextField resultTextFiled1;
	@FXML
	private TextField resultTextFiled2;
	@FXML
	private TextField resultTextFiled3;
	@FXML
	private TextField resultTextFiled4;
	@FXML
	private TextField resultTextFiled5;
	@FXML
	private TextField resultTextFiled6;
	
	
	public Parent getView() {
		return root;
	}

	public MainController getParent() {
		return parent;
	}

	public void setParent(MainController parent) {
		this.parent = parent;
	}
	
	@FXML
	private void calculate(ActionEvent actionEvent) {
		shiyanshai sys = new shiyanshai();
		Double tmp = new Double("0.0");
		String text = "";
		//计算重复性不确定度
		List<Double> list = getInput();		
		tmp = sys.getMeasureUncertainty(list);
		text = Util.toString(tmp);
		resultTextFiled1.setText(text);
		
		//计算示值误差不确定度
		tmp = sys.getIndicationErrorUncertaintyMicroscope(Util.getDouble(textFieldLength), 
				Util.getDouble(textFieldDistributionK1));
		text = Util.toString(tmp);
		resultTextFiled2.setText(text);
		
		//线胀系数差不确定度
		tmp = sys.getCOLEUncertainty(Util.getDouble(textFieldserialMaxDiff)*Math.pow(10, -6),
				Util.getDouble(textFieldTempDiff1),Util.getDouble(textFieldLength2), Util.getDouble(textFieldDistributionK2));
		text = Util.toString(tmp);
		resultTextFiled3.setText(text);
		
		//温度差不确定度
		tmp = sys.getTemperatureDiffUncertainty(Util.getDouble(textFieldLinearSerial)*Math.pow(10, -6),
				Util.getDouble(textFieldTempDiff2),Util.getDouble(textFieldLength3),Util.getDouble(textFieldDistributionK3));
		text = Util.toString(tmp);
		resultTextFiled4.setText(text);
		
				
		//合成标准不确定度
		tmp = sys.getCombineUncertainty();
		text = Util.toString(tmp);
		resultTextFiled5.setText(text);
		
		//扩展不确定度
		tmp = sys.getExpUncertainty(new Double(2));
		text = Util.toString(tmp);
		resultTextFiled6.setText(text);
		
		
		/*
		sys = new shiyanshai();
		input = new double[]{0.022,0.023,0.022,0.023,0.024,0.024,0.022,0.022,0.023,0.022};
		System.out.printf("重复性不确定度%f\n", sys.getMeasureUncertainty(input,1));
		System.out.printf("示值误差%f\n", sys.getIndicationErrorUncertaintyMicroscope(0.02,3,1));
		System.out.printf("线胀系数差不确定度%f\n", sys.getCOLEUncertainty(9*Math.pow(10, -6),10,5,Math.pow(6, 0.5)));
		System.out.printf("温度差不确定度%f\n", sys.getTemperatureDiffUncertainty(18*Math.pow(10, -6),2,5,Math.pow(2, 0.5)));
		System.out.printf("合成标准不确定度=%f\n", sys.getCombineUncertainty());
		System.out.printf("扩展不确定度%f\n", sys.getExpUncertainty(2));
		 */
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
