package lotto;

import java.math.BigDecimal;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoWinnerCounter;
import lotto.domain.Lottos;
import lotto.domain.generator.LottoGeneratorImpl;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.util.ExecuteUntilSuccess;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoService {

    public void start() {
        LottoBuyer lottoBuyer = getLottoCountFromPrompt();
        OutputView.printLottoBuySuccess(lottoBuyer.getLottoCount());
        Lottos lottos = generateLotto(lottoBuyer);
        printLottoResult(lottos);
        Lotto winnerNumber = getLottoWinnerFromPrompt();
        BonusNumber bonusNumber = getBonusNumberFromPromptWithWinningNumber(winnerNumber);
        LottoWinnerCounter lottoWinnerCounter = LottoWinnerCounter.generateLottoWinnerCounter();
        lottoWinnerCounter.calculateLottoResult(lottos, winnerNumber, bonusNumber);
        outputEntireLottoResult(lottoWinnerCounter, lottoBuyer);
    }

    private LottoBuyer getLottoCountFromPrompt() {
        return ExecuteUntilSuccess.execute(
                OutputView::printInputLottoBuyNumber,
                InputView::getBuyingLottoNumber,
                LottoBuyer::fromString);
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
        return ExecuteUntilSuccess.execute(
                OutputView::printInputWinnerLottoNumber,
                InputView::getBuyingLottoNumber,
                Lotto::fromString);
    }

    private BonusNumber getBonusNumberFromPromptWithWinningNumber(Lotto winnerNumber) {
        return ExecuteUntilSuccess.executeWithArgument(
                OutputView::printInputBonusNumber,
                InputView::getBonusLottorNumber,
                (input,number) -> BonusNumber.fromStringWitValidateWinningNumber(input, number),
                winnerNumber.getNumbers()
        );
    }

    private void outputEntireLottoResult(LottoWinnerCounter lottoWinnerCounter, LottoBuyer lottoBuyer) {
        BigDecimal profitRate = lottoWinnerCounter.totalProfit(lottoBuyer);
        OutputView.printLottoWinnerStatus();
        OutputView.printLottoResultLine();
        OutputView.printLottoWinnerTableResult(lottoWinnerCounter.getWinnerInformation());
        OutputView.printProfitRate(profitRate);
    }
}
