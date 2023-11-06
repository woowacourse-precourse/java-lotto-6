package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private AutoLottos autoLottos;
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

    public void buyAutoLottos(final int lottoCount) {
        autoLottos = AutoLottos.from();
        this.lottoCount = lottoCount;
        autoLottos.createAutoLottos(lottoCount, generator);
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos.getLottos();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void createWinning(final WinningLotto winnings, final Bonus bonusNumber) {
        winningLotto = winnings;
        bonus = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getLotto();
    }

    public int getBonus() {
        return bonus.getBonus();
    }

    public List<Integer> totalMatchNumber(final List<MatchNumber> matchs) {
        List<Integer> count = new ArrayList<>();
        for (MatchNumber match : MatchNumber.getMembers()) {
            count.add(countMatchNumber(matchs, match));
        }
        return count;
    }

    public List<MatchNumber> judgeMatchNumberByLotto() {
        List<MatchNumber> matchs = new ArrayList<>();
        for (Lotto given : autoLottos.getLottos()) {
            matchs.add(matchNumber(given));
        }
        return matchs;
    }

    private MatchNumber matchNumber(final Lotto given) {
        int matchCount = Lotto.matchCount(given, winningLotto.getLotto());
        boolean bonusMatch = Bonus.isSameNumber(given, bonus);
        return MatchNumber.findByMatchCountAndBonus(matchCount, bonusMatch);
    }

    private static int countMatchNumber(final List<MatchNumber> matcheNumbers, final MatchNumber match) {
        return (int) matcheNumbers.stream().filter(m -> m.getMatchNumber() == match.getMatchNumber()).count();
    }


}
