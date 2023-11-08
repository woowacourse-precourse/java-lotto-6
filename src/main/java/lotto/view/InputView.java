package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.lotto.Lotto;
import lotto.util.converter.MultipleNumericConverter;
import lotto.util.converter.NumericConverter;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.DigitsOnlyValidator;

public class InputView {
    public int readUserMoney() {
        String input = Console.readLine();
        validateNumeric(input);
        return NumericConverter.convert(input);
    }

    public Lotto readWinningNumbers() {
        String input = Console.readLine();
        validateMultipleNumeric(input);
        return new Lotto(MultipleNumericConverter.convert(input));
    }

    public Integer readBonusNumber() {
        String input = Console.readLine();
        validateNumeric(input);
        return NumericConverter.convert(input);
    }

    private void validateNumeric(String value) {
        BlankValidator.validate(value);
        DigitsOnlyValidator.validate(value);
    }

    private void validateMultipleNumeric(String value) {
        BlankValidator.validate(value);
    }
}
