package lotto.dto;

import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class DrawnNumbersDto {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    private DrawnNumbersDto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbersDto of(String winningNumbers, String bonusNumber) {
        return new DrawnNumbersDto(
                parseWinningNumbers(winningNumbers),
                parseBonusNumber(bonusNumber)
        );
    }

    private static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(split(winningNumbers))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static String[] split(String winningNumbers) {
        return winningNumbers.split(INPUT_SEPARATOR.getSymbol());
    }

    private static Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
