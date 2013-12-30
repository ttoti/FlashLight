package tomas.hernandez.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class FlashMainActivity extends Activity {
	boolean isFlashOn = false;
	Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_main);
        
        camera = Camera.open();
              
        Camera.Parameters myCameraParameters = camera.getParameters();  
        myCameraParameters.setFlashMode("off"); 
        camera.setParameters(myCameraParameters);
        camera.startPreview();
        isFlashOn = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.flash_main, menu);
        return true;
    }
    
    public void buttonClicked(View view) {    
              
        Camera.Parameters myCameraParameters = camera.getParameters(); 
        
        if(!isFlashOn)
        {
        	myCameraParameters.setFlashMode("torch"); 
        	isFlashOn = true;
        }
        else if(isFlashOn)
        {
        	myCameraParameters.setFlashMode("off");
        	isFlashOn = false;
        }
        
        camera.setParameters(myCameraParameters);
        camera.startPreview();
    }
    
}
