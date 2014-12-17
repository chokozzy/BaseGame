package com.xolotlstudio.geometricrush.Base;

import com.xolotlstudio.geometricrush.GameActivity;
import com.xolotlstudio.geometricrush.Manager.ResourcesManager;
import com.xolotlstudio.geometricrush.Manager.SceneManager.SceneType;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by agustin.cedeno on 11/12/2014.
 */
public abstract class BaseScene extends Scene {
    protected Engine engine;
    protected Camera camara;
    protected GameActivity activity;
    protected VertexBufferObjectManager vbom;
    protected ResourcesManager resourcesManager;

    public BaseScene(){
        this.resourcesManager = ResourcesManager.getInstance();
        this.activity = resourcesManager.activity;
        this.camara = resourcesManager.camara;
        this.vbom = resourcesManager.vbom;
        this.engine = resourcesManager.engine;
        createScene();
    }
    public abstract void createScene();

    public abstract void onBackKeyPressed();

    public abstract SceneType getSceneType();

    public abstract void disposeScene();



}
