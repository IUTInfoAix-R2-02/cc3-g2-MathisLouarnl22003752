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
    Pane toile;

    Circle c1 = new Circle();
    Circle c2 = new Circle();
    Circle c3 = new Circle();
    Circle c4 = new Circle();
    Circle c5 = new Circle();
    Circle c6 = new Circle();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        toile.getChildren().addAll(c1,c2,c3,c4,c5,c6);
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
        vider();
        c1.setCenterX(getXRadarChart(Integer.parseInt(comp2.getText()),1));
        c1.setCenterY(getYRadarChart(Integer.parseInt(comp2.getText()),1));
        c1.setRadius(5);
        c2.setCenterX(getXRadarChart(Integer.parseInt(comp2.getText()),2));
        c2.setCenterY(getYRadarChart(Integer.parseInt(comp2.getText()),2));
        c2.setRadius(5);
        c3.setCenterX(getXRadarChart(Integer.parseInt(comp3.getText()),3));
        c3.setCenterY(getYRadarChart(Integer.parseInt(comp3.getText()),3));
        c3.setRadius(5);
        c4.setCenterX(getXRadarChart(Integer.parseInt(comp4.getText()),4));
        c4.setCenterY(getYRadarChart(Integer.parseInt(comp4.getText()),4));
        c4.setRadius(5);
        c5.setCenterX(getXRadarChart(Integer.parseInt(comp5.getText()),5));
        c5.setCenterY(getYRadarChart(Integer.parseInt(comp5.getText()),5));
        c5.setRadius(5);
        c6.setCenterX(getXRadarChart(Integer.parseInt(comp6.getText()),6));
        c6.setCenterY(getYRadarChart(Integer.parseInt(comp6.getText()),6));
        c6.setRadius(5);

        toile.getChildren().addAll(c1,c2,c3,c4,c5,c6);
    }

    @FXML
    public void vider(){
        toile.getChildren().clear();
    }

}
