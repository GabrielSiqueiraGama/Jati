package br.com.zhant.Jati;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JatiApplication extends Application {

	public static void main(String[] args) {
		launch(args);
		SpringApplication.run(JatiApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
	}
}
