package bjfu.it.fangzidong.starbuzz;

import androidx.annotation.NonNull;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "A couple of shots with steamed milk", R.drawable.cappuccino),
            new Drink("Latte", "A couple of shots with steamed milk", R.drawable.latte)
    };

    Drink(){}

    private Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
