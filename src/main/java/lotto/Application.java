package lotto;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);

        int purchaseAmount = lottoPurchase.requestPurchaseAmount();
        lottoMachine.printLottoTickets(lottoMachine.issueLottoTickets(purchaseAmount));

    }
}
