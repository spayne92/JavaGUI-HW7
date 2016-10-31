// Scott F. Payne

package code;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

/** Extension of Pane to streamline creation of panes with fans in them */
public class FanPane extends Pane
{
  private double width, height, radius;
  private Arc arcs[] = new Arc[8];
  private double initAngle = 40;
  private Circle outerCircle, innerCircle;

  /** Constructor for FanPane. Builds a fan based on w/h parameters */
  public FanPane(double w, double h)
  {
    this.width = w;
    this.height = h;
    this.radius = Math.min(width, height) * 0.45;

    // building outer circle of fan that contains blades
    outerCircle = new Circle(width/2, height/2, radius);
    outerCircle.setStroke(Color.BLACK);
    outerCircle.setStrokeWidth(10);
    outerCircle.setFill(Color.LIGHTGREY);
    getChildren().add(this.outerCircle);

    // adding 'blades' as arcs to inside of the outer circle
    for(int i = 0; i < 8; i++)
    {
      arcs[i] = new Arc(width/2, height/2, radius * 0.9, radius * 0.9,
                        initAngle + i*45, 25.0);
      arcs[i].setFill(Color.RED);
      arcs[i].setType(ArcType.ROUND);
      getChildren().add(arcs[i]);
    }

    // adding inner circle to appear as fulcrum for blades in fan
    innerCircle = new Circle(width/2, height/2, radius/8);
    innerCircle.setStroke(Color.BLACK);
    innerCircle.setStrokeWidth(5);
    innerCircle.setFill(Color.LIGHTGREY);
    getChildren().add(this.innerCircle);
  }
}
