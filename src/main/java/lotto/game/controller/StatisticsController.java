package lotto.game.controller;

import java.util.List;
import lotto.domain.Statistics;
import lotto.domain.Wallet;
import lotto.domain.WinnerNumbers;
import lotto.service.JudgeService;
import lotto.vo.Result;

public class StatisticsController {

    private final JudgeService judgeService;

    public StatisticsController(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    public Statistics make(Wallet wallet, WinnerNumbers winnerLotto) {
        List<Result> results = judgeService.compareLottoBundleAndWinnerNumbers(wallet, winnerLotto);
        return new Statistics(results);
    }
}
