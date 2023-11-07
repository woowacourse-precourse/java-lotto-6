package lotto.view.input;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int readLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        Input input = Input.readLine();
        IntegerInput integerInput = new IntegerInput(input.trimmed());
        return integerInput.value();
    }

    public static List<Integer> readWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        Input input = Input.readLine();
        IntegerInputs integerInputs = new IntegerInputs(input.trimmed());
        return integerInputs.values();
    }
}
