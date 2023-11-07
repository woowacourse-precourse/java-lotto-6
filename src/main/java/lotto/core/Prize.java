package lotto.core;

import static lotto.constValue.ConstMessage.*;

public enum Prize {
    FIFTH(FIFTH_PLACE_MESSAGE,3,false, 5_000),
    FOURTH(FOURTH_PLACE_MESSAGE,4,false, 5_0000),
    THIRD(THIRD_PLACE_MESSAGE,5,false, 1_500_000),
    SECOND(SECOND_PLACE_MESSAGE,5, true, 30_000_000),
    FIRST(FIRST_PLACE_MESSAGE,6, false, 2_000_000_000);

    private final String message;
    private final int matchingCount;
    private final boolean hasBonus;
    private final int price;

    Prize(String message, int matchingCount, boolean hasBonus, int price) {
        this.message = message;
        this.matchingCount = matchingCount;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public String getMessage(){
        return message;
    }
    public String getPrizeResult(int count) {
        return message + count + "개";
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public double getPrice(int count) {
        return (double) count * price;
    }

}
