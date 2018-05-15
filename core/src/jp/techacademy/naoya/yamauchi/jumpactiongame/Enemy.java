package jp.techacademy.naoya.yamauchi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends GameObject {
    //横幅と高さ
    public static final float ENEMY_WIDTH = 1.0f;
    public static final float ENEMY_HEIGHT = 1.0f;
    public static final int ENEMY_STATE_NORMAL = 0;
    public static final int ENEMY_STATE_VANISH = 1;

    //速度
    public static final float STEP_VELOCITY = 2.0f;

    int mType;
    int mState;
    //速度
    public static final float ENEMY_VELOCITY = 3.0f;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(ENEMY_WIDTH, ENEMY_HEIGHT);
        velocity.x = ENEMY_VELOCITY;

    }

    //座標更新
    public void update(float deltaTime) {
        setX(getX() + velocity.x * deltaTime);

        if (getX() < ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(ENEMY_WIDTH / 2);
        }
        if (getX() > GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(GameScreen.WORLD_WIDTH - ENEMY_WIDTH / 2);
        }

    }
    public void vanish() {
        mState = ENEMY_STATE_VANISH;
        setAlpha(0);
        velocity.x = 0;
    }
}
