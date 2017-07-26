package com.idontknow.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by sridhar123 on 16/7/17.
 */

public class Tube {

    public static final int TUBE_WIDTH=52;
    private Texture topTube,bottomTube;
    private Vector2 posTopTube,posBottomTube;
    private Random random;
    private Rectangle boundsTop,boundsBottom;
    private static final int FLUCTUATION=130,TUBE_GAP = 100,LOWEST_OPENING = 120;

    public Tube(float x){
        topTube=new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        random=new Random();

        posTopTube=new Vector2(x,random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop=new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        boundsBottom=new Rectangle(posBottomTube.x,posBottomTube.y,bottomTube.getWidth(),bottomTube.getHeight());

    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x){
        posTopTube.set(x,random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBottomTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBottom.setPosition(posBottomTube.x,posBottomTube.y);
    }

    public boolean collide(Rectangle player){
        return player.overlaps(boundsTop)|| player.overlaps(boundsBottom);
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
