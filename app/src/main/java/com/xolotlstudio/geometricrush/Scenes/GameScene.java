package com.xolotlstudio.geometricrush.Scenes;

import com.xolotlstudio.geometricrush.Base.BaseScene;
import com.xolotlstudio.geometricrush.Manager.SceneManager.SceneType;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.adt.align.HorizontalAlign;

/**
 * Created by agustin.cedeno on 17/12/2014.
 */
public class GameScene extends BaseScene{
    private HUD gameHUD;
    private Text scoreText;
    private int score = 0;
    private PhysicsWorld physicsWorld;

    private void addToScore(int i)
    {
        score += i;
        scoreText.setText("Score: " + score);
    }

    private void createHUD(){
        gameHUD = new HUD();
        //Texto Score
        scoreText = new Text(420,20,resourcesManager.font,"Score: 0123456789",new TextOptions(HorizontalAlign.LEFT),vbom);
        scoreText.setAnchorCenter(0,0);
        scoreText.setText("Score: 0");
        gameHUD.attachChild(scoreText);
        camara.setHUD(gameHUD);
    }
    @Override
    public void createScene() {

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneType getSceneType() {
        return SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene() {

    }
}
