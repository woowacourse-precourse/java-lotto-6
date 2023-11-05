package lotto.view;

import static lotto.constant.UIConstant.NUMBER_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoPurchase;
import lotto.util.InputValidator;

public class InputView {
    public String readLine() {
        return Console.readLine();
    }

    public int getLottoNumber(int min, int max) {
        String input = readLine();
        InputValidator.validateIsNumberInRange(input, min, max);
        return Integer.parseInt(input);
    }

    public LottoPurchase getLottoPurchaseMoney(int min, int max, int divisor) {
        String input = readLine();
        InputValidator.validateIsNumberInRange(input, min, max);
        InputValidator.validateIsDivisibleNumber(input, divisor);
        return LottoPurchase.from(Integer.parseInt(input));
    }

    public List<Integer> getNumbersSplitByComma(int min, int max, int count) {
        String input = this.readLine();
        String[] split = input.split(NUMBER_SEPARATOR.toString());
        InputValidator.validateAllNumbersInRange(split, min, max);
        InputValidator.validateNumbersCount(split, count);

        return Arrays.stream(split).map(Integer::parseInt).toList();
    }
}
