package lotto.view;

import static lotto.constant.message.LottoMessage.INPUT_MONEY_MESSAGE;
import static lotto.constant.message.LottoMessage.INPUT_WINNING_NUMBER;
import static lotto.util.Parser.stringToList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    public List<Integer> readWinningNumbers() {
        outputView.printMessage(INPUT_WINNING_NUMBER);
        return stringToList(Console.readLine());
    }

}
