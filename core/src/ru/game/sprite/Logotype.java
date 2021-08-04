package ru.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.Sprite;
import ru.game.math.Rect;

public class Logotype extends Sprite {
    private Vector2 v;
    private Vector2 purpose;
    private Vector2 tmp;
    private static final float V_LEN = 0.01f;


    public Logotype(Texture texture) {
        super(new TextureRegion(texture));
        v = new Vector2();
        purpose = new Vector2();
        tmp = new Vector2();

    }

    public void moveLogo() {
        tmp.set(purpose);
        if (tmp.sub(pos).len() > V_LEN) {
            pos.add(v);
        } else {
            pos.set(purpose);
        }
    }


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() / 5);
        pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        super.touchDown(touch, pointer, button);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        purpose.set(touch);
        return false;
    }
}

