package com.xolotlstudio.geometricrush;

import android.util.DisplayMetrics;
import android.view.KeyEvent;

import com.xolotlstudio.geometricrush.Manager.ResourcesManager;
import com.xolotlstudio.geometricrush.Manager.SceneManager;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.CropResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import java.io.IOException;

/**
 * Created by agustin.cedeno on 11/12/2014.
 */
public class GameActivity extends BaseGameActivity {
    private Camera camara;
    private ResourcesManager resourcesManager;
    public static int CAMARA_WIDTH;
    public static int CAMARA_HEIGHT;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            SceneManager.getInstance().getCurrentScene().onBackKeyPressed();
        }
        return false;
    }

    @Override
    public Engine onCreateEngine(EngineOptions pEngineOptions) {

        return new LimitedFPSEngine(pEngineOptions,60);
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        CAMARA_WIDTH = displayMetrics.widthPixels;
        CAMARA_HEIGHT = displayMetrics.heightPixels;
        camara = new Camera(0, 0,480, 800);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED
                ,new CropResolutionPolicy(480,800), this.camara);
        engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
        engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
        return engineOptions;
    }

    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException {
        resourcesManager.prepareManager(mEngine,this,camara,getVertexBufferObjectManager());
        resourcesManager = ResourcesManager.getInstance();
        pOnCreateResourcesCallback.onCreateResourcesFinished();

    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
        SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
    }

    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException {
        mEngine.registerUpdateHandler(new TimerHandler(2f,new ITimerCallback() {
            @Override
            public void onTimePassed(TimerHandler pTimerHandler) {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                SceneManager.getInstance().createMenuScene();
                // load menu resources, create menu scene
                // set menu scene using scene manager
                // disposeSplashScene();
                // READ NEXT ARTICLE FOR THIS PART.
            }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();
    }
}
