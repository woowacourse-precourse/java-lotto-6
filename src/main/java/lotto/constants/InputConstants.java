package lotto.constants;

public enum InputConstants {

    WINNING_DELIMITER(",");

    private String constants;

    private InputConstants(final String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
