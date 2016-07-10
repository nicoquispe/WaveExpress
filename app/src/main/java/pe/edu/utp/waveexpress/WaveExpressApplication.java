package pe.edu.utp.waveexpress;

import android.content.res.Configuration;

import com.orm.SugarApp;
import com.orm.SugarContext;

import pe.edu.utp.waveexpress.models.Category;
import pe.edu.utp.waveexpress.services.WaveService;

/**
 * Created by ORACLE on 09/07/2016.
 */
public class WaveExpressApplication extends SugarApp {
    private WaveService waveService = new WaveService();

    public WaveService getWaveService() {
        return waveService;
    }

    public void setWaveService(WaveService waveService) {
        this.waveService = waveService;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());

        Category category = new Category("Transport");
        category.save();
        Category category2 = new Category("Food");
        category2.save();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


}
