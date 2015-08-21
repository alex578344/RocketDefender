package com.rocketdefender.StartingPoint;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rocketdefender.Helpers.AssetLoader;
import com.rocketdefender.Screens.GameScreen;

public class RocketDefender extends Game {

    float delta;
    GameScreen gameScreen;

	@Override
	public void create () {
        AssetLoader.load();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
