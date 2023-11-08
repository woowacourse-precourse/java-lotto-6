package lotto.constants;

public enum ErrorConstants {
    PREFIX("[ERROR] ");

    private String constants;

    private ErrorConstants(final String constants) {
        this.constants = constants;
    }

    public String getConstants() {
        return constants;
    }

    public static String getErorrMessage(String errorMessage) {
        return PREFIX.getConstants() + errorMessage;
    }
}
