package ru.game;

import com.badlogic.gdx.Game;
import ru.game.screen.MenuScreen;

public class StarGame extends Game {

	
	@Override
	public void create () {
     setScreen(new MenuScreen(this));
	}

}
