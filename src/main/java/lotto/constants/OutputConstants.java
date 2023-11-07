package lotto.constants;

public enum OutputConstants {

    LOTTO_PRINT_PREFIX("["),
    LOTTO_PRINT_SUFFIX("]"),
    SPACE(" "),
    DASH(" - "),
    JOIN_FORMAT(", ");

    private String constants;

    OutputConstants(final String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
