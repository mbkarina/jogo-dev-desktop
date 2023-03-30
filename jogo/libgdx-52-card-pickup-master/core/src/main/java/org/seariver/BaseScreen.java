package org.seariver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.seariver.screen.LevelScreen;

public abstract class BaseScreen implements Screen, InputProcessor {

    protected Stage mainStage;
    protected Stage uiStage;
    protected Table uiTable;
    protected long time;
    protected SpriteBatch batch;
    protected BitmapFont font;
    protected String text;
    Label l;
    protected final int MAXTEMPO;
    Label messageLabel;
    public static float tempoRestante;

    public BaseScreen(int MAXTEMPO) {
        mainStage = new Stage();
        uiStage = new Stage();

        uiTable = new Table();
        uiTable.setFillParent(true);
        uiStage.addActor(uiTable);

        this.MAXTEMPO = MAXTEMPO;

        font = new BitmapFont();
        batch = new SpriteBatch();
        text = String.valueOf(MAXTEMPO);
        this.time = System.currentTimeMillis();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.BLACK;
        l = new Label("", labelStyle);

        uiTable.bottom().left().add(l);

        initialize();
    }

    public abstract void initialize();

    public abstract void update(float deltaTime);

    public abstract void grafico(float tempoRestante);


    public void render(float deltaTime) {
        deltaTime = Math.min(deltaTime, 1 / 30f);

        uiStage.act(deltaTime);
        mainStage.act(deltaTime);

        update(deltaTime);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.renderTempo();

        if ((MAXTEMPO - (System.currentTimeMillis() - this.time) / 1000) >= 0) {

            this.text = String.valueOf(MAXTEMPO - (System.currentTimeMillis() - this.time) / 1000);
            tempoRestante = (MAXTEMPO - (System.currentTimeMillis() - tempoRestante) / 1000);

        }

        mainStage.draw();
        uiStage.draw();
    }

    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }

    public void show() {
        InputMultiplexer inputProcessor = (InputMultiplexer) Gdx.input.getInputProcessor();
        inputProcessor.addProcessor(this);
        inputProcessor.addProcessor(uiStage);
        inputProcessor.addProcessor(mainStage);
    }

    public void hide() {
        InputMultiplexer inputProcessor = (InputMultiplexer) Gdx.input.getInputProcessor();
        inputProcessor.removeProcessor(this);
        inputProcessor.removeProcessor(uiStage);
        inputProcessor.removeProcessor(mainStage);
    }

    public boolean isTouchDownEvent(Event event) {
        return (event instanceof InputEvent) && ((InputEvent) event).getType().equals(Type.touchDown);
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public void renderTempo() {
        this.font.getData().setScale(5.0F);
        this.font.setColor(Color.WHITE);
        l.setText(text);
    }


}
