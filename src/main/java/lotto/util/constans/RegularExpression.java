package lotto.util.constans;

public enum RegularExpression {

    NUMBER_REGEX_INCLUDE_NEGATIVE("-?[0-9]+");

    private final String regExpString;

    RegularExpression(String regExpString) {
        this.regExpString = regExpString;
    }

    public String getValue() {
        return this.regExpString;
    }
}
