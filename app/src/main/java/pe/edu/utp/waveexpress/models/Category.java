package pe.edu.utp.waveexpress.models;

import com.orm.SugarRecord;

/**
 * Created by ORACLE on 09/07/2016.
 */
public class Category  extends SugarRecord {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
