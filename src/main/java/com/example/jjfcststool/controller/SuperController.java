package com.example.jjfcststool.controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SuperController {

	protected Stage stage;

	abstract public Parent getView();

	public SuperController create(Stage stage, Stage parent) {
		if (this.stage != null) {
			return this;
		}
		this.stage = stage;
		Scene scene = new Scene(getView());
		stage.setScene(scene);
		if (parent != null) {
			stage.initOwner(parent);
		}
		return this;
	}
	
    public SuperController setTitle(String title) {
        stage.setTitle(title);
        return this;               
    }
    
    public SuperController show() {
        stage.show();
        return this;
    }

    public SuperController hide() {
        stage.hide();
        return this;
    }

    public void close() {
        stage.close();
    }
    
    public void resizeTo(int w, int h) {
        if (stage != null) {
            stage.setWidth(w);
            stage.setHeight(h);
        }
    }
}
