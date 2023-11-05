package lotto.constant;

public enum RegexValidator {
    COUNT("^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$", ExceptionMessage.COUNT),
    LOTTO_NUMBER("^(?:[1-9]|[1-3][0-9]|4[0-5])$", ExceptionMessage.LOTTO_NUMBER),
    PRICE("^([1-9][0-9]*0{3})$", ExceptionMessage.PRICE);

    private final String regex;
    private final ExceptionMessage exceptionMessage;

    RegexValidator(String regex, ExceptionMessage exceptionMessage) {
        this.regex = regex;
        this.exceptionMessage = exceptionMessage;
    }

    public void validate(String input) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
