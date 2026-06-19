package com.example.gamestudioeditor;

public class ShapeFactory {
    private static int cubeCount = 0;
    private static int sphereCount = 0;
    private static int cylinderCount = 0;
    private static int pyramidCount = 0;

    public static GameObject createShape(String type) {
        switch (type.toLowerCase()) {
            case "cube":
                GameObject cube = new GameObject("Cube", "Cube_" + (++cubeCount));
                cube.setX(0);
                cube.setY(1);
                cube.setZ(0);
                cube.setScaleX(1);
                cube.setScaleY(1);
                cube.setScaleZ(1);
                cube.setColor(0.2f, 0.4f, 0.8f);
                return cube;

            case "sphere":
                GameObject sphere = new GameObject("Sphere", "Sphere_" + (++sphereCount));
                sphere.setX(0);
                sphere.setY(1);
                sphere.setZ(0);
                sphere.setScaleX(1);
                sphere.setScaleY(1);
                sphere.setScaleZ(1);
                sphere.setColor(0.8f, 0.2f, 0.2f);
                return sphere;

            case "cylinder":
                GameObject cylinder = new GameObject("Cylinder", "Cylinder_" + (++cylinderCount));
                cylinder.setX(0);
                cylinder.setY(1);
                cylinder.setZ(0);
                cylinder.setScaleX(0.8f);
                cylinder.setScaleY(1.5f);
                cylinder.setScaleZ(0.8f);
                cylinder.setColor(0.2f, 0.8f, 0.2f);
                return cylinder;

            case "pyramid":
                GameObject pyramid = new GameObject("Pyramid", "Pyramid_" + (++pyramidCount));
                pyramid.setX(0);
                pyramid.setY(1);
                pyramid.setZ(0);
                pyramid.setScaleX(1);
                pyramid.setScaleY(1);
                pyramid.setScaleZ(1);
                pyramid.setColor(0.8f, 0.8f, 0.2f);
                return pyramid;

            default:
                return null;
        }
    }
}
