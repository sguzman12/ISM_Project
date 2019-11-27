package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * GUI interface for JavaFX. UnderDevelopment.
 * 
 * @author Sigfredo Guzman
 *
 */
public class FX_Gui
{

	public FX_Gui() throws Exception
	{

	}

	/**
	 * Build GUI
	 */
	public void initialize()
	{
		buildStage(HEIGHT, WIDTH);
		buildLabel();
		buildScene(sceneHeight, sceneWidth);

		stage.setScene(scene);

		stage.show();

	}

	/**
	 * Build Stage
	 */
	private void buildStage(double height, double width)
	{
		stage = new Stage();
		stage.setTitle("My First JavaFX App");
		stage.setHeight(height);
		stage.setWidth(width);

	}

	/**
	 * Build Scene
	 * 
	 * @param height
	 * @param width
	 */
	private void buildScene(double height, double width)
	{
		scene = new Scene(label);
	}

	private void buildLabel()
	{
		label = new Label("Hello World, JavaFX !");
	}

	private void buildButton()
	{

	}

	private double HEIGHT = 600;
	private double WIDTH = 500;
	private double sceneHeight = 400;
	private double sceneWidth = 200;

	private Stage stage;
	private Scene scene;
	private Label label;
}
