package ru.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.BaseScreen;
import ru.game.math.Rect;
import ru.game.sprite.Background;
import ru.game.sprite.Logotype;

public class MenuScreen extends BaseScreen {
    private Texture bg;
    private Texture logo;
    private Vector2 pos;
    private Background background;
    private Logotype logotype;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        logo = new Texture("badlogic.jpg");
        pos = new Vector2();
        batch.getProjectionMatrix().idt();
        background = new Background(bg);
        logotype = new Logotype(logo);

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logotype.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logotype.draw(batch);
        batch.end();
        logotype.moveLogo();

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        logo.dispose();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        logotype.touchDown(touch, pointer, button);
        return false;
    }


}
