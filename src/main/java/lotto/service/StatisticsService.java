package lotto.service;

import static lotto.view.OutputView.printResultsProfitability;
import static lotto.view.OutputView.printResultsSummary;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.LottoRanks;
import lotto.domain.MatchingResults;
import lotto.domain.Payment;
import lotto.domain.RankingResult;
import lotto.domain.WinningLotto;
import lotto.domain.enums.WinningGrade;

public class StatisticsService {

    public void receiveGameResult(
            final Payment payment, final Lotteries lotteries, final WinningLotto winningLotto) {
        
        final MatchingResults matchingResults = lotteries.generateMatchingResults(winningLotto);
        final List<WinningGrade> winningGrades = matchingResults.receiveWinningGrades();
        final LottoRanks lottoRanks = LottoRanks.from(winningGrades);
        final RankingResult rankingResult = lottoRanks.generateLottoRanksResult();

        printResultsSummary(rankingResult);

        final BigDecimal profitability = rankingResult.receiveProfitability(payment);
        printResultsProfitability(profitability);
    }
}
