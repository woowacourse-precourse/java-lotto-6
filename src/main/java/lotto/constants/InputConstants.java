package lotto.constants;

public enum InputConstants {

    WINNING_DELIMITER(",");

    private String constants;

    private InputConstants(String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
