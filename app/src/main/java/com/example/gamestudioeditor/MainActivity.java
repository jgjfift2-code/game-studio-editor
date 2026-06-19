package com.example.gamestudioeditor;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FrameLayout glContainer;
    private GameGLSurfaceView glSurfaceView;
    private Button btnAddCube, btnAddSphere, btnAddCylinder, btnPlayStop, btnSave, btnLoad;
    private ObjectManager objectManager;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        initializeViews();
        setupObjectManager();
        setupButtons();
    }

    private void initializeViews() {
        glContainer = findViewById(R.id.gl_container);
        btnAddCube = findViewById(R.id.btn_add_cube);
        btnAddSphere = findViewById(R.id.btn_add_sphere);
        btnAddCylinder = findViewById(R.id.btn_add_cylinder);
        btnPlayStop = findViewById(R.id.btn_play_stop);
        btnSave = findViewById(R.id.btn_save);
        btnLoad = findViewById(R.id.btn_load);

        // Initialize GLSurfaceView
        glSurfaceView = new GameGLSurfaceView(this);
        glContainer.addView(glSurfaceView);
    }

    private void setupObjectManager() {
        objectManager = ObjectManager.getInstance();
        if (glSurfaceView != null && glSurfaceView.getRenderer() != null) {
            glSurfaceView.getRenderer().setObjectManager(objectManager);
        }
    }

    private void setupButtons() {
        btnAddCube.setOnClickListener(v -> addGameObject("Cube"));
        btnAddSphere.setOnClickListener(v -> addGameObject("Sphere"));
        btnAddCylinder.setOnClickListener(v -> addGameObject("Cylinder"));
        btnPlayStop.setOnClickListener(v -> togglePlayMode());
        btnSave.setOnClickListener(v -> saveProject());
        btnLoad.setOnClickListener(v -> loadProject());
    }

    private void addGameObject(String type) {
        GameObject obj = ShapeFactory.createShape(type);
        if (obj != null) {
            objectManager.addObject(obj);
            Toast.makeText(this, type + " added", Toast.LENGTH_SHORT).show();
        }
    }

    private void togglePlayMode() {
        isPlaying = !isPlaying;
        if (isPlaying) {
            btnPlayStop.setText("Stop");
            btnPlayStop.setBackgroundColor(getResources().getColor(R.color.red));
            glSurfaceView.getRenderer().startSimulation();
        } else {
            btnPlayStop.setText("Play");
            btnPlayStop.setBackgroundColor(getResources().getColor(R.color.green));
            glSurfaceView.getRenderer().stopSimulation();
        }
    }

    private void saveProject() {
        ProjectManager.getInstance().saveProject(objectManager.getAllObjects());
        Toast.makeText(this, "Project saved", Toast.LENGTH_SHORT).show();
    }

    private void loadProject() {
        objectManager.loadObjects(ProjectManager.getInstance().loadProject());
        Toast.makeText(this, "Project loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (glSurfaceView != null) {
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (glSurfaceView != null) {
            glSurfaceView.onPause();
        }
    }
}
