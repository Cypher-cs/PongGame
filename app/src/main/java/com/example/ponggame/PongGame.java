package com.example.ponggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PongGame extends SurfaceView {

    // Are we debugging?
    private final boolean DEBUGGING = true;

    // These objects are needed to do the drawing
    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private Paint paint;

    // How many frames per seconds did we get?
    private long mFPS;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;

    // Holds the screen resolution of the screen
    private int screenX;
    private int screenY;
    // How big will the text be ?
    private int fontSize;
    private int fontMargin;


    // The pong game constructor
    // Called when this line:
    // pongGame = new PongGame(this, size.x, size.y);
    // is executed from pongActivity class.
    public PongGame(Context context, int x, int y) {
        // super... calls the parent class
        // constructor of SurfaceView
        // Provided by android
        super(context);
    }
}
