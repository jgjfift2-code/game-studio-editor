package com.example.gamestudioeditor;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private static ObjectManager instance;
    private List<GameObject> objects;
    private GameObject selectedObject;

    private ObjectManager() {
        objects = new ArrayList<>();
    }

    public static ObjectManager getInstance() {
        if (instance == null) {
            instance = new ObjectManager();
        }
        return instance;
    }

    public void addObject(GameObject obj) {
        if (obj != null) {
            objects.add(obj);
        }
    }

    public void removeObject(GameObject obj) {
        objects.remove(obj);
        if (selectedObject == obj) {
            selectedObject = null;
        }
    }

    public void removeObject(int index) {
        if (index >= 0 && index < objects.size()) {
            GameObject obj = objects.get(index);
            if (selectedObject == obj) {
                selectedObject = null;
            }
            objects.remove(index);
        }
    }

    public GameObject getObject(int index) {
        if (index >= 0 && index < objects.size()) {
            return objects.get(index);
        }
        return null;
    }

    public GameObject getObject(String id) {
        for (GameObject obj : objects) {
            if (obj.getId().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    public List<GameObject> getAllObjects() {
        return new ArrayList<>(objects);
    }

    public void selectObject(GameObject obj) {
        selectedObject = obj;
    }

    public GameObject getSelectedObject() {
        return selectedObject;
    }

    public int getObjectCount() {
        return objects.size();
    }

    public void clear() {
        objects.clear();
        selectedObject = null;
    }

    public void loadObjects(List<GameObject> loadedObjects) {
        clear();
        objects.addAll(loadedObjects);
    }
}
