package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public String getCost() {
        return Console.readLine();
    }

    @Override
    public List<String> getWinnerNumber() {
        return Arrays.stream(Console.readLine().split(",")).toList();
    }
}
