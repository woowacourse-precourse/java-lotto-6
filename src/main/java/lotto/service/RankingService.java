package lotto.service;

import java.util.List;
import lotto.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.MainNumbers;
import lotto.domain.Ranking;
import lotto.domain.RankingCounter;
import lotto.domain.WinningNumbers;
import lotto.dto.StatisticsResult;

public class RankingService {
    private final RankingCounter rankingCounter = new RankingCounter();
    private LottoService lottoService;
    private MainNumbers mainNumbers;
    private BonusNumber bonusNumber;
    private WinningNumbers winningNumbers;

    public void setLottoService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void initMainNumbers(List<Integer> mainNumbers) {
        this.mainNumbers = new MainNumbers(mainNumbers);
    }

    public void initBonusNumber(int bonus) {
        this.bonusNumber = new BonusNumber(this.mainNumbers.toList(), bonus);
    }

    public void initWinningNumbers() {
        this.winningNumbers = new WinningNumbers(this.mainNumbers, this.bonusNumber);
    }

    public void savePlayResult(Lotto lotto) {
        Ranking ranking = findRanking(lotto);
        if (ranking.name() != "NONE") {
            rankingCounter.addCount(ranking.name());
        }
    }

    public StatisticsResult getRankingResult() {
        return new StatisticsResult(rankingCounter.getCounter(), prizeMoney(), lottoService.getPayment());
    }

    private int prizeMoney() {
        return rankingCounter.getCounter().entrySet().stream()
                .mapToInt(entry -> Prize.valueOf(entry.getKey()).value() * entry.getValue()).sum();
    }

    private Ranking findRanking(Lotto lotto) {
        int nMatchingMainNumber = (int) lotto.countMatchingMainNumbers(winningNumbers);
        boolean isBonusMatched = lotto.isBonusMatched(winningNumbers);
        return Ranking.findFrom(nMatchingMainNumber, isBonusMatched);
    }
}
