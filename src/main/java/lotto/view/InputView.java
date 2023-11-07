package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final InputFormValidation validation = new InputFormValidation();

    private InputView() {
    }

    public static InputView getInstance() {
        return new InputView();
    }

    public Integer inputNumber() {
        String input = input();
        validation.isNumber(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputLottoNumbers() {
        String[] split = input().split(",");
        validation.areNumbers(split);
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String input() {
        return Console.readLine();
    }
}
