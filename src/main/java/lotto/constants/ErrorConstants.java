package lotto.constants;

public enum ErrorConstants {
    PREFIX("[ERROR]");

    private String constants;

    private ErrorConstants(final String constants) {
        this.constants = constants;
    }

    public String getConstants(String Message) {
        return constants;
    }
}
