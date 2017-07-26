package com.idontknow.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by sridhar123 on 15/7/17.
 */

public class GameStateManager {

    private Stack<State> statesStack;
    public GameStateManager(){
        statesStack=new Stack<State>();
    }

    public void push(State state){
        statesStack.push(state);
    }

    public void pop(){
        statesStack.pop().dispose();
    }

    public void set(State state){
        statesStack.pop().dispose();
        statesStack.push(state);
    }

    public void update(float dt){
        statesStack.peek().update(dt);
    }

    public void render(SpriteBatch batch){
        statesStack.peek().render(batch);
    }
}
