package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.RankingCounter;
import lotto.domain.WinningNumbers;
import lotto.dto.StatisticsResult;

public class RankingService {
    private final RankingCounter rankingCounter = new RankingCounter();
    private final WinningNumbers winningNumbers = new WinningNumbers();
    private LottoService lottoService;

    public void setLottoService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void initMainNumbers(List<Integer> mainNumbers) {
        winningNumbers.setMainNumbers(mainNumbers);
    }

    public void initBonusNumber(int bonus) {
        winningNumbers.setBonusNumber(bonus);
    }

    public void savePlayResult(Lotto lotto) {
        Ranking ranking = findRanking(lotto);
        rankingCounter.addCount(ranking);
    }

    public StatisticsResult getRankingResult() {
        return new StatisticsResult(rankingCounter.getCounter(),
                rankingCounter.getPrizeMoney() / (double) lottoService.getPayment());
    }

    private Ranking findRanking(Lotto lotto) {
        int nMatchingMainNumber = (int) lotto.countMatchingMainNumbers(winningNumbers);
        boolean isBonusMatched = lotto.hasBonusNumber(winningNumbers);
        return Ranking.findFrom(nMatchingMainNumber, isBonusMatched);
    }
}
