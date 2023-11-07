package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.repository.LottoRepository;
import lotto.util.Util;
import lotto.util.enumerator.LottoRank;

public class WinningLotto {
    private static final int MATCH_FIVE = 5;

    private final WinningNumber winning;
    private final BonusNumber bonus;

    public WinningLotto(WinningNumber winning, BonusNumber bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public WinningNumber getWinning() {
        return winning;
    }

    public BonusNumber getBonus() {
        return bonus;
    }

    public List<LottoRank> compare() {
        return LottoRepository.lotties().stream()
                .map(lotto -> compareLottoRank(compareWithOneLotto(lotto), lotto))
                .collect(Collectors.toList());
    }

    private LottoRank compareLottoRank(int match, Lotto lotto) {
        if (Util.isEqual(match, MATCH_FIVE)) {
            return compareWithBonusNumber(lotto);
        }
        return LottoRank.findLottoRankByMatch(match);
    }

    private int compareWithOneLotto(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this::isMatch)
                .count();
    }

    private boolean isMatch(int number) {
        return this.winning.getNumbers().stream()
                .anyMatch(winning -> Util.isEqual(number, winning));
    }

    private LottoRank compareWithBonusNumber(Lotto lotto) {
        return this.bonus.compareWithLottoNumber(lotto);
    }
}
