package bjfu.it.fangzidong.starbuzzdb;

import androidx.annotation.NonNull;

public class Drink {
    private String name;
    private String description;
    private int imageID;

    public Drink(){}

    Drink(String name, String description, int imageID){
        this.name = name;
        this.description = description;
        this.imageID = imageID;
    }

    static Drink[] drinks = {
            new Drink("latte", "llll", R.drawable.latte),
            new Drink("cappuccino", "llll", R.drawable.cappuccino),
            new Drink("filter", "llll", R.drawable.filter)
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
