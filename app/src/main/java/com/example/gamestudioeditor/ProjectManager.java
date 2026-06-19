package com.example.gamestudioeditor;

import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private static ProjectManager instance;
    private static final String PROJECT_DIR = "GameStudioProjects";
    private static final String PROJECT_FILE = "project.json";
    private Gson gson;

    private ProjectManager() {
        gson = new Gson();
    }

    public static ProjectManager getInstance() {
        if (instance == null) {
            instance = new ProjectManager();
        }
        return instance;
    }

    public void saveProject(List<GameObject> objects) {
        try {
            File projectDir = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOCUMENTS), PROJECT_DIR);
            
            if (!projectDir.exists()) {
                projectDir.mkdirs();
            }

            File projectFile = new File(projectDir, PROJECT_FILE);
            FileWriter writer = new FileWriter(projectFile);
            
            String json = gson.toJson(objects);
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GameObject> loadProject() {
        try {
            File projectDir = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOCUMENTS), PROJECT_DIR);
            File projectFile = new File(projectDir, PROJECT_FILE);

            if (!projectFile.exists()) {
                return new ArrayList<>();
            }

            FileReader reader = new FileReader(projectFile);
            Type type = new TypeToken<List<GameObject>>(){}.getType();
            List<GameObject> objects = gson.fromJson(reader, type);
            reader.close();

            return objects != null ? objects : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
