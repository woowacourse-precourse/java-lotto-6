package lotto.dto;

import static lotto.util.Separator.WINNING_NUMBERS_SEPARATOR;

import java.util.Collections;
import java.util.List;
import lotto.util.Converter;
import lotto.util.Separator;
import lotto.util.validator.Validator;
import lotto.util.validator.ValidatorFactory;

public record WinningNumbersDto(List<Integer> winningNumbers) {
    public static WinningNumbersDto from(String rawWinningNumbers) {
        validate(rawWinningNumbers);
        return new WinningNumbersDto(convert(rawWinningNumbers));
    }

    private static void validate(String value) {
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
        Validator validator = validatorFactory.getValidator(WinningNumbersDto.class);
        validator.validate(value);
    }

    private static List<Integer> convert(String rawWinningNumbers) {
        List<String> rawWinningNumberGroup = Separator.split(WINNING_NUMBERS_SEPARATOR, rawWinningNumbers);
        return Converter.convertToInt(rawWinningNumberGroup);
    }

    @Override
    public List<Integer> winningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
