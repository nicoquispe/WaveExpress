package pe.edu.utp.waveexpress.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by ORACLE on 09/07/2016.
 */
public class Entry extends SugarRecord {
    Category category;
    String description;
    Date date;
    String photo;
    Double cost;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double costo) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
