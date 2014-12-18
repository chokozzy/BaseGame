package com.xolotlstudio.geometricrush.Scenes;

import com.xolotlstudio.geometricrush.Base.BaseScene;
import com.xolotlstudio.geometricrush.Manager.SceneManager.SceneType;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.debug.Debug;

import com.xolotlstudio.geometricrush.GameActivity;

/**
 * Created by agustin.cedeno on 16/12/2014.
 */
public class MainMenuScene extends BaseScene implements MenuScene.IOnMenuItemClickListener {
    private MenuScene menuChildScene;
    private final int MENU_PLAY = 0;
    private final int MENU_OPTIONS = 1;

    private void createMenuChildScene()
    {
        menuChildScene = new MenuScene(camara);
        menuChildScene.setPosition(240, 400);

        final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resourcesManager.play_region, vbom), .6f, .5f);
        final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_OPTIONS, resourcesManager.options_region, vbom), .6f, .5f);

        menuChildScene.addMenuItem(playMenuItem);
        menuChildScene.addMenuItem(optionsMenuItem);

        menuChildScene.buildAnimations();
        menuChildScene.setBackgroundEnabled(false);

        playMenuItem.setPosition(0,40);
        optionsMenuItem.setPosition(0,playMenuItem.getY()-playMenuItem.getHeight()/2-20);
        Debug.d("Posicion X2",Float.toString(playMenuItem.getX()));
        Debug.d("Posicion Y2",Float.toString(playMenuItem.getY()));
        menuChildScene.setOnMenuItemClickListener(this);

        setChildScene(menuChildScene);
    }
    @Override
    public void createScene() {
        createBackground();
        createMenuChildScene();
    }

    @Override
    public void onBackKeyPressed() {
        System.exit(0);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.SCENE_MENU;
    }

    @Override
    public void disposeScene() {

    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
        switch(pMenuItem.getID())
        {
            case MENU_PLAY:
                return true;
            case MENU_OPTIONS:
                return true;
            default:
                return false;
        }
    }

    private void createBackground()
    {
        attachChild(new Sprite(240, 400, resourcesManager.menu_background_region, vbom)
        {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera)
            {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }
        });
    }

}
