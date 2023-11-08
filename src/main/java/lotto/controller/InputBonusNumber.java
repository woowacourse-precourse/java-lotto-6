package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import lotto.controller.exception.DuplicationException;
import lotto.controller.exception.RangeException;
import lotto.controller.exception.WrongTypeException;

public class InputBonusNumber {
    private static final String MESSAGE = "보너스 번호를 입력해 주세요.";
    private final List<Integer> winningNumbers;

    public InputBonusNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println(MESSAGE);
        while (true) {
            String bonusNumber = Console.readLine();
            System.out.println();
            try {
                validation(bonusNumber);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validation(String bonusNumber) {
        bonusNumberValidation(bonusNumber);
    }

    private void bonusNumberValidation(String bonusNumber) {
        if (!Pattern.compile("\\d+").matcher(bonusNumber).matches()) {
            throw new WrongTypeException();
        }
        int checkNumber = Integer.parseInt(bonusNumber);
        if (checkNumber < 1 || checkNumber > 45) {
            throw new RangeException();
        }
        if (winningNumbers.contains(checkNumber)) {
            throw new DuplicationException();
        }
    }
}
