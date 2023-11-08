package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.message.LottoMessage;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readLottoPurchaseMoney() {
        outputView.printMessage(LottoMessage.INPUT_MONEY);
        String money = Console.readLine();

        return Integer.parseInt(money);
    }

}
