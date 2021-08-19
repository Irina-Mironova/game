package ru.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.game.base.BaseButton;
import ru.game.base.Sprite;
import ru.game.math.Rect;
import ru.game.poll.BulletPool;
import ru.game.poll.EnemyPool;
import ru.game.poll.ExplosionPool;
import ru.game.utils.EnemyEmitter;

public class NewGameButton extends BaseButton {

    private static final float HEIGHT_NEWGAME_BUTTON = 0.06f;
    private static final float PADDING = 0.5f;


    private MainShip mainShip;
    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private EnemyPool enemyPool;
    private EnemyEmitter enemyEmitter;


    public NewGameButton(TextureAtlas atlas, MainShip mainShip, BulletPool bulletPool, ExplosionPool explosionPool, EnemyPool enemyPool, EnemyEmitter enemyEmitter ) {
        super(atlas.findRegion("button_new_game"));
        this.mainShip = mainShip;
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.enemyPool = enemyPool;
        this.enemyEmitter = enemyEmitter;
        setHeightProportion(HEIGHT_NEWGAME_BUTTON);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT_NEWGAME_BUTTON);
        setTop(worldBounds.getTop() - PADDING);
    }

    @Override
    public void action() {
        mainShip.reload();
        bulletPool.reload();
        explosionPool.reload();
        enemyPool.reload();
        enemyEmitter.reload();
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
