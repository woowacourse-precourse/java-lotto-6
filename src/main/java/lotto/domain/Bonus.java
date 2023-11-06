package lotto.domain;

public class Bonus {
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "로또 번호는 정수여야 합니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 서로 다른 수여야 합니다.";
    private static final int LOTTO_RANGE_BEGIN_NUMBER = 1;
    private static final int LOTTO_RANGE_END_NUMBER = 45;

    private final int bonusNumber;

    public Bonus(String bonusNumber, Lotto winningLotto) {
        this.bonusNumber = convertToInteger(bonusNumber);
    }

    private int convertToInteger(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
    }
}
