package InputManager;

public enum InputRegex {
    COST_NUMBER_REGEX("^([1-9]+[0-9]*)$"),
    WINNING_NUMBER_REGEX("^([1-9]+[0-9]*,)*([1-9]+[0-9]*)$"),
    BONUS_NUMBER_REGEX("^([1-9]+[0-9]*)$");

    private String regexString;

    InputRegex(String regexString) {
        this.regexString = regexString;
    }

    String getRegex() {
        return regexString;
    }
}
