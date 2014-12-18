package com.xolotlstudio.geometricrush.Manager;

import com.xolotlstudio.geometricrush.Base.BaseScene;
import com.xolotlstudio.geometricrush.Scenes.LoadingScene;
import com.xolotlstudio.geometricrush.Scenes.MainMenuScene;
import com.xolotlstudio.geometricrush.Scenes.SplashScene;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface;

/**
 * Created by agustin.cedeno on 11/12/2014.
 */
public class SceneManager {
    //---------------------------------------------
    // SCENES
    //---------------------------------------------

    private BaseScene splashScene;
    private BaseScene menuScene;
    private BaseScene gameScene;
    private BaseScene loadingScene;

    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------

    private static final SceneManager INSTANCE = new SceneManager();

    private SceneType currentSceneType = SceneType.SCENE_SPLASH;

    private BaseScene currentScene;

    private Engine engine = ResourcesManager.getInstance().engine;

    public enum SceneType
    {
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_GAME,
        SCENE_LOADING,
    }

    public void setScene(BaseScene scene){
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();

    }
    public void setScene(SceneType sceneType){

        switch (sceneType){
            case SCENE_MENU:
                setScene(menuScene);
                break;
            case SCENE_SPLASH:
                setScene(splashScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            case SCENE_GAME:
                setScene(gameScene);
                break;
            default:
                break;
        }
    }
    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static SceneManager getInstance()

    {
        return INSTANCE;
    }

    public SceneType getCurrentSceneType()
    {
        return currentSceneType;
    }

    public BaseScene getCurrentScene()
    {
        return currentScene;
    }

    public void createSplashScene(IGameInterface.OnCreateSceneCallback pOnCreateSceneCallback)
    {
        ResourcesManager.getInstance().loadSplashScreen();
        splashScene = new SplashScene();
        currentScene = splashScene;
        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
    }

    private void disposeSplashScene()
    {
        ResourcesManager.getInstance().unloadSplashScreen();
        splashScene.disposeScene();
        splashScene = null;
    }

    public void createMenuScene()
    {
        ResourcesManager.getInstance().loadMenuResources();
        menuScene = new MainMenuScene();
        loadingScene = new LoadingScene();
        SceneManager.getInstance().setScene(menuScene);
        disposeSplashScene();
    }

}
