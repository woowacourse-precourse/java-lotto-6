package lotto.controller;

import static lotto.view.OutputView.printResultsProfitability;
import static lotto.view.OutputView.printResultsSummary;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.LottoRanks;
import lotto.domain.MatchingResults;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.domain.constants.WinningGrade;
import lotto.domain.RankingResult;

public class StatisticsController {

    public void receiveGameResult(Payment payment, Lotteries lotteries, WinningLotto winningLotto) {
        MatchingResults gameResults = lotteries.generateGameResult(winningLotto);
        List<WinningGrade> winningGrades = gameResults.receiveLottoRanks();
        LottoRanks lottoRanks = LottoRanks.from(winningGrades);
        RankingResult rankingResult = lottoRanks.generateLottoRanksResult();

        printResultsSummary(rankingResult);

        // TODO: 수익률 계산
        // double profitability = lottoRanks.receiveProfitability(payment);
        // printResultsProfitability(profitability);
    }
}
