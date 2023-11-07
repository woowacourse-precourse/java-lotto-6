package lotto.config;

public enum GameTextConfig {
    LOTTO_NUMBER_SEPARATOR(",");

    private final String text;

    GameTextConfig(String text) {
        this.text = text;
    }

    public String getValue() { return this.text; }
}
