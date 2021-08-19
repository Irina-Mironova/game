package ru.game.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.game.base.Sprite;
import ru.game.math.Rect;

public class GameOverMessage extends Sprite {

    private static final float HEIGHT_GAMEOVER = 0.08f;
    private static final float PADDING = 0.3f;

    public GameOverMessage(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
        setHeightProportion(HEIGHT_GAMEOVER);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT_GAMEOVER);
        setTop(worldBounds.getTop() - PADDING);
    }
}
