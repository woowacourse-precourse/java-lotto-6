package lotto.domain.entity;

public class User {

    public static final int PRICE_PER_LOTTO = 1000;
    private final Lottos lottos;
    private final Long purchasePrice;

    public User(final Lottos lottos, final Long purchasePrice) {
        this.lottos = lottos;
        this.purchasePrice = purchasePrice;
    }

    public static Long calculatePurchaseAmount(final Long purchasePrice) {
        return purchasePrice / PRICE_PER_LOTTO;
    }

    public float calculateEarningRate(final long totalPrize) {
        if (purchasePrice == 0) {
            return purchasePrice;
        }
        return (float) (totalPrize * 100) / this.purchasePrice;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
