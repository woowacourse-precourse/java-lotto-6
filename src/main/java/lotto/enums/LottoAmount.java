package lotto.enums;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoAmount {
    MATCH3("3", false,5000),
    MATCH4("4", false,50000),
    MATCH5("5",false,1500000),
    MATCH5_BONUS("5",true,30000000),
    MATCH6("6", false,2000000000);

    private final String matchType;
    private final boolean isBonus;
    private final int amount;

    LottoAmount(String matchType, boolean isBonus, int amount) {
        this.matchType = matchType;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public static LottoAmount getLottoAmount(String matchinput){
        return Arrays.stream(LottoAmount.values())
                .filter(x -> x.matchType.equals(matchinput)).findAny().orElse(null);
    }

    public int getAmount() {
        return amount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public String getMatchType() {
        return matchType;
    }
}
