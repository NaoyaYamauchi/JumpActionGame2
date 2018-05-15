package jp.techacademy.naoya.yamauchi.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

public class Step extends GameObject {
    //横幅と高さ
    public static final float STEP_WIDTH = 2.0f;
    public static final float STEP_HEIGHT = 0.5f;

    //通常床と動く床
    public static final int STEP_TYPE_STATIC = 0;
    public static final int STEP_TYPE_MOVING = 1;

    //通常時と消えた状態
    public static final int STEP_STATE_NORMAL = 0;
    public static final int STEP_STATE_VANISH = 1;

    //速度
    public static final float STEP_VELOCITY = 2.0f;

    int mType;
    int mState;

    public Step(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(STEP_WIDTH, STEP_HEIGHT);
        mType = type;
        if (mType == STEP_TYPE_MOVING) {
            velocity.x = STEP_VELOCITY;
        }
    }

    //座標更新
    public void update(float deltaTime) {
        if (mType == STEP_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);

            if (getX() < STEP_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(STEP_WIDTH / 2);
            }
            if (getX() > GameScreen.WORLD_WIDTH - STEP_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(GameScreen.WORLD_WIDTH - STEP_WIDTH / 2);
            }
        }
    }

    public void vanish() {
        mState = STEP_STATE_VANISH;
        setAlpha(0);
        velocity.x = 0;
    }

}
