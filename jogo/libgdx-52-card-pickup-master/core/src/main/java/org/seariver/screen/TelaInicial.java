package org.seariver.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import org.seariver.BaseScreen;
import org.seariver.CardPickupGame;

import java.io.FileNotFoundException;

public class TelaInicial extends BaseScreen implements Screen {
    Texture fundo;
    SpriteBatch batch;
    Botao botaoFacil, botaoMedio, botaoDificil;
    CardPickupGame coiso;

    public TelaInicial(CardPickupGame coiso) {
        super(60);
        fundo = new Texture(Gdx.files.internal("ABCPAULISTA.png"));
        batch = new SpriteBatch();
        botaoFacil = new Botao((Gdx.graphics.getWidth() - 288) / 2, (Gdx.graphics.getHeight() - 100) / 2, 100, 50, 214/255f, 68/255f, 179/255f, "Fácil");
        botaoMedio = new Botao((Gdx.graphics.getWidth() - 288) / 2, (Gdx.graphics.getHeight() - 200) / 2, 100, 50, 214/255f, 68/255f, 179/255f, "Médio");
        botaoDificil = new Botao((Gdx.graphics.getWidth() - 288) / 2, (Gdx.graphics.getHeight() - 300) / 2, 100, 50, 214/255f, 68/255f, 179/255f, "Difícil");
        this.coiso = coiso;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void show() {

    }

    public void update(float delta) {
    }

    @Override
    public void grafico(float tempoRestante) {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(fundo, 0, 0);
        batch.end();
        botaoFacil.update();
        botaoMedio.update();
        botaoDificil.update();
        if (botaoFacil.clicou()) {
            coiso.setScreen(new LevelScreen(60));
        }
        if (botaoMedio.clicou()) {
            coiso.setScreen(new LevelScreenMedio(40));
        }
        if (botaoDificil.clicou()) {
            coiso.setScreen(new LevelScreenDificil(20));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        fundo.dispose();
    }
}
