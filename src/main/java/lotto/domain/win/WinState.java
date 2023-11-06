package lotto.domain.win;

public enum WinState {

    FIRST_PLACE("6개 일치", 6, false, 2000000000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 5, true, 30000000),
    THIRD_PLACE("5개 일치", 5, false, 1500000),
    FOURTH_PLACE("4개 일치", 4, null, 50000),
    FIFTH_PLACE("3개 일치", 3, null, 5000),
    NONE("꽝", null, null, 0);

    private final String description;
    private final Integer includedNumbersCount;
    private final Boolean isIncludedBonusNumber;
    private final int winnings;

    WinState(String description, Integer includedNumbersCount, Boolean isIncludedBonusNumber, int winnings) {
        this.description = description;
        this.includedNumbersCount = includedNumbersCount;
        this.isIncludedBonusNumber = isIncludedBonusNumber;
        this.winnings = winnings;
    }

}
