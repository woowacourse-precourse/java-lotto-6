package lotto.constants;

public enum OutputConstants {

    LOTTO_PRINT_PREFIX("["),
    LOTTO_PRINT_SUFFIX("]"),
    SPACE(" "),
    DASH(" - ");

    private String constants;

    OutputConstants(String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }
}
