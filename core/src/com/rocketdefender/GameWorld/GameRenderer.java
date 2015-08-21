package com.rocketdefender.GameWorld;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rocketdefender.Helpers.AssetLoader;
import com.rocketdefender.Helpers.InputHandler;

import java.util.Iterator;

/**
 * Created by Sensational on 8/14/2015.
 */
public class GameRenderer{

    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Vector3 vector3;
    private Viewport v;

    private Array<Rectangle> rockets;
    private long lastDropTime = 0;

    private float tap_X = 0;
    private float tap_Y = 0;

    private int GHeight;
    private int GWidth;



    public GameRenderer() {
        GHeight = Gdx.graphics.getHeight();
        GWidth = Gdx.graphics.getWidth();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 408, 272 );
        v = new FitViewport(408, 272, cam);

        batch = new SpriteBatch();

        rockets = new Array<Rectangle>();
        spawnRocket();
}


    public void render(float runTime){

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();

        batch.setProjectionMatrix(cam.combined);

        batch.begin();
        //BATCH START


        batch.draw(AssetLoader.background, 0, 0 , GWidth,GHeight);

        for(Rectangle rocket : rockets) {
            batch.draw(AssetLoader.rocket ,rocket.x, rocket.y,
                    rocket.width, rocket.height);
        }

        if (Gdx.input.justTouched()){

            Vector3 v = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            v = cam.unproject(v);

            tap_X = (int) v.x;
            tap_Y = (int) v.y;

            Gdx.app.log("MyTag", String.valueOf(tap_X));
            Gdx.app.log("MyTag", String.valueOf(tap_Y));



        }

        Iterator<Rectangle> iter = rockets.iterator();
        while(iter.hasNext()) {

            Rectangle rocket = iter.next();
            rocket.y -= 140 * Gdx.graphics.getDeltaTime();
            if(rocket.y + 32 < 0) iter.remove();

            if (rocket.x - 5 < tap_X && tap_X < rocket.x + rocket.width + 5) {

                if (tap_Y > rocket.y - 5 && tap_Y < rocket.y + rocket.height + 5) {
                    batch.draw(AssetLoader.explosionA.getKeyFrame(1, false), rocket.x, rocket.y,
                            rocket.width, rocket.height);
                    iter.remove();
                }
            }
        }

        //BATCH END
        batch.end();


        if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRocket();

    }



    private void spawnRocket() {
        Gdx.app.log("MyTag", "Rocket Spawned");
        Rectangle rocket = new Rectangle();
        rocket.x = MathUtils.random(0 , 272 - 16);
        rocket.y = 408 + rocket.height;
        rocket.height = 32;
        rocket.width = 16;
        rockets.add(rocket);
        lastDropTime = TimeUtils.nanoTime();
    }



}
