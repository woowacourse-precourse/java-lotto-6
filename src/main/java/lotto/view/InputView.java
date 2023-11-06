package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.converter.IntegerConverter;
import lotto.util.converter.IntegerListConverter;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.DigitsOnlyValidator;

public class InputView {
    public int readUserMoney() {
        String input = Console.readLine();
        validate(input);
        return IntegerConverter.convert(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        validate(input);
        return IntegerListConverter.convert(input);
    }

    public Integer readBonusNumber() {
        String input = Console.readLine();
        validate(input);
        return IntegerConverter.convert(input);
    }

    private void validate(String value) {
        BlankValidator.validate(value);
        DigitsOnlyValidator.validate(value);
    }
}
