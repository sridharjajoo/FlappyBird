package com.idontknow.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by sridhar123 on 16/7/17.
 */

public class Bird {
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private final int GRAVITY = -15;
    private static final int MOVEMENT =100;
    private Rectangle bound;
    private Animation birdAnimation;
    private Texture texture;
    private Sound sound;
    public Bird(int x,int y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture),3,0.5f);
       // bird = new Texture("bird.png");
        bound=new Rectangle(x,y,texture.getWidth()/3,texture.getHeight());
        sound= Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y > 0)
            velocity.add(0,GRAVITY,0);
       velocity.scl(dt);
       position.add(MOVEMENT*dt,velocity.y,0);
       velocity.scl(1/dt);
        if(position.y < 0)
            position.y=0;
        bound.setPosition(position.x,position.y);
    }

   public TextureRegion getTexture()
   {
       return birdAnimation.getFrame();
   }

    public Vector3 getPosition() {
        return position;
    }

    public void jump(){
        sound.play();
        velocity.y=250;
        velocity.x=100;
    }

    public Rectangle getBound(){
        return bound;
    }

    public void dispose(){
        texture .dispose();
        sound.dispose();
    }
}
