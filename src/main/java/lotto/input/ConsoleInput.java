package lotto.input;

import static lotto.input.InputValidator.validateList;
import static lotto.input.InputValidator.validateNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInput implements Input {

    @Override
    public int readNumber() {
        String readLine = Console.readLine();
        validateNumber(readLine);
        return Integer.parseInt(readLine);
    }

    @Override
    public List<Integer> readList() {
        String readLine = Console.readLine();
        validateList(readLine);
        return Arrays.stream(readLine.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
