package lotto.constants;

public enum CommonLetter {
    ERROR_PREFIX("[ERROR] "),
    NEW_LINE("\n"),
    SEPARATOR(","),
    HORIZONTAL_LINE("---------"),
    HYPHEN(" - ");

    private final String letter;

    CommonLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
