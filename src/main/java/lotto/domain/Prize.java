package lotto.domain;

import lotto.util.PrizeCalculator;

import java.util.EnumMap;

public record Prize (int amount){
    public static Prize of(EnumMap<LottoRank, Integer> resultBoard){
        int amount = PrizeCalculator.calculatePrizeWithResultBoard(resultBoard);
        return new Prize(amount);
    }
}
