package soldasim.MTG_ER_Table.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import soldasim.MTG_ER_Table.Controller.Controller;
import soldasim.MTG_ER_Table.Controller.TextParser;

import java.util.ArrayList;

/**
 * View according to the MVC application model.
 * Handles user interaction and displaying the application.
 */
public class View extends Application implements Runnable {

    private static final String WINDOW_TITLE = "MTG ER Table";
    private static final Insets PADDING = new Insets(12, 12, 12, 12);
    private static final int SPACING = 12;

    private Controller controller;

    private Stage mainStage;
    private Scene testScene;

    /**
     * Save a reference to the application controller.
     * @param controller the controller
     * @see Controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Call launch() to launch the view.
     */
    @Override
    public void run() {
        launch();
    }

    /**
     * Is called from the launch() call. Initialize the view.
     * @param stage the main stage
     */
    @Override
    public void start(Stage stage) {
        this.mainStage = stage;
        initTestScene();
        initMainStage(testScene);
        mainStage.show();
    }

    private void initMainStage(Scene scene) {
        mainStage.setTitle(WINDOW_TITLE);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
    }

    // TODO
    private void initTestScene() {
                    Label label = new Label();

                Pane imagePane = new Pane(label);
                imagePane.setPrefSize(256, 256);

                    TextArea deckList = new TextArea();

                    Button loadButton = new Button("load");
                    loadButton.setOnAction(event -> loadButtonPressed(deckList, label));

                VBox deckArea = new VBox(deckList, loadButton);
                deckArea.setAlignment(Pos.CENTER);
                deckArea.setSpacing(SPACING);
                deckArea.setPrefSize(128, 256);

            HBox content = new HBox(imagePane, deckArea);
            content.setAlignment(Pos.CENTER);
            content.setSpacing(SPACING);
            content.setPadding(PADDING);

        testScene = new Scene(content);
    }

    private void loadButtonPressed(TextArea deckList, Label label) {
        ArrayList<String> cardNames = TextParser.parseDeckList(deckList.getText());
        if (cardNames.isEmpty()) return;
        label.setText(cardNames.get(0));
    }

}