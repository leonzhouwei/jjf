package com.example.jjfcststool;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.jjfcststool.controller.MainController;

public class Startup extends Application {

	private static Map<String, Object> controllers = new HashMap<String, Object>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// Parent root =
		// FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
		// System.out.println(root);
		// Scene scene = new Scene(root);
		//
		// stage.setTitle("JJF");
		// stage.setScene(scene);
		// stage.show();

		// 加载全部 .fxml 文件
		String path = getClass().getResource("/fxml").getPath();
		if (path.startsWith("file:")) {
			path = path.substring(5).replaceFirst("[^/]*jar!/fxml$", "fxml");
		}
		path = URLDecoder.decode(path, "UTF-8");
		File dir = new File(path);
		for (File child : dir.listFiles()) {
			if (child.getName().endsWith(".fxml") == false) {
				continue;
			}
			FXMLLoader loader = new FXMLLoader();
			try {
				loader.load(new FileInputStream(child));
				System.out.println(child.getName());
				controllers.put(child.getName(), loader.getController());
			} catch (Exception e) {
				System.err.println("Cannot load FXML:" + child.getName());
			}
		}

		// spring
		final ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		MainController mc = context.getBean(MainController.class);
		mc.create(new Stage(), stage);
		mc.show();
		System.out.println(mc);
		System.out.println(mc.getView());
	}

	@SuppressWarnings("unchecked")
	public static <T> T getController(String fxml) {
		return (T) controllers.get(fxml);
	}
}
