package lotto.view;

import lotto.utility.io.Reader;
import lotto.utility.io.Writer;
import lotto.vo.request.BonusNumberRequest;
import lotto.vo.request.PurchaseAmountRequest;
import lotto.vo.request.WinningNumberRequest;

public class InputView {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "\n보너스 번호를 입력해 주세요.";

    public PurchaseAmountRequest getPurchaseAmount() {
        Writer.println(PURCHASE_AMOUNT_REQUEST);
        return new PurchaseAmountRequest(Reader.readLine());
    }

    public WinningNumberRequest getWinningNumber() {
        Writer.println(WINNING_NUMBER_REQUEST);
        return new WinningNumberRequest(Reader.readLine());
    }

    public BonusNumberRequest getBonusNumber() {
        Writer.println(BONUS_NUMBER_REQUEST);
        return new BonusNumberRequest(Reader.readLine());
    }
}
