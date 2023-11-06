package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.LottoMessage.INPUT_LOTTO_AMOUNT;

public class LottoInputView {
    private final LottoOutputView outputView;

    public LottoInputView(LottoOutputView outputView) {
        this.outputView = outputView;
    }

    public String readPurchaseAmount() {
        outputView.printMessage(INPUT_LOTTO_AMOUNT);
        return readLine();
    }

    public String readLine() {
        return Console.readLine();
    }
}
