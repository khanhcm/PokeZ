package android.at.pokez;

import java.util.ArrayList;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;


public class MainGame extends SimpleBaseGameActivity{

	private Camera camera;
	private static final int CAMERA_WIDTH = 800;
	private static final int CAMERA_HEIGHT = 480;
	private BitmapTextureAtlas bgTexture;
	private ITextureRegion bgTextureRegion;
	private Sprite bgSprite;
	private BitmapTextureAtlas bgGameTexture;
	private ITextureRegion bgGameTextureRegion;
	private Sprite bgGameSprite;
	private GameMatrix gameMatrix;
	private BitmapTextureAtlas[] arrBoxItemTexture;
	private ITextureRegion[] arrBoxItemTextureRegion;
	private Sprite[][] arrBoxItemSprite;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, 
	    new FillResolutionPolicy(), camera);
	    return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		loadGraphics();
	    loadFonts();
	    loadSounds();
	    //pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	private void loadSounds() {
		// TODO Auto-generated method stub
		
	}

	private void loadFonts() {
		// TODO Auto-generated method stub
		
	}

	private void loadGraphics() {
		// TODO Auto-generated method stub
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    bgTexture = new BitmapTextureAtlas(getTextureManager(), 1024, 1024,TextureOptions.DEFAULT);
	    bgTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bgTexture, this, "800_480/bg/bg5.jpg",0,0);
	    bgTexture.load();
	    bgGameTexture = new BitmapTextureAtlas(getTextureManager(), 1024, 1024,TextureOptions.DEFAULT);
	    bgGameTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bgGameTexture, this, "800_480/bg/bg1.jpg",0,0);
	    bgGameTexture.load();
	    arrBoxItemTexture = new BitmapTextureAtlas[20];
	    arrBoxItemTextureRegion = new ITextureRegion[20];
	    for(int i = 0; i < 20; i ++){
	    	arrBoxItemTexture[i]= new BitmapTextureAtlas(getTextureManager(), 1024, 1024,TextureOptions.DEFAULT);
	    	String imgPath="800_480/box/BoxItem"+(i+1)+".png";
	    	arrBoxItemTextureRegion[i]=BitmapTextureAtlasTextureRegionFactory.createFromAsset(arrBoxItemTexture[i], this, imgPath,0,0);
	    	arrBoxItemTexture[i].load();
	    }
	    
	}

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		Scene scene = new Scene();
		gameMatrix = new GameMatrix(5,8);
	    gameMatrix.generateMatrix();
	    scene.setBackground(new Background(0.09804f, 0.6274f, 0.8784f));
	    bgSprite = new Sprite(0,0,bgTextureRegion,this.getVertexBufferObjectManager());
	    scene.attachChild(bgSprite);
	    bgGameSprite = new Sprite(0,0,bgGameTextureRegion,this.getVertexBufferObjectManager());
	    bgGameSprite.setScaleCenter(400.0f, 240.0f);
	    bgGameSprite.setScale(0.875f, 0.8958f);
	    bgGameSprite.setPosition(100.0f,-50.0f);
	    scene.attachChild(bgGameSprite);
	    
	    arrBoxItemSprite = new Sprite[gameMatrix.get_rows()][gameMatrix.get_cols()]; 
	    for (int i = 0; i < 1; i++)
	    	for (int j = 0; j< 1; j++){
	    		arrBoxItemSprite[i][j] = new Sprite(0,0,arrBoxItemTextureRegion[gameMatrix.getMatrix()[i][j]],this.getVertexBufferObjectManager());
	    		//arrBoxItemSprite[i][j].setScaleCenter(400.0f, 240.0f);
	    		arrBoxItemSprite[i][j].setScale(0.125f,0.2f);
	    		arrBoxItemSprite[i][j].setPosition(100+(87.5f*i),86.0f*j);
	    	}
	    return scene;
	}
	
}