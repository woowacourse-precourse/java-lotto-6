package lotto.input.validator;

public class InputMoneyValidator {
    private static final String ACCEPT_CHARACTERS = "[0-9]+";
    private static final String MESSAGE_EXCEPTION_CHARACTER_ERROR = "[ERROR] 숫자만 입력해주세요.";

    private static final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();

    private InputMoneyValidator() {}

    public static InputMoneyValidator getInstance() {
        return inputMoneyValidator;
    }

    public void validate(String input) {
        validateAcceptCharacter(input);
    }

    private static void validateAcceptCharacter(String input) {
        if (!input.matches(ACCEPT_CHARACTERS)) {
            throw new IllegalArgumentException(MESSAGE_EXCEPTION_CHARACTER_ERROR);
        }
    }
}
