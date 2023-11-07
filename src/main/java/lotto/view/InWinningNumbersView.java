package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InWinningNumbersView extends InputView {
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getInputValue() {
        System.out.println(INPUT_MESSAGE);
        String[] result = inputValue().split(",");
        isDigitValidate(String.join("", result));
        return Arrays.stream(result)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
