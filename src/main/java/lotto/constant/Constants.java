package lotto.constant;

public enum Constants {

    ;

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }
}
