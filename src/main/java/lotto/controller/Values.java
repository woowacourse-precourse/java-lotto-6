package lotto.controller;

enum Values {
    MINIMUM_NUMBER_OF_SAME(3),
    LOTTO_SIZE(6),
    FIRST_REWARD(200000000.0),
    SECOND_REWARD(30000000.0),
    THIRD_REWARD(1500000.0),
    FOURTH_REWARD(50000.0),
    FIFTH_REWARD(5000.0),
    LOSE(0.0),
    MATCH_NUMBER_TO_WIN_FIRST(6),
    MATCH_NUMBER_TO_WIN_SECOND(5.5),
    MATCH_NUMBER_TO_WIN_THIRD(5),
    MATCH_NUMBER_TO_WIN_FOURTH(4),
    MATCH_NUMBER_TO_WIN_FIFTH(3);
    private final double value;

    Values(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
