package lotto.view;

import lotto.domain.WinningNumber;

import java.util.List;
import java.util.regex.Pattern;

public class InputBonusNumberView extends InputView {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(REQUEST_BONUS_NUMBER);
        int bonus = convertValue(inputValue());
        System.out.println();
        try {
            WinningNumber.validateBonusNumber(winningNumbers, bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return getBonusNumber(winningNumbers);
        }
    }

    private int convertValue(String input) {
        return Integer.parseInt(input);
    }
}
