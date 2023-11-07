package lotto.view.input;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int readLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        IntegerInput integerInput = new IntegerInput(readTrimmedInput());
        return integerInput.value();
    }

    public static List<Integer> readWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        IntegerInputs integerInputs = new IntegerInputs(readTrimmedInput());
        return integerInputs.values();
    }

    private static String readTrimmedInput() {
        Input input = Input.readLine();
        return input.trimmed();
    }
}
