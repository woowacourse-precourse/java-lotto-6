package lotto.model;

public record Prize(
        int prizeMoney,
        int threeMatchCount,
        int fourMatchCount,
        int fiveMatchCount,
        int fiveMatchWithBonusCount,
        int sixMatchCount
) {

}
