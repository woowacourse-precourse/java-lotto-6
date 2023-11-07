package lotto.view.input;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int readLottoPurchasePrice() {
        Input input = Input.readLine();

        IntegerInput integerInput = new IntegerInput(input.trimmed());
        return integerInput.value();
    }

    public static List<Integer> readWinningLottoNumbers() {
        Input input = Input.readLine();

        IntegerInputs integerInputs = new IntegerInputs(input.trimmed());
        return integerInputs.values();
    }
}
