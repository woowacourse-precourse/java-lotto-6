package lotto.Controller;

import java.util.List;
import java.util.Map;
import lotto.Constants.MatchTypes;
import lotto.Model.LottoGroup;
import lotto.Model.LottoNumGenerator;
import lotto.Model.Portfolio;
import lotto.View.InputView;
import lotto.View.OutputView;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    LottoNumGenerator lottoNumGenerator = new LottoNumGenerator();
    Portfolio portfolio = new Portfolio();

    public void play() {
        Integer lotteryBudgetInput = inputView.lotteryBudgetInput();
        List<Integer> winningNum = inputView.winningNumInput();
        Integer bonusWinningNum = inputView.bonusWinningNumInput(winningNum);

        List<List<Integer>> lotteryNumbersGroup
                = lottoNumGenerator.generateLotteryNumbersGroup(lotteryBudgetInput);
        LottoGroup lottoGroup = new LottoGroup(lotteryNumbersGroup);
        Map<MatchTypes, Integer> gameResult = lottoGroup.drawLotto(winningNum, bonusWinningNum);
        Double turnOutRate = portfolio.calculateTurnOut(gameResult, lotteryBudgetInput);

        outputView.printHowManyLotteryBought(lotteryBudgetInput);
        outputView.printRegisteredLottery(lottoGroup.getLottoGroup());
        outputView.printGameResult(gameResult);
        outputView.printTurnOutRate(turnOutRate);
    }
}
