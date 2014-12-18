package com.xolotlstudio.geometricrush.Manager;

import android.graphics.Color;

import com.xolotlstudio.geometricrush.GameActivity;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import java.text.ParsePosition;

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
    public ITextureRegion menu_background_region;
    public ITextureRegion play_region;
    public ITextureRegion options_region;
    private BuildableBitmapTextureAtlas menuTextureAtlas;
    public Font font;

    public void loadMenuResources(){
        loadMenuGraphics();
        loadMenuAudio();
        loadMenuFonts();
    }
    public void loadGameResources(){
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }

    private void loadMenuGraphics(){
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("2/gfx/Menu/");
        menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
        menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "fondo.png");
        play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.png");
        options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "config.png");

        try
        {
            this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
            this.menuTextureAtlas.load();
        }
        catch (final ITextureAtlasBuilder.TextureAtlasBuilderException e)
        {
            Debug.e(e);
        }
    }

    private void loadMenuAudio(){

    }
    private void loadMenuFonts()
    {
        FontFactory.setAssetBasePath("2/font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
        font.load();
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
