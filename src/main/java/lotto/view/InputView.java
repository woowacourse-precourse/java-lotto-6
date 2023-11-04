package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final LottoInputView lottoInputView = new ConsoleLottoInputView();

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = lottoInputView.inputPurchaseAmount();
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = lottoInputView.inputWinningNumber();
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = lottoInputView.inputBonusNumber();
        return Integer.parseInt(bonusNumber);
    }
}
