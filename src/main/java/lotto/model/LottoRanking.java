package lotto.model;

public class LottoRanking {
    private final LottoBucket lottoBucket;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoRanking(LottoBucket lottoBucket, Lotto winningLotto, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.winningLotto = winningLotto;
        this.lottoBucket = lottoBucket;
    }
}
