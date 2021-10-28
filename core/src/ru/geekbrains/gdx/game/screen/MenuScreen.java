package ru.geekbrains.gdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.gdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 imgPosition, touch, v;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        imgPosition = new Vector2(0,0);
        touch = new Vector2();
        v = new Vector2(0, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, imgPosition.x, imgPosition.y);
        batch.end();
        if (imgPosition.dst(touch) > v.len()) imgPosition.add(v);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(imgPosition)).setLength(1);
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
