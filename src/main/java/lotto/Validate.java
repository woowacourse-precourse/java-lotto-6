package lotto;

import java.util.List;

public class Validate {


    protected void validateInputMoneyIsInteger(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
        }
    }

    protected void validateMoneyIsMultipleOfThousand(Integer lottoMoney) {
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    protected void validateSplitInputRawWinningNumberByOverSize(List<String> splitRawWinningNumber) {
        if (splitRawWinningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }

    protected void validateInputWinningNumberIsInteger(List<String> splitRawWinningNumbers) {
        try {
            for (String WinningNumber : splitRawWinningNumbers) {
                Integer.parseInt(WinningNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
        }
    }

    protected void validateinputBonusNumberIsInteger(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해야 합니다.");
        }
    }

    protected void validateDistinctWinningAndBonusNumbers(List<Integer> winningNumbers, Integer inputBonusNumber) {
        if (winningNumbers.contains(inputBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
