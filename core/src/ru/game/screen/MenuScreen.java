package ru.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Vector2 pos; //позиция текстуры
    private Vector2 purpose; //позиция курсора мыши
    private Vector2 v; //скорость
    private final int ACCELERATION = 5; //ускорение

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        purpose = new Vector2();
        v = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();

        if ((pos.x != purpose.x && pos.y != purpose.y)) {
            if ((Math.sqrt((pos.x - purpose.x) * (pos.x - purpose.x) + (pos.y - purpose.y) * (pos.y - purpose.y)) - v.len()) > 0.1) {
                pos.add(v);
            } else {
                pos.set(purpose);
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        purpose.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(purpose.x - pos.x, purpose.y - pos.y);
        v.nor();
        v.scl(ACCELERATION);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
