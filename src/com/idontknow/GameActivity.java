package com.idontknow;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.idontknow.states.GameStateManager;
import com.idontknow.states.MenuState;

import sun.rmi.runtime.Log;

public class GameActivity extends ApplicationAdapter {

    public static final int width= 480;
    public static final int height= 800;
    public static final String title="FlappyBird";
    private GameStateManager gsm;

    private Music music;
    SpriteBatch spritebatch;

    @Override
    public void create() {
        super.create();
        spritebatch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();
        gsm=new GameStateManager();
        Gdx.gl.glClearColor(1,0,0,1);
        gsm.push(new MenuState(gsm));
    }

    @Override
    public void render() {
        super.render();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(spritebatch);
    }

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
    }
}


