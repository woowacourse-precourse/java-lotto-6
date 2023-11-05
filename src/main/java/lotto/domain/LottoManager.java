package lotto.domain;

import java.util.List;

public class LottoManager {
    private AutoLottos autoLottos;
    private WinningLotto winningLotto;
    private Bonus bonus;
    private Generator generator;
    private int lottoCount;

    private LottoManager(Generator generator) {
        this.generator = generator;
    }

    public static LottoManager from(Generator generator) {
        return new LottoManager(generator);
    }

    private void buyAutoLottos(int lottoCount) {
        autoLottos = AutoLottos.from();
        autoLottos.createAutoLottos(lottoCount, generator);
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos.getLottos();
    }

    public void createWinning(List<Integer> winningNumber, int bonusNumber) {
        winningLotto = WinningLotto.createWinningLottos(winningNumber);
        bonus = Bonus.from(bonusNumber);
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getLotto();
    }

    public int getBonus() {
        return bonus.getBonus();
    }

    private MatchNumber matchNumber(Lotto given, Lotto winnings) {
        int matchCount = Lotto.matchCount(given, winnings);
        boolean bonusMatch = Bonus.isSameNumber(given, bonus);
        return MatchNumber.findByMatchCountAndBonus(matchCount, bonusMatch);
    }

}
