package lotto.model;

import java.util.List;
import java.util.regex.Pattern;

public class BonusNumber {

    private static final Pattern bonusNumberInputPattern = Pattern.compile("\\d{1,2}");
    private int bonusNumber;

    public void inputBonusNumber(String input, List<Integer> winningNumbers) {
        validateBonusNumber(input);
        int number = Integer.parseInt(input);
        validateNumberRange(number);
        validateBonusNumber(winningNumbers, number);
        this.bonusNumber = number;
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호를 입력해주세요.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또는 1부터 45까지의 숫자만 사용됩니다.");
        }
    }

    private static void validateBonusNumber(String input) {
        if (!bonusNumberInputPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 보너스 번호 입력 양식입니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
