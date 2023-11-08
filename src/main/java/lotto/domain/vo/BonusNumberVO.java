package lotto.domain.vo;

import java.util.List;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class BonusNumberVO {
    private final int number;

    public BonusNumberVO(String input, List<Integer> winningNumbers) {
        this.number = parseValidate(input, winningNumbers);
    }

    private int parseValidate(String input, List<Integer> winningNumbers) {
        validateInput(input);
        int parsedNumber = ParserUtil.parseLottoNumber(input);
        validateParsedNumber(parsedNumber, winningNumbers);
        return parsedNumber;
    }

    private void validateInput(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateOutOfRange(input);
    }

    private void validateParsedNumber(int number, List<Integer> winningNumbers) {
        ValidationUtil.validateBonusNumber(number);
        ValidationUtil.validateBonusNumberNotInWinningNumbers(number, winningNumbers);
    }

    public int getNumber() {
        return number;
    }
}