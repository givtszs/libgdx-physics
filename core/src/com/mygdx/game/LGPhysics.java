package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class LGPhysics extends ApplicationAdapter {

	Sprite banana;
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	OrthographicCamera camera;
	ExtendViewport viewport;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(800, 600, camera);
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("sprites.txt");
		banana = textureAtlas.createSprite("banana");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.57f, 0.77f, 0.85f, 1);
		batch.begin();
		banana.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
		batch.setProjectionMatrix(camera.combined);
	}
}
