package lotto.model;

public class ClientInform {
    // 사용자의 구매 금액과 로또 수익금 저장객체
    private static final Integer ZERO = 0;
    private PurchaseAmount purchaseAmount;
    private LottoWinningAmount lottoWinningAmount;

    private ClientInform(int purchaseAmount) throws IllegalArgumentException {
        this.purchaseAmount = PurchaseAmount.getInstance(purchaseAmount);
        this.lottoWinningAmount = LottoWinningAmount.getInstance(ZERO);
    }

    public static ClientInform getInstance(int purchaseAmount) throws IllegalArgumentException {
        return new ClientInform(purchaseAmount);
    }

    public int getLottoNum() {
        return purchaseAmount.getLottoNum();
    }
}
