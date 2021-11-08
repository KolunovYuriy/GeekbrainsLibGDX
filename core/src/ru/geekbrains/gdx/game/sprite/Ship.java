package ru.geekbrains.gdx.game.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.gdx.game.base.Sprite;
import ru.geekbrains.gdx.game.math.Rect;
import ru.geekbrains.gdx.game.math.Rnd;

public class Ship extends Sprite {

    private final float height = 0.1f;
    private final float width = 0.1f;
    private final float V_LEN = 0.1f;

    private Vector2 velocity;
    private boolean isLeftButtonPressed = false;
    private boolean isRightButtonPressed = false;

    public Ship(TextureRegion region) {
        super(region.split(region.getRegionWidth()/2, region.getRegionHeight())[0][0]);
        velocity = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(height);
        setBottom(worldBounds.getBottom());
        frame = 0;
    }

    public void keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                isLeftButtonPressed = true;
                isRightButtonPressed = false;
                velocity.set(new Vector2(- V_LEN, 0));
                break;
            case Input.Keys.RIGHT:
                isLeftButtonPressed = false;
                isRightButtonPressed = true;
                velocity.set(new Vector2(V_LEN, 0));
                break;
            default:
                break;
        }
    }

    public void keyUp(int keycode) {
        isLeftButtonPressed = false;
        isRightButtonPressed = false;
        velocity.setZero();
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(velocity, delta);
    }

}
