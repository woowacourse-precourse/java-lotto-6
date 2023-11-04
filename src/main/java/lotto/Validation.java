package lotto;

public class Validation {

    private boolean privateValidateDivided(int price){
        if (price % 1000 <= 0) {
            return true;
        }
        throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
    }
}
