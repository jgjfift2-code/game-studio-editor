package com.example.gamestudioeditor;

public class GameObject {
    private String id;
    private String name;
    private String type; // Cube, Sphere, Cylinder, etc.
    private float x, y, z;           // Position
    private float scaleX = 1, scaleY = 1, scaleZ = 1;  // Scale
    private float rotX = 0, rotY = 0, rotZ = 0;        // Rotation
    private float r = 1, g = 1, b = 1, a = 1;          // Color (RGBA)
    private boolean isVisible = true;
    private long createdAt;

    public GameObject(String type, String name) {
        this.type = type;
        this.name = name;
        this.id = "obj_" + System.currentTimeMillis();
        this.createdAt = System.currentTimeMillis();
    }

    // Position getters/setters
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public float getZ() { return z; }
    public void setZ(float z) { this.z = z; }

    // Scale getters/setters
    public float getScaleX() { return scaleX; }
    public void setScaleX(float scaleX) { this.scaleX = scaleX; }
    public float getScaleY() { return scaleY; }
    public void setScaleY(float scaleY) { this.scaleY = scaleY; }
    public float getScaleZ() { return scaleZ; }
    public void setScaleZ(float scaleZ) { this.scaleZ = scaleZ; }

    // Rotation getters/setters
    public float getRotX() { return rotX; }
    public void setRotX(float rotX) { this.rotX = rotX; }
    public float getRotY() { return rotY; }
    public void setRotY(float rotY) { this.rotY = rotY; }
    public float getRotZ() { return rotZ; }
    public void setRotZ(float rotZ) { this.rotZ = rotZ; }

    // Color getters/setters
    public float getR() { return r; }
    public void setR(float r) { this.r = Math.max(0, Math.min(1, r)); }
    public float getG() { return g; }
    public void setG(float g) { this.g = Math.max(0, Math.min(1, g)); }
    public float getB() { return b; }
    public void setB(float b) { this.b = Math.max(0, Math.min(1, b)); }
    public float getA() { return a; }
    public void setA(float a) { this.a = Math.max(0, Math.min(1, a)); }

    public void setColor(float r, float g, float b) {
        setR(r);
        setG(g);
        setB(b);
    }

    // Object info
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public boolean isVisible() { return isVisible; }
    public void setVisible(boolean visible) { isVisible = visible; }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
