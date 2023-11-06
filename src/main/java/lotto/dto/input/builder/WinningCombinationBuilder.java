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

    public WinningCombinationBuilder withWinningNumbers(String input) {
        List<Integer> winningNumbers = parseInputToList(input);
        this.winningNumbers = winningNumbers;
        this.isWinningNumbersNotSet = false;
        return this;
    }

    public WinningCombinationBuilder withBonusNumber(String input) {
        int bonusNumber = parseInputToInt(input);
        this.bonusNumber = bonusNumber;
        this.isBonusNumberNotSet = false;
        return this;
    }

    public WinningCombinationDto build() {
        verifyAllFieldAreSet();
        verifyBonusNotContainedInWinningNumbers();
        return new WinningCombinationDto(winningNumbers, bonusNumber);
    }

    private void verifyAllFieldAreSet() {
        if (isWinningNumbersNotSet || isBonusNumberNotSet) {
            throw new IllegalArgumentException("당첨번호 또는 보너스 번호가 설정되지 않았습니다.");
        }
    }

    private void verifyBonusNotContainedInWinningNumbers() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
