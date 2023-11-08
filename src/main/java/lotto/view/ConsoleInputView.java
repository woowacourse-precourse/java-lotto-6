package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public int inputNumber() {
        return InputViewConvertor.parseInt(input());
    }

    @Override
    public List<Integer> inputNumbers() {
        return InputViewConvertor.parseInts(input());
    }

    private String input() {
        return Console.readLine();
    }

}
