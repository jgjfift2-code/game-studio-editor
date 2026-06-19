package com.example.gamestudioeditor;

import java.util.List;

public class GameSimulator {
    private float gravity = 9.8f;
    private long lastUpdateTime = 0;
    private boolean isRunning = false;

    public GameSimulator() {
        this.isRunning = true;
    }

    public void update(List<GameObject> objects) {
        if (!isRunning) return;

        long currentTime = System.currentTimeMillis();
        if (lastUpdateTime == 0) {
            lastUpdateTime = currentTime;
            return;
        }

        float deltaTime = (currentTime - lastUpdateTime) / 1000.0f;
        lastUpdateTime = currentTime;

        // Apply physics simulations
        for (GameObject obj : objects) {
            if (obj.isVisible()) {
                // Apply gravity
                float newY = obj.getY() - (gravity * deltaTime * deltaTime);
                if (newY < 0) {
                    newY = 0; // Ground collision
                }
                obj.setY(newY);

                // Add rotation for visual effect
                obj.setRotX(obj.getRotX() + 0.5f * deltaTime);
                obj.setRotY(obj.getRotY() + 1f * deltaTime);
            }
        }
    }

    public void start() {
        isRunning = true;
        lastUpdateTime = 0;
    }

    public void stop() {
        isRunning = false;
        lastUpdateTime = 0;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getGravity() {
        return gravity;
    }
}
