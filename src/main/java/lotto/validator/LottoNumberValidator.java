package lotto.validator;


public class LottoNumberValidator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateNumberIsLottoNumber(int number, String exceptionMessage) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
