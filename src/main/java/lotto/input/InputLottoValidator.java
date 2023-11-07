package lotto;

public class InputViewValidator {
    private static final String ACCEPT_CHARACTERS = "[0-9,]+";
    private static final String MESSAGE_EXCEPTION_CHARACTER_ERROR = "[ERROR]: 숫자와 쉼표(,)만 입력해주세요.";
    private static final InputViewValidator inputLottoValidator = new InputViewValidator();

    private InputViewValidator() {}

    public static InputViewValidator getInstance() {
        return InputViewValidator.inputLottoValidator;
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
