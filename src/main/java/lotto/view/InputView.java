package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final LottoInputView lottoInputView = new ConsoleLottoInputView();

    public static int inputPurchaseAmount() {
        String purchaseAmount = lottoInputView.inputPurchaseAmount();
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumber() {
        String winningNumber = lottoInputView.inputWinningNumber();
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        String bonusNumber = lottoInputView.inputBonusNumber();
        return Integer.parseInt(bonusNumber);
    }
}
