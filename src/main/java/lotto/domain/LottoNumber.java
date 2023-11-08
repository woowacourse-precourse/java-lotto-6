package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.List;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        try {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] " + MIN_NUMBER + "~" + MAX_NUMBER + "사이의 숫자를 입력해주세요.");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            InputView.inputWinningNumbers();
        }

    }

    public static List<Integer> pickRandomNumbers(int counter) {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, counter);
    }
}
