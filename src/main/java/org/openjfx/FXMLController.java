package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {
    
    @FXML
    private TableView<Kohde> asunto;
    
    @FXML
    private TableColumn<Kohde, String> nimi, osoite, vuosi, vuokra;

    @FXML
    private TextField searchBox;

    ObservableList<Kohde> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        masterData.add(new Kohde("Kerrostalo1", "Kotitie 1, 01000", "2000", "1000"));
        masterData.add(new Kohde("Kerrostalo2", "Kotitie 2, 01000", "2001", "1100"));
        masterData.add(new Kohde("Omakotitalo3", "Kylätie 3, 01000", "2002", "2200"));
        masterData.add(new Kohde("Omakotitalo34", "Kylätie 4, 01000", "2003", "2250"));

        asunto.setItems(masterData);
        nimi.setCellValueFactory(new PropertyValueFactory<>("nimi"));
        osoite.setCellValueFactory(new PropertyValueFactory<>("osoite"));
        vuosi.setCellValueFactory(new PropertyValueFactory<>("vuosi"));
        vuokra.setCellValueFactory(new PropertyValueFactory<>("vuokra"));

        for (int i = 0; i < asunto.getItems().size(); i++) {
            System.out.println("Asunto" + asunto.getItems().get(i).getNimi());
        }
    }

    @FXML
    public void searchRecord(javafx.scene.input.KeyEvent keyEvent) {
            FilteredList<Kohde> filterData = new FilteredList<>(masterData, p -> true);
            searchBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
                filterData.setPredicate(asun -> {

                    if (newvalue == null || newvalue.isEmpty()) {
                        return true;
                    }
                    String typedText = newvalue.toLowerCase();
                    return asun.getNimi().toLowerCase().indexOf(typedText) != -1;

                });
                SortedList<Kohde> sortedList = new SortedList<>(filterData);
                sortedList.comparatorProperty().bind(asunto.comparatorProperty());
                asunto.setItems(sortedList);
            });
    }

    @FXML
    public void searchRecord2(javafx.scene.input.KeyEvent keyEvent) {
        FilteredList<Kohde> filterData = new FilteredList<>(masterData, p -> true);
        searchBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            filterData.setPredicate(asun -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedText = newvalue.toLowerCase();
                return asun.getOsoite().toLowerCase().indexOf(typedText) != -1;

            });
            SortedList<Kohde> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(asunto.comparatorProperty());
            asunto.setItems(sortedList);
        });
    }
}
