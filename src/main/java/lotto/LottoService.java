package lotto;

import java.math.BigDecimal;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoWinnerCounter;
import lotto.domain.Lottos;
import lotto.domain.generator.LottoGeneratorImpl;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoService {

    public void start() {
        LottoBuyer lottoBuyer = getLottoCountFromPrompt();
        OutputView.printLottoBuySuccess(lottoBuyer.getLottoCount());
        Lottos lottos = generateLotto(lottoBuyer);
        printLottoResult(lottos);
        Lotto winnerNumber = getLottoWinnerFromPrompt();
        BonusNumber bonusNumber = getBonusNumberFromPromptWiteWinningNumber(winnerNumber);
        LottoWinnerCounter lottoWinnerCounter = LottoWinnerCounter.generateLottoWinnerCounter();
        lottoWinnerCounter.calculateLottoResult(lottos, winnerNumber, bonusNumber);
        outputEntireLottoResult(lottoWinnerCounter, lottoBuyer);
    }

    private LottoBuyer getLottoCountFromPrompt() {
        boolean untilValid = true;
        LottoBuyer result = null;
        while (untilValid) {
            try {
                OutputView.printInputLottoBuyNumber();
                result = LottoBuyer.fromString(InputView.getBuyingLottoNumber());
                untilValid = false;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        OutputView.printNewLine();
        return result;
    }

    private void printLottoResult(Lottos lottos) {
        lottos.getLottos().stream().map(Lotto::getNumbers)
                .forEach(OutputView::printGeneratedLottoNumber);
        OutputView.printNewLine();
    }

    private Lottos generateLotto(LottoBuyer lottoBuyer) {
        LottoGeneratorImpl lottoGenerator = new RandomLottoGenerator();
        return Lottos.fromCount(lottoBuyer.getLottoCount(), lottoGenerator);
    }

    private Lotto getLottoWinnerFromPrompt() {
        boolean untilValid = true;
        Lotto result = null;
        while (untilValid) {
            try {
                OutputView.printInputWinnerLottoNumber();
                result = Lotto.fromString(InputView.getBuyingLottoNumber());
                untilValid = false;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        OutputView.printNewLine();
        return result;
    }

    private BonusNumber getBonusNumberFromPromptWiteWinningNumber(Lotto winnerNumber) {
        boolean untilValid = true;
        BonusNumber result = null;
        while (untilValid) {
            try {
                OutputView.printInputBonusNumber();
                result = BonusNumber.fromStringWitValidateWinningNumber(InputView.getBonusLottorNumber(),
                        winnerNumber.getNumbers());
                untilValid = false;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        OutputView.printNewLine();
        return result;
    }

    private void outputEntireLottoResult(LottoWinnerCounter lottoWinnerCounter, LottoBuyer lottoBuyer) {
        BigDecimal profitRate = lottoWinnerCounter.totalProfit(lottoBuyer);
        OutputView.printLottoWinnerStatus();
        OutputView.printLottoResultLine();
        OutputView.printLottoWinnerTableResult(lottoWinnerCounter.getWinnerInformation());
        OutputView.printProfitRate(profitRate);
    }
}
