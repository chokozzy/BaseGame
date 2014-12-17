package com.xolotlstudio.geometricrush.Manager;

import com.xolotlstudio.geometricrush.GameActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by agustin.cedeno on 11/12/2014.
 */
public class ResourcesManager {

    private static final ResourcesManager INSTANCE = new ResourcesManager();

    public Engine engine;
    public GameActivity activity;
    public Camera camara;
    public VertexBufferObjectManager vbom;
    public ITextureRegion splash_region;
    protected BitmapTextureAtlas splashTextureAtlas;

    public void loadMenuResources(){
        loadMenuGraphics();
        loadMenuAudio();
    }
    public void loadGameResources(){
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics(){

    }

    private void loadMenuAudio(){

    }

    private void loadGameGraphics(){

    }

    private void loadGameFonts(){

    }

    private void loadGameAudio(){

    }

    public void loadSplashScreen()
    {
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("2/gfx/");
        splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(),382,382, TextureOptions.BILINEAR);
        splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas,activity,"splash.png",0,0);
        splashTextureAtlas.load();
    }

    public void unloadSplashScreen()
    {
        splashTextureAtlas.unload();
        splash_region = null;
    }

    /**
     *
     * @param engine
     * @param activity
     * @param camara
     * @param vbom
     * Usamos este metodo al inicio de la carga del juego,para preparar el manejador de recursos adecuadamente,
     * guardando todos los parametros necesarios,Despues podremos acceder a ellos desde diferentes clases (ex. Escenas)
     */
    public static void prepareManager(Engine engine, GameActivity activity, Camera camara, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camara = camara;
        getInstance().vbom = vbom;
    }
    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------

    public static ResourcesManager getInstance()
    {
        return INSTANCE;
    }

}
