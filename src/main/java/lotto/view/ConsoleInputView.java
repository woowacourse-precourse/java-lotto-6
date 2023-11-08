package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.StringToNumberConvertor;

public class ConsoleInputView implements Input {

    @Override
    public int inputNumber() {
        String value = Console.readLine();
        return StringToNumberConvertor.convert(value);
    }

    @Override
    public String inputString() {
        return Console.readLine();
    }
}
