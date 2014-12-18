package com.xolotlstudio.geometricrush;

import android.transition.Scene;

import com.xolotlstudio.geometricrush.Base.BaseScene;
import com.xolotlstudio.geometricrush.Manager.SceneManager.SceneType;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

/**
 * Created by agustin.cedeno on 16/12/2014.
 */
public class SplashScene extends BaseScene{
    private Sprite splash;


    @Override
    public void createScene() {
        splash = new Sprite(0,0,resourcesManager.splash_region,vbom){

            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        };
        splash.setScale(1.0f);
        splash.setPosition(240,400);
        attachChild(splash);
    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneType getSceneType() {
        return SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene() {
        splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();
    }
}
