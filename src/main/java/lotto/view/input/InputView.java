package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.view.input.validator.ReadAmountValidator;
import lotto.view.input.validator.ReadBonusValidator;
import lotto.view.input.validator.ReadWinningValidator;
import lotto.view.output.OutputView;

public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }

    public int readAmount() {
        outputView.printReadAmountMessage();
        return ReadAmountValidator.validateAmount(readLine());
    }

    public List<Integer> readWinningNumbers() {
        outputView.printReadWinningLottoMessage();
        return ReadWinningValidator.validateWinning(readLine());
    }

    public int readBonus() {
        outputView.printReadBonusNumberMessage();
        return ReadBonusValidator.validateBonus(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }
}
