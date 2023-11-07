package lotto.Service;

import java.util.List;
import lotto.Util.InputNumberParser;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LotteryDrawerInputManagerService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputNumberParser inputNumberParser = new InputNumberParser();

    public List<Integer> inputLottoNumbers() {
        outputView.requestWinningNumbersForDrawer();
        return inputNumberParser.processLottoNumbers(inputView.playerLottoNumbersConsole());
    }

    public int inputBonusNumber() {
        outputView.requestBonusNumbersForDrawer();
        int bonusNumber = inputNumberParser.processBonusNumber(inputView.playerBonusNumberConsole());
        return bonusNumber;
    }
}
