package lotto.domain;

import lotto.domain.lotto.*;
import lotto.domain.lotto.dto.BonusNumberDto;
import lotto.domain.lotto.dto.MoneyDto;
import lotto.domain.lotto.dto.WinningNormalNumberDto;
import lotto.global.converter.NumberConverter;
import lotto.global.constant.message.GameMessage;
import lotto.global.constant.LottoRank;
import lotto.global.view.InputView;
import lotto.global.view.OutputView;

import java.util.Map;

import static lotto.global.constant.message.BuyLottoMessage.BUY_LOTTO_MESSAGE;
import static lotto.global.constant.message.GameMessage.WINNING_STATISTIC;
import static lotto.global.constant.message.ProfitMessage.PROFIT_MESSAGE;

public class GameController {
    private Money money;
    private Lottos lottos;
    private LottoGame lottoGame;
    private Profit profit;
    private WinningNumbers winningNumbers;

    public GameController() {
        this.profit = new Profit();
        this.winningNumbers = new WinningNumbers();
    }

    public void play() {
        inputMoney();
        generateLottos();

        Map<LottoRank, Integer> lottoResultsMap = generateWinningResult();

        printWinningResult(lottoResultsMap);
        printProfitPercentage(money.getMoney(), lottoResultsMap);

    }

    private void inputMoney() {
        OutputView.printMessageLine(GameMessage.INPUT_MONEY.getMessage());
        MoneyDto moneyDto = new MoneyDto(InputView.input());

        int inputMoney = NumberConverter.convertToNumber(moneyDto.money());
        money = new Money(inputMoney);
    }

    private void generateLottos() {
        lottos = new Lottos(money.getNumberOfTheLotto(), new NumberGenerator());
        String lottoResult = lottos.generateLottosResult();

        int lottoCount = money.getNumberOfTheLotto();

        OutputView.printMessageLine(BUY_LOTTO_MESSAGE.makeMessage(lottoCount));
        OutputView.printMessageLine(lottoResult);
    }

    private Map<LottoRank, Integer> generateWinningResult() {
        OutputView.printMessageLine(GameMessage.INPUT_WINNING_NUMBERS.getMessage());
        WinningNormalNumberDto winningNormalNumberDto = new WinningNormalNumberDto(InputView.input());

        OutputView.printMessageLine(GameMessage.INPUT_BONUS_NUMBERS.getMessage());
        BonusNumberDto bonusNumberDto = new BonusNumberDto(InputView.input());

        lottoGame = new LottoGame(lottos, winningNumbers);
        lottoGame.generateWinningNumbers(winningNormalNumberDto.inputNumbers(), bonusNumberDto.number());

        return lottoGame.calculateLottoResults();
    }

    private void printWinningResult(Map<LottoRank, Integer> lottoResultsMap) {
        String result = WinningResultGenerator.generateWinningResults(lottoResultsMap);
        OutputView.printMessageLine(WINNING_STATISTIC.getMessage());
        OutputView.printMessage(result);
    }

    private void printProfitPercentage(int money, Map<LottoRank, Integer> lottoResultsMap) {
        double profitRate = profit.calculateProfit(money,lottoResultsMap);

        String profitMessage = PROFIT_MESSAGE.makeMessage(profitRate);

        OutputView.printMessageLine(profitMessage);
    }

}
