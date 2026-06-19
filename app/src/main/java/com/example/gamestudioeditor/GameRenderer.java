package com.example.gamestudioeditor;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameRenderer implements GLSurfaceView.Renderer {

    private Context context;
    private ObjectManager objectManager;
    private GameSimulator simulator;
    private float[] projectionMatrix = new float[16];
    private float[] viewMatrix = new float[16];
    private float[] modelMatrix = new float[16];
    private float cameraX = 0, cameraY = 5, cameraZ = 10;
    private boolean isSimulating = false;

    public GameRenderer(Context context) {
        this.context = context;
        this.simulator = new GameSimulator();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        GLES20.glEnable(GLES20.GL_CULL_FACE);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        float aspect = (float) width / height;
        Matrix.perspectiveM(projectionMatrix, 0, 45, aspect, 0.1f, 100f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // Setup view matrix
        Matrix.setLookAtM(viewMatrix, 0,
                cameraX, cameraY, cameraZ,  // eye
                0, 0, 0,                     // center
                0, 1, 0);                    // up

        // Update and render objects
        if (objectManager != null) {
            if (isSimulating) {
                simulator.update(objectManager.getAllObjects());
            }
            
            for (GameObject obj : objectManager.getAllObjects()) {
                renderObject(obj);
            }
        }
    }

    private void renderObject(GameObject obj) {
        Matrix.setIdentityM(modelMatrix, 0);
        Matrix.translateM(modelMatrix, 0, obj.getX(), obj.getY(), obj.getZ());
        Matrix.scaleM(modelMatrix, 0, obj.getScaleX(), obj.getScaleY(), obj.getScaleZ());

        // This is a simplified rendering - in production you'd use actual mesh rendering
        // using OpenGL ES 2.0 vertex and fragment shaders
    }

    public void setObjectManager(ObjectManager manager) {
        this.objectManager = manager;
    }

    public void startSimulation() {
        isSimulating = true;
    }

    public void stopSimulation() {
        isSimulating = false;
    }
}
