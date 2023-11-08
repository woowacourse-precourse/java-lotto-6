package lotto.util;

public enum RewardValue {
    FIRST_REWARD("2,000,000,000"),
    SECOND_REWARD("30,000,000"),
    THIRD_REWARD("1,500,000"),
    FOURTH_REWARD("50,000"),
    FIFTH_REWARD("5,000");

    private String message;

    RewardValue(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
