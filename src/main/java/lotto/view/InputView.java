package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.converter.IntegerConverter;

public class InputView {
    public int readUserMoney() {
        String input = Console.readLine();
        return IntegerConverter.convert(input);
    }
}
