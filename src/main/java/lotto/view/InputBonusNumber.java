package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;

import java.util.List;

public class InputBonusNumber {
    private final static String BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private final static String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private final static String LOTTO_ERROR = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    private WinningNumber winningNumber;

    public InputBonusNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int enterBonusNumber(int bonusNumber) {
        System.out.println(BONUS_NUMBER);
        while (true) {
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                validateNumber(bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(LOTTO_ERROR);
            }
        }
        return bonusNumber;
    }

    private void validateNumber(int number) {
        validateRange(number);
        validateOverlap(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(int number) {
        List<Integer> numbers = winningNumber.getWinningLotto();
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
