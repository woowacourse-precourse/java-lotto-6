package controller;

import domain.PrizeUtil;
import domain.PublishLottoUtil;
import domain.ScoreUtil;
import dto.Lotto;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final PublishLottoUtil publishLottoUtil;
    private final ScoreUtil scoreUtil;
    private final PrizeUtil prizeUtil;


    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
        publishLottoUtil = new PublishLottoUtil();
        scoreUtil = new ScoreUtil();
        prizeUtil = new PrizeUtil();
    }

    public void playLottoGame() {
        int lottoCnt = publishLottoUtil.buyLotto();
        List<Lotto> lottos = publishLottoUtil.publishLotto(lottoCnt);
        publishLottoUtil.showPublishedLotto(lottos);
        List<Integer> winningNumbers = inputView.enterWinningNumber();
        int bonusNumber = inputView.enterBonusNumber(winningNumbers);

        Map<Integer, Integer> lottoScore = scoreUtil.updateScore(lottos, bonusNumber, winningNumbers);
        outputView.showScore(lottoScore, ScoreUtil.hasFiveAndbonusNumber);
        outputView.showEarningRate(
                prizeUtil.calculateEarningRate(lottoCnt, lottoScore, ScoreUtil.hasFiveAndbonusNumber));
    }
}
