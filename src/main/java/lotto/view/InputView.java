package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.parser.BonusAndPaymentInputParser;
import lotto.util.parser.InputParser;
import lotto.util.parser.WinningNumbersInputParser;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    OutputView outputView = OutputView.getInstance();
    InputParser bonusAndPaymentParser = new BonusAndPaymentInputParser();
    InputParser winningParser = new WinningNumbersInputParser();

    private InputView() {

    }

    public static InputView getInstance() {
        return INSTANCE;
    }

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
