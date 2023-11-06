package lotto.exception;

import lotto.view.InputView;

import java.util.List;

public class CustomizedException {
    static final String ERROR_MESSAGE_INIT = "[ERROR] ";
    static final int WINNING_NUMBERS_SIZE = 6;

    public static void notDivisibleByThousandException(int price) {
        if (price % 1000 != 0 || price == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INIT + "올바르지 않은 값입니다.다시 입력해주세요.");
        }
    }

    public static void winningNumbersSizeMoreOrLess(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INIT + "로또 번호는 총 6개를 입력하셔야합니다.");
        }
    }


}
