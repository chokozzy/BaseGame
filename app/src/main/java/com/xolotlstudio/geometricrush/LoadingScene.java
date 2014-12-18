package com.xolotlstudio.geometricrush;

import com.xolotlstudio.geometricrush.Base.BaseScene;
import com.xolotlstudio.geometricrush.Manager.SceneManager.SceneType;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

/**
 * Created by agustin.cedeno on 17/12/2014.
 */
public class LoadingScene extends BaseScene {
    @Override
    public void createScene() {
        setBackground(new Background(Color.WHITE));
        attachChild(new Text(240,400,resourcesManager.font,activity.getResources().getText(R.string.load_tag),vbom));

    }

    @Override
    public void onBackKeyPressed() {
        return;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.SCENE_LOADING;
    }

    @Override
    public void disposeScene() {

    }
}
