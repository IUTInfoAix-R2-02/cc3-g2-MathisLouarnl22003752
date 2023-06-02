package fr.amu.iut.cc3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    TextField comp1;
    @FXML
    TextField comp2;
    @FXML
    TextField comp3;
    @FXML
    TextField comp4;
    @FXML
    TextField comp5;
    @FXML
    TextField comp6;
    @FXML
    Button boutonTracer;
    @FXML
    Button boutonVider;
    @FXML
    Pane graph;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }
    @FXML
    public void tracer(){
        Circle c1 = new Circle(getXRadarChart(Integer.parseInt(comp1.getText()),1),getYRadarChart(Integer.parseInt(comp1.getText()),1), 5);
        Circle c2 = new Circle(getXRadarChart(Integer.parseInt(comp2.getText()),2),getYRadarChart(Integer.parseInt(comp2.getText()),2), 5);
        Circle c3 = new Circle(getXRadarChart(Integer.parseInt(comp3.getText()),3),getYRadarChart(Integer.parseInt(comp3.getText()),3), 5);
        Circle c4 = new Circle(getXRadarChart(Integer.parseInt(comp4.getText()),4),getYRadarChart(Integer.parseInt(comp4.getText()),4), 5);
        Circle c5 = new Circle(getXRadarChart(Integer.parseInt(comp5.getText()),5),getYRadarChart(Integer.parseInt(comp5.getText()),5), 5);
        Circle c6 = new Circle(getXRadarChart(Integer.parseInt(comp6.getText()),5),getYRadarChart(Integer.parseInt(comp6.getText()),6), 5);
        graph.getChildren().addAll(c1,c2,c3,c4,c5,c6);
    }

    @FXML
    public void vider(){
        graph.getChildren().clear();
    }

}
