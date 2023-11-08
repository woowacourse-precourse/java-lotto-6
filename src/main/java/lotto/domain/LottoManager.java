package lotto.domain;

import static lotto.constants.ExceptionMessage.DUPPLICATE_BONUS_AND_WINNER;

import java.util.ArrayList;
import java.util.HashMap;
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
            throw new IllegalArgumentException(DUPPLICATE_BONUS_AND_WINNER);
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

    public HashMap<LottoRank, Integer> totalCountPerRank(final List<LottoRank> matchs) {
        HashMap<LottoRank, Integer> rankCount = new HashMap<>();
        for (LottoRank match : matchs) {
            if (match == LottoRank.NOTHING) {
                continue;
            }
            int count = 0;
            if (rankCount.containsKey(match)) {
                count = rankCount.get(match);
            }
            rankCount.put(match, count + 1);
        }
        return rankCount;
    }

    public AutoLottos getAutoLottos() {
        return autoLottos;
    }

    public int getLottoCount() {
        return lottoCount;
    }

}
