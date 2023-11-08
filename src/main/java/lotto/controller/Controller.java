package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.model.Answer;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGame lottoGame = new LottoGame();
    Answer answerNumber;
    public void run() {
        beforeLottoGame();
        startLottoGame();
        showGameResult();
    }
    private void beforeLottoGame() {
        int lottoNum = inputView.moneyInput();
        lottoGame.createLotto(lottoNum);
        List<Lotto> lottoGames = lottoGame.getLottoGames();
        outputView.showLottoNum(lottoNum,lottoGames);

        List<Integer> answer =inputView.answerInput();
        int bonus = inputView.bonusInput();
        answerNumber = new Answer(answer,bonus);
    }

    private void startLottoGame() {
        prize.compareAnswerAndLotto(answerNumber, lottoGame);
        prize.calculateTotalPrizeMoney();
        int num = lottoGame.getLottoNumber();
        prize.calculateProfit(money);
    }

    private void showGameResult() {
        Map<Rank, Integer> prizeResult = prize.getPrizeResult();
        Set<Rank> keySet = prizeResult.keySet();
        long totalPrize = prize.getTotalPrizeMoney();
        outputView.resultStatistics();
        double profit = prize.getProfit();
        for (Rank key : keySet) {
            String lottoPrize = key.getConvertPrize();
            int count = key.getCount();
            int lottoNum = prizeResult.get(key);

            if (key == Rank.SECOND && count > 0) {
                outputView.showBonusResult(count, lottoPrize, lottoNum);
            }

            if (count > 2) {
                outputView.showLottoGameResult(count, lottoPrize, lottoNum);
            }
        }
        outputView.showProfitResult(profit);
    }


}
