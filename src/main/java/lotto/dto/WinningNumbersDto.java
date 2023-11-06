package lotto.dto;

import static lotto.util.Seperator.WINNING_NUMBERS_SEPARATOR;

import java.util.List;
import lotto.domain.Purchase;
import lotto.util.Converter;
import lotto.util.Seperator;
import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;

public class WinningNumbersDto {
    private final List<Integer> winningNumbers;

    public WinningNumbersDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbersDto from(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        return new WinningNumbersDto(convert(rawWinningNumbers));
    }

    private static List<Integer> convert(String rawWinningNumbers) {
        List<String> rawWinningNumberGroup = WINNING_NUMBERS_SEPARATOR.split(rawWinningNumbers);
        return Converter.convertToInt(rawWinningNumberGroup);
    }

    private static void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(WinningNumbersDto.class);
        validator.validate(value);
    }
}
