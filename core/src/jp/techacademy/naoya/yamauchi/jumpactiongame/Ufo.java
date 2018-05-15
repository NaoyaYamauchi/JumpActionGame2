package jp.techacademy.naoya.yamauchi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

public class Ufo extends GameObject {
    //横幅と高さの設定
    public static final float UFO_WIDTH = 2.0f;
    public static final float UFO_HEIGHT =1.3f;

    public Ufo(Texture texure , int srcX,int srcY,int srcWidth,int srcHeight){
        super(texure,srcX,srcY,srcWidth,srcHeight);
        setSize(UFO_WIDTH,UFO_HEIGHT);
    }
}
