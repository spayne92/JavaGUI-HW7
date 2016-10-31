// Scott F. Payne

package code;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.*;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FanDemo extends Application
{
	BorderPane mainPane;
	GridPane fansPane;
	HBox hb_top;

	Scene mainScene;

	Button authorButton, problemButton, mainButton;

	double x1, y1, w1, h1;
	double x2, y2, w2, h2;

  @Override
  public void start(Stage mainStage)
	{
		// sets title for open window
    mainStage.setTitle("Glorious Fans");

		// creates grid pane to hold fans
		fansPane = new GridPane();

		// creates pane to hold buttons at top of window
		hb_top = new HBox();
		hb_top.setStyle("-fx-background-color: LIGHTGREY;");
		hb_top.setSpacing(6);
		hb_top.setPadding(new Insets(5, 10, 5, 10));

		// creates individual buttons for navigation
		mainButton = new Button("Main");
		mainButton.setStyle("-fx-text-fill: BLACK;");

		authorButton = new Button("Author");
		authorButton.setStyle("-fx-text-fill: BLACK;");

		problemButton = new Button("Problem");
		problemButton.setStyle("-fx-text-fill: BLACK;");

		// adds navigation buttons to top of window
		hb_top.getChildren().addAll(mainButton, authorButton, problemButton);

		// creates main pane and places above declared panes inside of it
		mainPane = new BorderPane();
		mainPane.setCenter(fansPane);
		mainPane.setLeft(null);
		mainPane.setTop(hb_top);
		mainPane.setBottom(null);

		// creates scene and defines width/height
		mainScene = new Scene(mainPane, 600, 400);

		// sets scene and makes it visible
		mainStage.setScene(mainScene);
    mainStage.show();

		/** Clears window and displays author info when authorButton pressed */
		authorButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				// pane to display information about the author
				VBox vb_author = new VBox(5);
				vb_author.setPadding(new Insets(10,0,0,20));

				// Creating text boxes with info about author
				Text author_text_1 = new Text(10, 40,
					"  Name: 		 Scott Payne");
				author_text_1.setFont(new Font(14));
				author_text_1.setFill(Color.BLACK);
				author_text_1.setWrappingWidth(600);
				author_text_1.setTextAlignment(TextAlignment.JUSTIFY);

				Text author_text_2 = new Text(10, 40,
					"  Email:		 sfpr43@mst.edu");
				author_text_2.setFont(new Font(14));
				author_text_2.setFill(Color.BLACK);
				author_text_2.setWrappingWidth(600);
				author_text_2.setTextAlignment(TextAlignment.JUSTIFY);

				Text author_text_3 = new Text(10, 40,
					"  Height: 		6'2\"");
				author_text_2.setFont(new Font(14));
				author_text_2.setFill(Color.BLACK);
				author_text_2.setWrappingWidth(600);
				author_text_2.setTextAlignment(TextAlignment.JUSTIFY);

				Text author_text_4 = new Text(10, 40,
				"  Comment: 	This is pointless.");
				author_text_2.setFont(new Font(14));
				author_text_2.setFill(Color.BLACK);
				author_text_2.setWrappingWidth(600);
				author_text_2.setTextAlignment(TextAlignment.JUSTIFY);


				vb_author.getChildren().addAll(author_text_1, author_text_2,
																			 author_text_3, author_text_4);
				mainPane.setCenter(vb_author);
				mainPane.setLeft(null);
				mainPane.setBottom(null);
			}
		});

		/** Clears window and displays problem info when problemButton pressed */
		problemButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				// pane to display information about the problem
				VBox vb_problem = new VBox(5);
				vb_problem.setPadding(new Insets(10, 0, 0, 20));

				// Creating text boxes describing problem
				Text problem_text_1 = new Text(10, 40,
          "  14.9: Create four fans:");
				problem_text_1.setFont(new Font(14));
        problem_text_1.setFill(Color.BLACK);
        problem_text_1.setWrappingWidth(600);
        problem_text_1.setTextAlignment(TextAlignment.JUSTIFY);

				Text problem_text_2 = new Text(10, 40,
					"  	Write a program that places four fans in a GridPane with two rows and two columns");
				problem_text_2.setFont(new Font(14));
        problem_text_2.setFill(Color.BLACK);
        problem_text_2.setWrappingWidth(600);
        problem_text_2.setTextAlignment(TextAlignment.JUSTIFY);

				Image solution_img = new Image("source/solution_img.jpg");
				ImageView solution_view = new ImageView(solution_img);

				vb_problem.getChildren().addAll(problem_text_1, problem_text_2, solution_view);
				mainPane.setCenter(vb_problem);
				mainPane.setLeft(null);
				mainPane.setBottom(null);
			}
		});

		/** Redisplays main program for fans display when mainButton pressed */
		mainButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				mainPane.setCenter(fansPane);
				mainPane.setLeft(null);
				mainPane.setBottom(null);
			}
		});
	}

	/** Triangle creation method */
	public Polygon createTriangle(double x, double y, double w, double h)
	{
	  Polygon t = new Polygon(x, y, (x+w), y, (x+(w/2)), (y+h));
		t.setFill(Color.GREEN);
		//t.setFill(null);
		t.setStrokeWidth(3);
	  return t;
  }

	/** Main method */
  public static void main(String[] args)
	{
    launch(args);
  }
}
