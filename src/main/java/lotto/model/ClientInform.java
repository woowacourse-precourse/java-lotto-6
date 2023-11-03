package lotto.model;

public class ClientInform {
    // 사용자의 구매 금액과 로또 수익금 저장객체
    private PurchaseAmount purchaseAmount;
    private LottoWinningAmount lottoWinningAmount;

    private ClientInform(int purchaseAmount, int lottoWinningAmount) {
        this.purchaseAmount = PurchaseAmount.getInstance(purchaseAmount);
        this.lottoWinningAmount = LottoWinningAmount.getInstance(lottoWinningAmount);
    }

    public static ClientInform getInstance(int purchaseAmount, int lottoWinningAmount) {
        return new ClientInform(purchaseAmount, lottoWinningAmount);
    }
}
