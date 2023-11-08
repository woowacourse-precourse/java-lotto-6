package lotto.domain.vo;

import java.util.List;
import lotto.utils.ParserUtil;
import lotto.utils.ValidationUtil;

public class WinningNumbersVO {
    private final List<Integer> numbers;

    public WinningNumbersVO(String input) {
        this.numbers = parseValidate(input);
    }

    private List<Integer> parseValidate(String input) {
        validateInput(input);
        List<Integer> parsedNumbers = ParserUtil.parseWinningNumbers(input);
        validateParsedNumbers(parsedNumbers);
        return parsedNumbers;
    }

    private void validateInput(String input) {
        ValidationUtil.validateBlank(input);
        ValidationUtil.validateSpecialCharacters(input);
        ValidationUtil.validateWinningNumbersOutOfRange(input);
    }

    private void validateParsedNumbers(List<Integer> numbers) {
        ValidationUtil.validateCorrectNumbersCount(numbers);
        ValidationUtil.validateNoDuplicates(numbers);
        ValidationUtil.validateNumberRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
