package lotto.dto;

import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Number;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class DrawnNumbersDto {
    private List<Number> winningNumbers;
    private Number bonusNumber;

    private DrawnNumbersDto(List<Number> winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static DrawnNumbersDto of(String winningNumbers, String bonusNumber) {
        return new DrawnNumbersDto(
                parseWinningNumbers(winningNumbers),
                parseBonusNumber(bonusNumber)
        );
    }

    private static List<Number> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(split(winningNumbers))
                    .map(Integer::parseInt)
                    .map(Number::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static String[] split(String winningNumbers) {
        return winningNumbers.split(INPUT_SEPARATOR.getSymbol());
    }

    private static Number parseBonusNumber(String bonusNumber) {
        try {
            int number = Integer.parseInt(bonusNumber);
            return Number.valueOf(number);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    public List<Number> getWinningNumbers() {
        return this.winningNumbers;
    }

    public Number getBonusNumber() {
        return this.bonusNumber;
    }
}
