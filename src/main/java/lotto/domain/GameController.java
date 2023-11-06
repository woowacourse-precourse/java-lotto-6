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
    private NumberUtil numberUtil;
    private WinningNumbers winningNumbers;

    public GameController(Profit profit,NumberUtil numberUtil, WinningNumbers winningNumbers) {
        this.profit = profit;
        this.numberUtil = numberUtil;
        this.winningNumbers = winningNumbers;
    }

    public void play() {
        inputMoney();
        generateLottos();

        inputWinningResult();
        generateWinningResult();

    }

    private void inputMoney() {
        int retry = 1;
        while (retry-- > 0) {
            try {
                OutputView.printMessageLine(GameMessage.INPUT_MONEY.getMessage());
                long inputMoney = InputView.inputInteger();
                money = new Money(inputMoney);
                return;
            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }

    private void generateLottos() {
        lottos = new Lottos(money.getNumberOfTheLotto(), numberUtil);

        String lottoResult = lottos.generateLottosResult();
        long lottoCount = money.getNumberOfTheLotto();

        OutputView.printMessageLine(BUY_LOTTO_MESSAGE.makeMessage(lottoCount));
        OutputView.printMessageLine(lottoResult);
    }

    private void inputWinningResult() {
        String winningNormalNumbers = inputWinningNormalNumbers().inputNumbers();
        String bonusNumber = inputBonusNumber().number();

        winningNumbers.generateWinningNormalNumbers(winningNormalNumbers);
        winningNumbers.generateBonusNumber(bonusNumber);
    }


    private WinningNormalNumberDto inputWinningNormalNumbers() {
        int retry = 5;
        while(retry-- > 0) {
            try{
                OutputView.printMessageLine(GameMessage.INPUT_WINNING_NUMBERS.getMessage());
                return new WinningNormalNumberDto(InputView.input());

            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }

    private BonusNumberDto inputBonusNumber() {
        int retry = 5;
        while (retry-- > 0) {
            try {
                OutputView.printMessageLine(GameMessage.INPUT_BONUS_NUMBERS.getMessage());
                return new BonusNumberDto(InputView.input());
            } catch (Exception e) {
                OutputView.printMessageLine("[ERROR]" + e.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 입력 횟수 5번 초과");
    }



    private void generateWinningResult() {
        lottoGame = new LottoGame(lottos, winningNumbers);
        Map<LottoRank, Integer> lottoResultsMap =  lottoGame.calculateLottoResults();

        printWinningResult(lottoResultsMap);
        printProfitPercentage(money.getMoney(), lottoResultsMap);
    }

    private void printWinningResult(Map<LottoRank, Integer> lottoResultsMap) {
        String result = WinningResultGenerator.generateWinningResults(lottoResultsMap);
        OutputView.printMessageLine(WINNING_STATISTIC.getMessage());
        OutputView.printMessage(result);
    }

    private void printProfitPercentage(long money, Map<LottoRank, Integer> lottoResultsMap) {
        double profitRate = profit.calculateProfit(money,lottoResultsMap);

        String profitMessage = PROFIT_MESSAGE.makeMessage(profitRate);

        OutputView.printMessageLine(profitMessage);
    }

}
