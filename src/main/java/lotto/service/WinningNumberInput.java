package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomException;
import exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class WinningNumberInput {

    public Map<Lotto, Integer> inputWinningNumbers() {
        Lotto lotto = inputNumbers();
        int bonusNumber = inputBonusNumbers(lotto);
        return Map.of(lotto,bonusNumber);
    }

    private Lotto inputNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                return validateNumber(userInput.split(","));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int inputBonusNumbers(Lotto lotto) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                int bonusNumber = transString(userInput);
                isBetween1And45(bonusNumber);
                containCheck(lotto, bonusNumber);
                return bonusNumber;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Lotto validateNumber(String[] numbers) {
        return new Lotto(isNumber(numbers));
    }

    private List<Integer> isNumber(String[] numbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : numbers) {
            winningNumbers.add(transString(s));
        }
        for (int n : winningNumbers) {
            isBetween1And45(n);
        }

        return winningNumbers;
    }

    private void containCheck(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않은 값을 입력해 주세요.");
        }
    }

    private int transString(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new CustomException(ErrorCode.PARSEERRORTYPE);
        }
    }

    private void isBetween1And45(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1이상 45이하의 숫자를 입력해 주세요.");
        }
    }
}
