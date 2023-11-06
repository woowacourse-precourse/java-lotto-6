package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.converter.IntegerConverter;
import lotto.util.converter.IntegerListConverter;

public class InputView {
    public int readUserMoney() {
        String input = Console.readLine();
        return IntegerConverter.convert(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = Console.readLine();
        return IntegerListConverter.convert(input);
    }
}
