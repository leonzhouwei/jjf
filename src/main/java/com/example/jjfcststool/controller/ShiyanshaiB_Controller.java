package com.example.jjfcststool.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import com.example.jjfcststool.Shiyanshai.shiyanshai;
import com.example.jjfcststool.util.Util;

public class ShiyanshaiB_Controller {
	private MainController parent;
	@FXML
	private Parent rootB;
	@FXML
	private TextField textField1B;
	@FXML
	private TextField textField2B;
	@FXML
	private TextField textField3B;
	@FXML
	private TextField textField4B;
	@FXML
	private TextField textField5B;
	@FXML
	private TextField textField6B;
	@FXML
	private TextField textField7B;
	@FXML
	private TextField textField8B;
	@FXML
	private TextField textField9B;
	@FXML
	private TextField textField10B;
	@FXML
	private TextField resultTextFiledB;
	@FXML
	private TextField textFieldLengthB;
	@FXML
	private TextField textFieldLength2B;
	@FXML
	private TextField textFieldLength3B;
	@FXML
	private TextField textFieldDistributionK1B;
	@FXML
	private TextField textFieldDistributionK2B;
	@FXML
	private TextField textFieldDistributionK3B;
	@FXML
	private TextField textFieldserialMaxDiffB;
	@FXML
	private TextField textFieldLinearSerialB;
	@FXML
	private TextField textFieldTempDiff1B;
	@FXML
	private TextField textFieldTempDiff2B;
	@FXML
	private TextField resultTextFiled1B;
	@FXML
	private TextField resultTextFiled2B;
	@FXML
	private TextField resultTextFiled3B;
	@FXML
	private TextField resultTextFiled4B;
	@FXML
	private TextField resultTextFiled5B;
	@FXML
	private TextField resultTextFiled6B;
	@FXML
	private TextField resultTextFiled7B;
	@FXML
	private TextField duixianl;
	@FXML
	private TextField duixiank;
	
	public Parent getView() {
		return rootB;
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
		resultTextFiled1B.setText(text);
		
		//计算示值误差不确定度
		tmp = sys.getDivide(Util.getDouble(textFieldLengthB),Util.getDouble(textFieldDistributionK1B));	
		text = Util.toString(tmp);
		resultTextFiled2B.setText(text);
		
		//对线误差
		tmp = sys.getDivide(Util.getDouble(duixianl),Util.getDouble(duixiank));
		text = Util.toString(tmp);
		resultTextFiled3B.setText(text);
		
		//线胀系数差不确定度
		tmp = sys.getCOLEUncertainty(Util.getDouble(textFieldserialMaxDiffB)*Math.pow(10, -6),
				Util.getDouble(textFieldTempDiff1B),Util.getDouble(textFieldLength2B), Util.getDouble(textFieldDistributionK2B));
		text = Util.toString(tmp);
		resultTextFiled4B.setText(text);
		
		//温度差不确定度
		tmp = sys.getTemperatureDiffUncertainty(Util.getDouble(textFieldLinearSerialB)*Math.pow(10, -6),
				Util.getDouble(textFieldTempDiff2B),Util.getDouble(textFieldLength3B),Util.getDouble(textFieldDistributionK3B));
		text = Util.toString(tmp);
		resultTextFiled7B.setText(text);
		
				
		//合成标准不确定度
		tmp = sys.getCombineUncertainty();
		text = Util.toString(tmp);
		resultTextFiled5B.setText(text);
		
		//扩展不确定度
		tmp = sys.getExpUncertainty(new Double(2));
		text = Util.toString(tmp);
		resultTextFiled6B.setText(text);
		
		
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
		d = Util.getDouble(textField1B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField2B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField3B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField4B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField5B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField6B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField7B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField8B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField9B);
		if (d != null) {
			list.add(d);
		}
		d = Util.getDouble(textField10B);
		if (d != null) {
			list.add(d);
		}
		return list;
	}
}
