package com.example.gamestudioeditor;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class GameGLSurfaceView extends GLSurfaceView {

    private GameRenderer renderer;

    public GameGLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GameGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        renderer = new GameRenderer(getContext());
        setRenderer(renderer);
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }

    public GameRenderer getRenderer() {
        return renderer;
    }
}
