package org.seariver.screen;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import org.seariver.BaseScreen;

import static org.seariver.screen.LevelScreen.tempofacil;
import static org.seariver.screen.LevelScreenDificil.tempodificil;
import static org.seariver.screen.LevelScreenMedio.tempomedio;

public class grafico extends BaseScreen {

    private static final double GRAFICO_LARGURA = 5;
    private static final double GRAFICO_ALTURA = 10;

    public grafico() {
        super(0);
        BarChart pontosTempo = new BarChart<>(
                new CategoryAxis(), new NumberAxis());
        pontosTempo.getData().addAll(tempofacil, tempomedio, tempodificil);
        pontosTempo.setPrefSize(GRAFICO_LARGURA, GRAFICO_ALTURA);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void grafico(float tempoRestante) {

    }
}
