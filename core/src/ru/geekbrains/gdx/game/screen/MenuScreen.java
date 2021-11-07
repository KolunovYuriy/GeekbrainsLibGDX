package ru.geekbrains.gdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.gdx.game.base.BaseScreen;
import ru.geekbrains.gdx.game.math.Rect;
import ru.geekbrains.gdx.game.sprite.Background;
import ru.geekbrains.gdx.game.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture img;
    private Vector2 pos;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);

        img = new Texture("badlogic.jpg");
        logo = new Logo(img, 0.1f, 0.1f);
        pos = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        //batch.draw(img, pos.x, pos.y, 0.5f, 0.5f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        //pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }

}
