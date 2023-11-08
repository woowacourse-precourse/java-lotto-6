package lotto.view;

import static lotto.constant.message.LottoMessage.INPUT_MONEY_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readLottoPurchaseMoney() {
        outputView.printMessage(INPUT_MONEY_MESSAGE);
        String money = Console.readLine();

        return Integer.parseInt(money);
    }

}
