package fr.amu.iut.cc3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;

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
    @FXML
    Label log;
    Circle c1 = new Circle(0,0,0);
    Circle c2 = new Circle(0,0,0);
    Circle c3 = new Circle(0,0,0);
    Circle c4 = new Circle(0,0,0);
    Circle c5 = new Circle(0,0,0);
    Circle c6 = new Circle(0,0,0);
    int[] pc1 = new int[2];
    int[] pc2 = new int[2];
    int[] pc3 = new int[2];
    int[] pc4 = new int[2];
    int[] pc5 = new int[2];
    int[] pc6 = new int[2];

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
                *  (value / noteMaximale))+20;
    }
    @FXML
    public void tracer(){
        if (comp1.getText().isEmpty() ||
           comp2.getText().isEmpty() ||
           comp3.getText().isEmpty() ||
           comp4.getText().isEmpty() ||
           comp5.getText().isEmpty() ||
           comp6.getText().isEmpty() ){
                log.setText("Erreur de saisie :\nsaisissez toute les notes");
        }
        else if (Integer.parseInt(comp1.getText()) > 20 ||
                Integer.parseInt(comp2.getText()) > 20 ||
                Integer.parseInt(comp3.getText()) > 20 ||
                Integer.parseInt(comp4.getText()) > 20 ||
                Integer.parseInt(comp5.getText()) > 20 ||
                Integer.parseInt(comp6.getText()) > 20) {
            log.setText("Erreur de saisie :\nne pas dépasser 20 dans la note");
            vider();;
        }
        else {
            vider();
            log.setText("");
            Polyline ligne = new Polyline();
            c1.setCenterX(getXRadarChart(Integer.parseInt(comp1.getText()), 1));
            c1.setCenterY(getYRadarChart(Integer.parseInt(comp1.getText()), 1));
            c1.setRadius(5);
            pc1[0] = getXRadarChart(Integer.parseInt(comp1.getText()),1);
            pc1[1] = getYRadarChart(Integer.parseInt(comp1.getText()),1);
            c2.setCenterX(getXRadarChart(Integer.parseInt(comp2.getText()), 2));
            c2.setCenterY(getYRadarChart(Integer.parseInt(comp2.getText()), 2));
            c2.setRadius(5);
            pc2[0] = getXRadarChart(Integer.parseInt(comp2.getText()),2);
            pc2[1] = getYRadarChart(Integer.parseInt(comp2.getText()),2);
            c3.setCenterX(getXRadarChart(Integer.parseInt(comp3.getText()), 3));
            c3.setCenterY(getYRadarChart(Integer.parseInt(comp3.getText()), 3));
            c3.setRadius(5);
            pc3[0] = getXRadarChart(Integer.parseInt(comp3.getText()),3);
            pc3[1] = getYRadarChart(Integer.parseInt(comp3.getText()),3);
            c4.setCenterX(getXRadarChart(Integer.parseInt(comp4.getText()), 4));
            c4.setCenterY(getYRadarChart(Integer.parseInt(comp4.getText()), 4));
            c4.setRadius(5);
            pc4[0] = getXRadarChart(Integer.parseInt(comp4.getText()),4);
            pc4[1] = getYRadarChart(Integer.parseInt(comp4.getText()),4);
            c5.setCenterX(getXRadarChart(Integer.parseInt(comp5.getText()), 5));
            c5.setCenterY(getYRadarChart(Integer.parseInt(comp5.getText()), 5));
            c5.setRadius(5);
            pc5[0] = getXRadarChart(Integer.parseInt(comp5.getText()),5);
            pc5[1] = getYRadarChart(Integer.parseInt(comp5.getText()),5);
            c6.setCenterX(getXRadarChart(Integer.parseInt(comp6.getText()), 6));
            c6.setCenterY(getYRadarChart(Integer.parseInt(comp6.getText()), 6));
            c6.setRadius(5);
            pc6[0] = getXRadarChart(Integer.parseInt(comp6.getText()),6);
            pc6[1] = getYRadarChart(Integer.parseInt(comp6.getText()),6);

            ligne.getPoints().addAll(
                    (double) pc1[0], (double) pc1[1],
                    (double) pc2[0], (double) pc2[1],
                    (double) pc3[0], (double) pc3[1],
                    (double) pc4[0], (double) pc4[1],
                    (double) pc5[0], (double) pc5[1],
                    (double) pc6[0], (double) pc6[1],
                    (double) pc1[0], (double) pc1[1]);

            toile.getChildren().addAll(c1, c2, c3, c4, c5, c6,ligne);
        }
    }

    @FXML
    public void vider(){
        toile.getChildren().clear();
    }

}
