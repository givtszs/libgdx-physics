package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

public class LGPhysics extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	OrthographicCamera camera;
	ExtendViewport viewport;
	final HashMap<String, Sprite> sprites = new HashMap<>();
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(800, 600, camera);
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("sprites.txt");
		loadSprites();
	}

	private void loadSprites() {
		for (TextureAtlas.AtlasRegion region: textureAtlas.getRegions()) {
			sprites.put(region.name, textureAtlas.createSprite(region.name));
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.57f, 0.77f, 0.85f, 1);
		batch.begin();
		drawSprite(sprites.get("banana"), 0, 0);
		drawSprite(sprites.get("banana"), 130, 0);
		drawSprite(sprites.get("cherries"), 0, 130);
		batch.end();
	}

	private void drawSprite(Sprite sprite, float x, float y) {
		sprite.setPosition(x, y);
		sprite.draw(batch);
	}

	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
		sprites.clear();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
		batch.setProjectionMatrix(camera.combined);
	}
}
