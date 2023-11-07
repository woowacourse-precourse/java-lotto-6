package lotto.model.lottoResultChecker;


public class LottoRankChecker {

    public LottoRank determineRank(Lotto lotto, Lotto winningLotto, LottoBonus bonus) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(bonus.getBonusNumber());

        return LottoRank.findRank(matchCount, matchBonus);
    }
}
