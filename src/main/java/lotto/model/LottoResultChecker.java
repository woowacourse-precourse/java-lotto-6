package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.BonusNumberValidator;

public class LottoResultChecker {
    private final List<Integer> winningNumbers;
    private int bonusNumber;
    BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    public LottoResultChecker (String winningNumbers) {
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setBonusNumber(String bonusNumber) {
        bonusNumberValidator.validate(bonusNumber);
        checkBonusNumberDuplicateWinningNumbers(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void checkBonusNumberDuplicateWinningNumbers(String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
