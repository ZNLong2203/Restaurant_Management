import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HTMLLoginApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a WebView and a WebEngine
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Load the login.html file (assuming it's in the same package as this class)
        webEngine.load(getClass().getResource("login.html").toExternalForm());

        StackPane root = new StackPane(webView);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("HTML Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
