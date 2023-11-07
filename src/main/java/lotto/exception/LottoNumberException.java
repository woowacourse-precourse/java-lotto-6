package lotto.exception;

public class LottoNumberException {
    private static final int SIX_INPUTS = 6;
    private static final String INSUFFICIENT_LOTTO_NUMBER = "당첨 번호는 6개입니다.";
    private static final String NOT_NUMBER = "로또 번호는 1~45사이의 숫자만 가능합니다.";

    public void checkSixInputs(String[] inputs) {
        if (inputs.length != SIX_INPUTS) {
            throw new IllegalArgumentException(INSUFFICIENT_LOTTO_NUMBER);
        }
    }

    private boolean isNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            if(number.charAt(index) < '0' || number.charAt(index) > '9') {
                return false;
            }
        }

        return true;
    }

    public void checkSixNumbers(String[] inputs) {
        for (String input : inputs) {
            if (!isNumber(input.trim())) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    public void check
}
