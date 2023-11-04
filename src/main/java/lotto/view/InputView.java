package lotto.view;

import lotto.utility.io.Reader;
import lotto.utility.io.Writer;
import lotto.utility.vo.PurchaseAmountRequest;

public class InputView {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";

    public PurchaseAmountRequest getPurchaseAmount() {
        Writer.println(PURCHASE_AMOUNT_REQUEST);
        return new PurchaseAmountRequest(Reader.readLine());
    }
}
