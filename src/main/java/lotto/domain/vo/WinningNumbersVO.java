package lotto.domain.vo;

import java.util.List;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class WinningNumbersVO {
    private final List<Integer> numbers;

    public WinningNumbersVO(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateWinningNumbersOutOfRange(input);
        List<Integer> parsedNumbers = ParserUtil.parseWinningNumbers(input);
        ValidationUtil.validateCorrectNumbersCount(parsedNumbers);
        ValidationUtil.validateNoDuplicates(parsedNumbers);
        ValidationUtil.validateNumberRange(parsedNumbers);
        this.numbers = parsedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
