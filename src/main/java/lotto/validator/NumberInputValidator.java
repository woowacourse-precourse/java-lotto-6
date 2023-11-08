package lotto.validator;

public class NumberInputValidator implements InputValidator {

    private final static String ENTER_LOTTO_NUMBER_RANGE_1_TO_45 = "로또 번호는 1부터 45 사이의 숫자로 입력해주세요.";
    private final static String ENTER_LOTTO_NUMBER = "유효한 숫자로 입력하시길 바랍니다.";
    private final static String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";
    private final static int LOTTO_NUM_MIN_RANGE = 1;
    private final static int LOTTO_NUM_MAX_RANGE = 45;

    @Override
    public void validate(String input) {
        validateNumber(input);
        validateNumberRange(input);
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ENTER_LOTTO_NUMBER);
        }
    }

    private void validateNumberRange(String input) {
        if (Integer.parseInt(input) < LOTTO_NUM_MIN_RANGE || Integer.parseInt(input) > LOTTO_NUM_MAX_RANGE) {
            throw new IllegalArgumentException(ENTER_LOTTO_NUMBER_RANGE_1_TO_45);
        }
    }


}
