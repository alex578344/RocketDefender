package com.rocketdefender.Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * Created by Sensational on 8/14/2015.
 */
public class AssetLoader {

    public static Texture rocket, background, explosion;

    public static Animation explosionA;
    public static TextureRegion ex1,ex2,ex3;
    public static TextureAtlas textureAtlas;

    public static void load(){
        rocket = new Texture(Gdx.files.internal("rocket.png"));
        background = new Texture(Gdx.files.internal("background.png"));


        textureAtlas = new TextureAtlas(Gdx.files.internal("ExplosionAnimation.atlas"));
        explosionA = new Animation(10f, textureAtlas.getRegions());


    }

    public static void dispose(){
        rocket.dispose();
        background.dispose();
    }
}
