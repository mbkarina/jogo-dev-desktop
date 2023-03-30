package org.seariver.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Botao {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private float x, y, width, height, r, g, b, realR, realG, realB, scaleRGB, widthL, heightL;
    private BitmapFont font;
    private String text;
    private GlyphLayout layout;


    public Botao(float x, float y, float width, float height, float r, float g, float b, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        scaleRGB = 0.5f;
        this.text = text;
        layout = new GlyphLayout();
        layout.setText(font, text);
        widthL = layout.width*1.5f;
        heightL = layout.height*1.5f;
    }

    public void hover() {
        if (Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY()) > y && (Gdx.graphics.getHeight() - Gdx.input.getY()) < y + height) {
            realR = r * scaleRGB;
            realG = g * scaleRGB;
            realB = b * scaleRGB;
        } else {
            realR = r / scaleRGB;
            realG = g / scaleRGB;
            realB = b / scaleRGB;
        }
    }

    public boolean clicou() {
        return (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY()) > y && (Gdx.graphics.getHeight() - Gdx.input.getY()) < y + height);
    }

    public void update() {
        hover();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(realR, realG, realB, 1);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, text, (x + width/2)-widthL/2, (y + height/2)+heightL/2);
        batch.end();
    }

}