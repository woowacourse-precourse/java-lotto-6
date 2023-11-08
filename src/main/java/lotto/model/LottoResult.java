package lotto.model;

public class LottoResult {
    private final WinningNumber winningNumber;
    private final Lottos lottos;
    private final BonusNumber bonusNumber;
    private final Rank rank = new Rank();

    public LottoResult(WinningNumber winningNumber, Lottos lottos, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
    }


}
