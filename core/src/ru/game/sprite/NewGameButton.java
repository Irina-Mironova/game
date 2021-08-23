package ru.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.BaseButton;
import ru.game.math.Rect;
import ru.game.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private static final float HEIGHT_NEWGAME_BUTTON = 0.05f;
    private static final float PADDING = 0.5f;

    private final GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        setHeightProportion(HEIGHT_NEWGAME_BUTTON);
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT_NEWGAME_BUTTON);
        setTop(worldBounds.getTop() - PADDING);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }
}
