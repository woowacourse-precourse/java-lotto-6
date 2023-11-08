package lotto.service;

import static lotto.view.OutputView.printResultsSummary;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.LottoRanks;
import lotto.domain.MatchingResults;
import lotto.domain.RankingResult;
import lotto.domain.WinningLotto;
import lotto.domain.enums.WinningGrade;

public class StatisticsService {

    public RankingResult receiveGameResult(final Lotteries lotteries, final WinningLotto winningLotto) {
        final MatchingResults matchingResults = lotteries.generateMatchingResults(winningLotto);
        final List<WinningGrade> winningGrades = matchingResults.receiveWinningGrades();
        final LottoRanks lottoRanks = LottoRanks.from(winningGrades);
        final RankingResult rankingResult = lottoRanks.receiveRankingResult();

        printResultsSummary(rankingResult);

        return rankingResult;
    }
}
