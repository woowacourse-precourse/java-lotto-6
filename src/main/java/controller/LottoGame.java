package controller;

import domain.PublishLottoUtil;
import domain.ScoreUtil;
import dto.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final PublishLottoUtil publishLottoUtil;
    private final ScoreUtil scoreUtil;


    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
        publishLottoUtil = new PublishLottoUtil();
        scoreUtil = new ScoreUtil();
    }

    public void playLottoGame() {
        int lottoCnt = publishLottoUtil.buyLotto();
        List<Lotto> lottos = publishLottoUtil.publishLotto(lottoCnt);
        publishLottoUtil.showPublishedLotto(lottos);
        String getWinningNumbers = inputView.enterWinningNumber();
        int bonusNumber = inputView.enterBonusNumber();
        List<Integer> winningNumbers = Arrays.stream(getWinningNumbers.split(",")).map(Integer::parseInt).toList();
        Map<Integer, Integer> lottoScore = scoreUtil.updateScore(lottoCnt, lottos, bonusNumber, winningNumbers);
        outputView.showScore(lottoScore, ScoreUtil.hasFiveAndbonusNumber);
    }
}
