package com.example.ponggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PongGame extends SurfaceView implements Runnable{

    // Are we debugging?
    private final boolean DEBUGGING = true;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;
    // These objects are needed to do the drawing
    private final SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private final Paint paint;
    // How many frames per seconds did we get?
    private long mFPS;
    // Holds the screen resolution of the screen
    private final int screenX;
    private final int screenY;
    // How big will the text be ?
    private final int fontSize;
    private final int fontMargin;

    // The game objects
    private Bat mBat;
    private Ball mBall;

    // The current score and lives remaining
    private int mScore;
    private int mLives;

    // The pong game constructor
    // Called when this line:
    // pongGame = new PongGame(this, size.x, size.y);
    // is executed from pongActivity class.
    public PongGame(Context context, int x, int y) {
        // super... calls the parent class
        // constructor of SurfaceView
        // Provided by android
        super(context);

        // Initialize these two members/ fields
        // With the values passed in as parameters
        screenX = x;
        screenY = y;

        // Font is 20% (1/20th) of screen width
        fontSize = screenX / 20;
        //Margin is 1.5% (1/75th) of screen width
        fontMargin = screenX / 75;

        // Initialize the objects
        // ready for drawing with
        // getHolder() is a method of surfaceView
        surfaceHolder = getHolder();
        paint = new Paint();

        // Initialize the bat and ball

        // Everything is ready so start the game
        startNewGame();
    }

    // The player has just lost
    // or is starting their first game
    private void startNewGame() {
        // put the ball back to the starting position

        // reset the score and player chances
        mScore = 0;
        mLives = 3;
    }

    // Draw the game objects and the HUD
    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            // Lock the canvas (graphics memory) ready to draw
            canvas = surfaceHolder.lockCanvas();

            // Fill the screen with a solid color
            canvas.drawColor(Color.argb(255, 26, 128, 182));

            // Choose a color to paint with
            paint.setColor(Color.argb(255, 255, 255, 255));

            // Draw the bat and ball

            // Choose the font size
            paint.setTextSize(fontSize);

            // Draw the HUD
            canvas.drawText("Score: " + mScore +
                    "   Lives: " + mLives, fontMargin, fontSize,
                    paint);

            if (DEBUGGING) {
                printDebuggingText();
            }
            // Display the drawing on screen
            // UnlockCanvasAndPost is a method of surfaceView
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void printDebuggingText() {
        int debugSize = fontSize / 2;
        int debugStart = 150;
        paint.setTextSize(debugSize);
        canvas.drawText("FPS: " + mFPS ,
                10, debugStart + debugSize, paint);
    }

    @Override
    public void run() {

    }
}
