package lotto.view.output;

import lotto.view.output.writer.Writer;

public class LottoPurchaseOutputView extends OutputView {
    private static final String STRING_INPUT_PURCHASING_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public LottoPurchaseOutputView(final Writer writer) {
        super(writer);
    }

    public void printInputPurchasingAmountMessage() {
        writer.println(STRING_INPUT_PURCHASING_AMOUNT_MESSAGE);
    }
}
