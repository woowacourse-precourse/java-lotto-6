package lotto.input.validator;

public class InputLottoValidator {
    private static final String ACCEPT_CHARACTERS = "[0-9,]+";
    private static final String MESSAGE_EXCEPTION_CHARACTER_ERROR = "[ERROR]: 숫자와 쉼표(,)만 입력해주세요.";
    private static final InputLottoValidator inputLottoValidator = new InputLottoValidator();

    private InputLottoValidator() {}


    public static InputLottoValidator getInstance() {
        return inputLottoValidator;
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
