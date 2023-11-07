package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.parser.BonusAndPaymentInputParser;
import lotto.util.parser.InputParser;
import lotto.util.parser.WinningNumbersInputParser;

public class InputView {

    OutputView outputView = new OutputView();
    InputParser bonusAndPaymentParser = new BonusAndPaymentInputParser();
    InputParser winningParser = new WinningNumbersInputParser();

    public int readPaymentInput() {
        outputView.paymentPrompt();
        return bonusAndPaymentParser.parse(Console.readLine()).get(0);
    }

    public int readBonusInput() {
        outputView.bonusPrompt();
        return bonusAndPaymentParser.parse(Console.readLine()).get(0);
    }

    public List<Integer> readWinningNumber() {
        outputView.winningNumberPrompt();
        return winningParser.parse(Console.readLine());
    }

}
