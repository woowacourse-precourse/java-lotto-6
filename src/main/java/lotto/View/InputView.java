package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputLottoAmount() {
        OutputView.printLottoPurchaseAmountMessage();
        return Console.readLine();
    }

    public static String inputWinningLottoNumbers() {
        OutputView.printEnterWinningNumber();
        return Console.readLine();
    }
}
