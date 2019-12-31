package bjfu.it.fangzidong.languageexpert;

import android.widget.Switch;

public class LanguageExpert {
    public String getLanguage(String feature){
        switch (feature){
            case "OO":
                return "Java";
            case "easy":
                return "Python";
            case "new":
                return "Kotlin";
            case "fast":
                return "C++";
            default:
                return "You got me!";
        }
    }
}
