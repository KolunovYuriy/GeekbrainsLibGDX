package ru.geekbrains.gdx.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.gdx.game.base.Sprite;

public class Logo extends Sprite {

    private final float V_LEN = 0.01f;
    private Vector2 v;
    private Vector2 direct;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        v = new Vector2();
        direct = new Vector2();
    }


    public Logo(Texture texture, float width, float height) {
        this(texture);
        setWidth(width);
        setHeight(height);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        direct.set(touch.cpy());
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return true;
    }

    @Override
    public void draw(SpriteBatch batch) {
        if (pos.dst(direct) <= v.len()) {
            pos.set(direct);
        } else pos.add(v);
        super.draw(batch);
    }
}
