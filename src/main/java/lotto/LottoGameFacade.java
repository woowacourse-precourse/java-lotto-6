package lotto;

import static lotto.domain.util.LottoParser.parseBonusNumber;
import static lotto.domain.util.LottoParser.parseLottoToInteger;
import static lotto.domain.util.LottoParser.parseMoney;
import static lotto.domain.util.LottoParser.parseWinningNumbers;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.exception.InputException;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameFacade {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameFacade(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void showGeneratedLottos(List<Lotto> lottos) {
        outputView.printLottoNumbers(parseLottoToInteger(lottos));
    }

    public int receiveValidMoney() {
        while (true) {
            outputView.printInputMoneyMessage();
            try {
                String money = inputView.inputMoney();
                return parseMoney(money);
            } catch (InputException | LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public List<Integer> receiveValidWinningNumbers() {
        while (true) {
            outputView.printInputWinningNumbersMessage();
            try {
                String winningNumbers = inputView.inputWinningNumber();
                return parseWinningNumbers(winningNumbers);
            } catch (InputException | LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public int receiveValidBonusNumber() {
        while (true) {
            outputView.printInputBonusNumberMessage();
            try {
                String bonusNumber = inputView.inputBonusNumber();
                return parseBonusNumber(bonusNumber);
            } catch (InputException | LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public void showResult(Map<LottoRank, Integer> rankCount) {
        outputView.printRanksCount(rankCount);
        outputView.printRateOfProfits(rankCount);
    }
}
