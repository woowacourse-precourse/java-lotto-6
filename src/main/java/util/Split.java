package util;

public enum Split {
    INPUT_SEPERATOR(",");

    private final String seperator;

    Split(String seperator) {
        this.seperator = seperator;
    }

    public String get() {
        return seperator;
    }
}
