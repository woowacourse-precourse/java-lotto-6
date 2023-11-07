package lotto.domain;

import java.util.List;

public class Bonus {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final String NUMBER_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 번호는 %d부터 %d까지어야 합니다.";
    private static final String DUPLICATE_BONUS_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final int number;

    public Bonus(int number, Lotto winningLotto) {
        validateNumberInRange(number);
        validateNotInWinningNumbers(number, winningLotto);
        
        this.number = number;
    }

    public static Bonus createWithValidate(int number, Lotto winningLotto) {
        return new Bonus(number, winningLotto);
    }

    private void validateNumberInRange(int number) {
        if (number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(NUMBER_OUT_OF_RANGE_MESSAGE, START_LOTTO_NUMBER, END_LOTTO_NUMBER));
        }
    }

    private void validateNotInWinningNumbers(int number, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_MESSAGE);
        }
    }
}
