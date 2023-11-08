package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final AutoLottos autoLottos = new AutoLottos();
    private WinningLotto winningLotto;
    private Bonus bonus;
    private Generator generator;
    private int lottoCount;

    private LottoManager(final Generator generator) {
        this.generator = generator;
    }

    public static LottoManager from(final Generator generator) {
        return new LottoManager(generator);
    }

    public void createWinning(final WinningLotto winnings, final Bonus bonusNumber) {
        if (Bonus.isSameNumber(winnings.getLotto(), bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
        }
        winningLotto = winnings;
        bonus = bonusNumber;
    }

    public void buyAutoLottos(final int lottoCount) {
        this.lottoCount = lottoCount;
        autoLottos.createAutoLottos(lottoCount, generator);
    }

    public List<LottoRank> judgeRankByLotto() {
        List<LottoRank> matchs = new ArrayList<>();
        for (Lotto given : autoLottos.getLottos()) {
            matchs.add(matchRank(given));
        }
        return matchs;
    }

    private LottoRank matchRank(final Lotto given) {
        int matchCount = Lotto.matchCount(given, winningLotto.getLotto());
        boolean bonusMatch = Bonus.isSameNumber(given.getLotto(), bonus);
        return LottoRank.findRankByMatchCountAndBonus(matchCount, bonusMatch);
    }

    private int countLottoRank(final List<LottoRank> matcheNumbers, final LottoRank match) {
        return (int) matcheNumbers.stream().filter(m -> m.getMatchNumber() == match.getMatchNumber()).count();
    }

    public List<Integer> totalCountPerRank(final List<LottoRank> matchs) {
        List<Integer> count = new ArrayList<>();
        for (LottoRank match : LottoRank.getMembers()) {
            count.add(countLottoRank(matchs, match));
        }
        return count;
    }

    public AutoLottos getAutoLottos() {
        return autoLottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
