package lotto.config;

public enum GameTextConfig {
    LOTTO_NUMBER_SEPARATOR(","),

//    상금
    FIRST_PRIZE("2,000,000,000원"),
    SECOND_PRIZE("30,000,000원"),
    THIRD_PRIZE("1,500,000원"),
    FOURTH_PRIZE("50,000원"),
    FIFTH_PRIZE("5,000원");

    private final String text;

    GameTextConfig(String text) {
        this.text = text;
    }

    public String getText() { return this.text; }
}
