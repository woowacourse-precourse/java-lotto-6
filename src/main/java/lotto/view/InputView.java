package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.util.converter.MultipleNumericConverter;
import lotto.util.converter.NumericConverter;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.DigitsOnlyValidator;

public class InputView {
    public int readUserMoney() {
        String input = Console.readLine();
        validate(input);
        return NumericConverter.convert(input);
    }

    public Lotto readWinningNumbers() {
        String input = Console.readLine();
        validate(input);
        return new Lotto(MultipleNumericConverter.convert(input));
    }

    public Integer readBonusNumber() {
        String input = Console.readLine();
        validate(input);
        return NumericConverter.convert(input);
    }

    private void validate(String value) {
        BlankValidator.validate(value);
        DigitsOnlyValidator.validate(value);
    }
}
