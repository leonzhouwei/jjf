package com.example.jjfcststool.Shiyanshai;

import java.util.ArrayList;
import java.util.List;


public class shiyanshai {
	private List<Double> ud;
	public shiyanshai(){
		ud = new ArrayList<Double>();
	}
	
	private Double getDoubleAverage(List<Double> list) {
		Double result = Double.parseDouble("0.0");
		for (Double d : list) {
			result += d;
		}
		result /= list.size();
		return result;
	}
	
	/**
	 * 测量重复性引起的标准不确定度，输入参数单位为毫米，单位为mm
	 * @param list 测量输入数组
	 * @param c 灵敏系数
	 * @return 返回测量重复性引起的标准不确定度
	 */
	private Double getMeasureUncertainty(List<Double> list, Double c) {
		Double result = Double.parseDouble("0.0");
		final Double average = getDoubleAverage(list);
		for (Double d : list) {
			Double temp = d - average;
			temp *= temp;
			result += temp;
		}
		result /= list.size() - 1;
		result = Math.sqrt(result);
		result *= c;
		result *= 1000;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	/**
	 * 测量重复性引起的标准不确定度，输入参数单位为毫米，单位为mm
	 * @param arrInput 测量输入数组
	 * @param c 灵敏系数
	 * @return 返回测量重复性引起的标准不确定度
	 */
	public Double getMeasureUncertainty(List<Double> list){
		Double c = new Double(1);
		return getMeasureUncertainty(list, c);
	}

	public Double getIndicationErrorUncertaintyMicroscope(Double length, Double distributionK){
		Double c = new Double(1);
		return getIndicationErrorUncertaintyMicroscope(length, distributionK ,c);
	}
	/**
	 * 计算万能显微镜示值误差引起的标准不确定度
	 * @param length 测量长度，单位毫米mm
	 * @param distributionK 正态分布K数取值
	 * @param c 灵敏系数
	 * @return 返回示值误差引起的标准不确定度,单位μm
	 */
	public Double getIndicationErrorUncertaintyMicroscope(Double length, Double distributionK, Double c ){
		Double result = Double.parseDouble("0.0");
		result = (1 + length * 1000 / 100 ) / distributionK * c;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	/**
	 * 计算游标卡尺示值误差以及对线误差引起的标准不确定度
	 * @return 返回示值误差引起的标准不确定度,单位μm
	 */
	public Double getDivide(Double x, Double y){
		Double result = Double.parseDouble("0.0");
		result = x/y;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	
	public Double getIndicationErrorUncertaintyCaliper(Double error, Double distributionK){
		Double c = new Double(1);
		return getIndicationErrorUncertaintyCaliper(error, distributionK ,c);
	}
	/**
	 * 计算游标卡尺示值误差引起的标准不确定度
	 * @param error 误差，单位微米μm
	 * @param distributionK 正态分布K取值
	 * @param c 灵敏系数
	 * @return 返回游标卡尺示值误差引起的标准不确定度,单位微米μm
	 */
	public Double getIndicationErrorUncertaintyCaliper(Double error, Double distributionK, Double c){
		Double result = Double.parseDouble("0.0");
		result = error / distributionK * c;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	/**
	 * 计算线胀系数差引起的标准不确定度
	 * @param serialDiff 
	 * @param tempDiff 温度差
	 * @param length 测量长度
	 * @param distributionK 分布K值
	 * @return 线胀系数差引起的标准不确定度，单位μm
	 */
	public Double getCOLEUncertainty(Double serialDiff, Double deltaT, Double length, Double distributionK){
		Double result = Double.parseDouble("0.0");
		result = length * 1000 * deltaT * serialDiff / distributionK;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	/**
	 * 计算温度差差引起的标准不确定度 
	 * @param serial
	 * @param deltaT
	 * @param length
	 * @param distributionK
	 * @return 温度差差引起的标准不确定度 ,单位微米μm
	 */
	public Double getTemperatureDiffUncertainty(Double serial, Double deltaT, Double length, Double distributionK){
		Double result = Double.parseDouble("0.0");
		result = length * 1000 * deltaT * serial / distributionK;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	
	public Double getLineErrorUncertainty(Double LineError, Double distributionK){
		Double c = new Double(1);
		return getLineErrorUncertainty(LineError, distributionK ,c);
	}
	/**
	 * 计算对线误差引起的标准不确定度
	 * @param LineError 
	 * @param distributionK 三角分布K数取值
	 * @param c 灵敏系数
	 * @return 对线误差引起的标准不确定度,单位微米μm
	 */
	public Double getLineErrorUncertainty(double LineError, double distributionK ,double c){
		Double result = Double.parseDouble("0.0");
		result = LineError / distributionK * c;;
		ud.add(result);
		return ud.get(ud.size()-1);
	}
	
	/**
	 * 计算合成不确定度Uc
	 * @return 合成不确定度Uc,单位微米μm
	 */
	public Double getCombineUncertainty(){
		Double sum = Double.parseDouble("0.0");
		for (Double d : ud) {
			d *= d;
			sum += d;
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * 计算扩展不确定度
	 * @param distributionK
	 * @return 扩展部确定度,单位微米μm
	 */
	public Double getExpUncertainty(Double distributionK){
		return getCombineUncertainty() * distributionK;
	}
}
