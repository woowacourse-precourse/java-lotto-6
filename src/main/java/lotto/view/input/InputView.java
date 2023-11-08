package lotto.view.input;

import java.util.List;

public class InputView {
    private static final String READ_LOTTO_PURCHASE_PRICE_SCRIPT = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_LOTTO_NUMBERS_SCRIPT = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_SCRIPT = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int readLottoPurchasePrice() {
        System.out.println(READ_LOTTO_PURCHASE_PRICE_SCRIPT);

        IntegerInput integerInput = new IntegerInput(readTrimmedInput());
        return integerInput.value();
    }

    public static List<Integer> readWinningLottoNumbers() {
        System.out.println(READ_WINNING_LOTTO_NUMBERS_SCRIPT);

        IntegerInputs integerInputs = new IntegerInputs(readTrimmedInput());
        return integerInputs.values();
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_SCRIPT);

        IntegerInput integerInput = new IntegerInput(readTrimmedInput());
        return integerInput.value();
    }

    private static String readTrimmedInput() {
        Input input = Input.readLine();
        return input.trimmed();
    }
}
