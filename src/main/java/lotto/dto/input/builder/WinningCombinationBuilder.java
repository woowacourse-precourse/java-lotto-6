package lotto.dto.input.builder;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.LottoValidator;
import lotto.dto.input.WinningCombinationDto;

public class WinningCombinationBuilder {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private boolean isBonusNumberNotSet = true;
    private boolean isWinningNumbersNotSet = true;

    private WinningCombinationBuilder() {

    }

    public static WinningCombinationBuilder builder() {
        return new WinningCombinationBuilder();
    }

    private static int parseInputToInt(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        LottoValidator.verifyRange(bonusNumber);
        return bonusNumber;
    }

    private static List<Integer> parseInputToList(String winningNumbersInput) {
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();
        LottoValidator.verifyNumbersSize(winningNumbers);
        LottoValidator.verifyNoDuplication(winningNumbers);
        LottoValidator.verifyLottoNumberRange(winningNumbers);
        return winningNumbers;
    }

    public WinningCombinationBuilder winningNumbers(String input) {
        List<Integer> winningNumbers = parseInputToList(input);
        this.winningNumbers = winningNumbers;
        this.isWinningNumbersNotSet = false;
        return this;
    }

    public WinningCombinationBuilder bonusNumber(String input) {
        int bonusNumber = parseInputToInt(input);
        this.bonusNumber = bonusNumber;
        this.isBonusNumberNotSet = false;
        return this;
    }

    public WinningCombinationDto build() {
        verifyAllFieldSet();
        verifyBonusIsNotContainWinningNumber();
        return new WinningCombinationDto(winningNumbers, bonusNumber);
    }

    private void verifyAllFieldSet() {
        if (isWinningNumbersNotSet || isBonusNumberNotSet) {
            throw new IllegalArgumentException("builder에 누락된 필드가 존재합니다.");
        }
    }

    private void verifyBonusIsNotContainWinningNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력한 당첨번호와 동일한 숫자를 입력하면 안 됩니다.");
        }
    }
}
