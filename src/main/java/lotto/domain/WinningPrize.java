package lotto.domain;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

public enum WinningPrize {
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(7, "30,000,000"),
    FIRST(6, "2,000,000,000");

    private final int numberOfMatches;
    private final String prizeAmount;

    WinningPrize(int numberOfMatches, String prizeAmount) {
        this.numberOfMatches = numberOfMatches;
        this.prizeAmount = prizeAmount;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }

    public static LinkedHashMap<Integer, String> getPrizeMap() {
        LinkedHashMap<Integer, String> prizeMap = new LinkedHashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            prizeMap.put(prize.getNumberOfMatches(), prize.getPrizeAmount());
        }
        return prizeMap;
    }
}


