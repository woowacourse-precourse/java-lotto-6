package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.util.Validator;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readLottoPurchaseMoney() {
        outputView.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        Validator.validateIntFormat(amount);

        return Integer.parseInt(amount);
    }
}
