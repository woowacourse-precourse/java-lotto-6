package lotto.view;

import java.util.List;
import lotto.utils.GameUtils;
import lotto.view.reader.Reader;
import lotto.view.validator.BonusNumberInputValidator;
import lotto.view.validator.PurchaseAmountInputValidator;
import lotto.view.validator.WinningNumberInputValidator;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public int readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String purchaseAmountInput = reader.readLine();
        PurchaseAmountInputValidator.validate(purchaseAmountInput);
        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String winningNumbersInput = reader.readLine();
        WinningNumberInputValidator.validate(winningNumbersInput);
        return GameUtils.parse(winningNumbersInput);
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = reader.readLine();
        BonusNumberInputValidator.validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
