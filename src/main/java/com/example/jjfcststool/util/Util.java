package com.example.jjfcststool.util;

import java.util.List;

import javafx.scene.control.TextField;

public final class Util {
	
	public static final String getTrimedText(TextField tf) {
		return tf.getText().trim();
	}
	
	public static final Float getFloat(TextField tf) {
		Float result = null;
		String string = getTrimedText(tf);
		if (!string.isEmpty()) {
			result = Float.parseFloat(string);
		}
		return result;
	}
	
	public static final Double getDouble(TextField tf) {
		String string = getTrimedText(tf);
		Double result = null;
		if (!string.isEmpty()) {
			result = new Double(string);
		}
		return result;
	}
	
	public static final Double getDoubleAverage(List<Double> list) {
		Double result = Double.parseDouble("0.0");
		for (Double d : list) {
			result += d;
		}
		result /= list.size();
		return result;
	}
	
	public static final Double getDoubleStandardVariance(List<Double> list) {
		Double result = Double.parseDouble("0.0");
		final Double average = getDoubleAverage(list);
		for (Double d : list) {
			Double temp = d - average;
			temp *= temp;
			result += temp;
		}
		result /= list.size() - 1;
		result = Math.sqrt(result);
		return result;
	}
	
}
