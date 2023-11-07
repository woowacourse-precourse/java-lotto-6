package lotto.domain.game;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningNumbers;
import lotto.domain.money.Money;
import lotto.domain.number.NumberUtil;
import lotto.global.constant.LottoRank;
import lotto.global.view.io.InputProcessor;
import lotto.global.view.output.OutputView;

import java.util.Map;

import static lotto.global.constant.message.BuyLottoMessage.BUY_LOTTO_MESSAGE;
import static lotto.global.constant.message.GameMessage.WINNING_STATISTIC;
import static lotto.global.constant.message.ProfitMessage.PROFIT_MESSAGE;

public class GameController {
    private Money money;
    private InputProcessor inputProcessor;
    private Lottos lottos;
    private LottoGame lottoGame;
    private NumberUtil numberUtil;
    private WinningNumbers winningNumbers;

    public GameController(InputProcessor inputProcessor,NumberUtil numberUtil, LottoGame lottoGame) {
        this.inputProcessor = inputProcessor;
        this.numberUtil = numberUtil;
        this.lottoGame = lottoGame;
    }

    public void play() {
        generateLottos();

        inputWinningResult();
        generateWinningResult();

    }

    private void generateLottos() {
        money = inputProcessor.inputMoney();

        lottos = new Lottos(money.getNumberOfTheLotto(), numberUtil);

        String lottoResult = lottos.generateLottosResult();
        long lottoCount = money.getNumberOfTheLotto();

        OutputView.printMessageLine(BUY_LOTTO_MESSAGE.makeMessage(lottoCount));
        OutputView.printMessageLine(lottoResult);
    }

    private void inputWinningResult() {
        winningNumbers = inputProcessor.inputWinningNumbers();
    }

    private void generateWinningResult() {
        Map<LottoRank, Integer> lottoResultsMap =  lottoGame.calculateLottoResults(lottos, winningNumbers);

        printWinningResult(lottoResultsMap);
        printProfitPercentage(money.getMoney(), lottoResultsMap);
    }

    private void printWinningResult(Map<LottoRank, Integer> lottoResultsMap) {
        String result = WinningResultGenerator.generateWinningResults(lottoResultsMap);
        OutputView.printMessageLine(WINNING_STATISTIC.getMessage());
        OutputView.printMessage(result);
    }

    private void printProfitPercentage(long money, Map<LottoRank, Integer> lottoResultsMap) {
        double profitRate = Profit.calculateProfit(money,lottoResultsMap);

        String profitMessage = PROFIT_MESSAGE.makeMessage(profitRate);

        OutputView.printMessageLine(profitMessage);
    }

}
