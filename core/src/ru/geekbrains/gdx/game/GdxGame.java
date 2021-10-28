package ru.geekbrains.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class GdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, backfroundSpace;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		backfroundSpace = new Texture(Gdx.files.internal("space.jpg"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		TextureRegion t = ScreenUtils.getFrameBufferTexture();
		batch.begin();
		batch.draw(backfroundSpace,0, 0, t.getRegionWidth(), t.getRegionHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		backfroundSpace.dispose();
	}
}
