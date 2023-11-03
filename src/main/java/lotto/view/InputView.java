package lotto.view;

import static lotto.constant.UIConstant.NUMBER_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.InputVerifier;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public int getDivisibleNumberInRange(int min, int max, int divisor) {
        String input = readLine();
        InputVerifier.validateIsNumber(input);
        InputVerifier.validateIsNumberInRange(input, min, max);
        InputVerifier.validateIsDivisibleNumber(input, divisor);
        return Integer.parseInt(input);
    }

    public List<Integer> getNumbersSplitByComma(int min, int max, int count) {
        String input = this.readLine();
        String[] split = input.split(NUMBER_SEPARATOR.toString());
        InputVerifier.validateAllNumbersInRange(split, min, max);
        InputVerifier.validateNumbersCount(split, count);

        return Arrays.stream(split).map(Integer::parseInt).toList();
    }
}
