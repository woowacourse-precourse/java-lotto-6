package lotto;

import java.text.NumberFormat;
import java.util.Locale;

public enum PRIZE {
    FIRST(0,2000000000),
    SECOND(1, 30000000),
    THIRD(2, 1500000),
    FORTH(3, 50000),
    FIFTH(4, 5000),
    FAIL(5, 0);

    private final int value;
    private final int score;
    PRIZE(int score, int value){
        this.value = value;
        this.score = score;
    }

    public int getValue(){
        return value;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return NumberFormat.getNumberInstance(Locale.US).format(value)+"원";
    }
}
