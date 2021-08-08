package ru.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.Sprite;
import ru.game.math.Rect;

public class Ship extends Sprite {
    private static final float V_LEN = 0.005f;

    private Vector2 v;
    private Rect worldBounds;

    public Ship(TextureRegion region) {
        super(region);
        this.v = new Vector2();
    }

    @Override
    public void update(float delta) {
        if (getRight() < worldBounds.getRight() && v.x > 0) {
            pos.add(v);
        }
        if (getLeft() > worldBounds.getLeft() && v.x < 0) {
            pos.add(v);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        pos.set(0, 0);
        setBottom(worldBounds.getBottom());
        this.worldBounds = worldBounds;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (touch.x >= 0) {
            v.set(V_LEN, 0);
        } else {
            if (touch.x < 0)
                v.set(-V_LEN, 0);
        }
        return false;
    }


    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        v.set(0, 0);
        return false;
    }


    public boolean keyDown(int keycode) {
        if (keycode == 22) {
            v.set(V_LEN, 0);
        }
        if ((keycode == 21)) {
            v.set(-V_LEN, 0);
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == 22 || keycode == 21) {
            v.set(0, 0);
        }
        return false;
    }
}

