package lotto.view.input;

import lotto.util.StringParser;
import java.util.List;

public final class InputView {
    private static final LottoInputView lottoInputView = new ConsoleLottoInputView();

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        do {
            try {
                String purchaseAmount = lottoInputView.inputPurchaseAmount();

                int purchasePrice = InputValidator.validateNumericFormat(purchaseAmount);
                InputValidator.validateLottoPrice(purchasePrice);
                InputValidator.validateNonNegativeNumber(purchasePrice);

                return purchasePrice;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumber = lottoInputView.inputWinningNumber();

        InputValidator.validateWinningNumberFormat(winningNumber);

        return StringParser.split(winningNumber);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumber = lottoInputView.inputBonusNumber();

        return InputValidator.validateNumericFormat(bonusNumber);
    }
}
