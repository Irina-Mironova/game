package ru.game.poll;

import ru.game.base.SpritesPool;
import ru.game.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newSprite() {
        return new Bullet();
    }
}
