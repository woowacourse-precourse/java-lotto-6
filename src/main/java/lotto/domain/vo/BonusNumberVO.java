package lotto.domain.vo;

import java.util.List;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class BonusNumberVO {
    private final int number;

    public BonusNumberVO(String input, List<Integer> winningNumbers) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateOutOfRange(input);
        int parsedNumber = ParserUtil.parseLottoNumber(input);
        ValidationUtil.validateBonusNumber(parsedNumber);
        ValidationUtil.validateBonusNumberNotInWinningNumbers(parsedNumber, winningNumbers);
        this.number = parsedNumber;
    }

    public int getNumber() {
        return number;
    }
}
