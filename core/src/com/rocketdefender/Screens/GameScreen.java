package com.rocketdefender.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.rocketdefender.GameWorld.GameRenderer;
import com.rocketdefender.Helpers.InputHandler;

/**
 * Created by Sensational on 8/11/2015.
 */
public class GameScreen implements Screen {

    private GameRenderer gRender;
    private float runTime = 0;

    public GameScreen(){

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        gRender = new GameRenderer();

        Gdx.input.setInputProcessor(new InputHandler());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gRender.render(runTime);
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

    }
}
