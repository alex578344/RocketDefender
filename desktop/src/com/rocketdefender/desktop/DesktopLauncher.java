package com.rocketdefender.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rocketdefender.StartingPoint.RocketDefender;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Rocket Defender";
        config.width = 408;
        config.height = 272;
		new LwjglApplication(new RocketDefender(), config);
	}
}
