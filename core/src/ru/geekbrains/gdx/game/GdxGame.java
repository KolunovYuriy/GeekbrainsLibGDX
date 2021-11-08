package ru.geekbrains.gdx.game;

import com.badlogic.gdx.Game;
import ru.geekbrains.gdx.game.screen.MenuScreen;

public class GdxGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
