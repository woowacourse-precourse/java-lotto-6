package lotto.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final LottoInputView lottoInputView = new ConsoleLottoInputView();

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                String purchaseAmount = lottoInputView.inputPurchaseAmount();

                validate(purchaseAmount);

                return Integer.parseInt(purchaseAmount);
            }catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자형식으로 입력해주세요.");
            }catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static void validate(String purchaseAmount) {
        int purchase = Integer.parseInt(purchaseAmount);

        if (purchase%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000단위로 입력해야 합니다.");
        }

        if (purchase < 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 0보다 커야 합니다.");
        }
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
