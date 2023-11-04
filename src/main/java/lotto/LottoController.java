package lotto;

public class LottoController {

    public void run(){
        View.requestPurchaseAmount();
        PurchaseAmount purchaseAmount = PurchaseAmount.from(InputService.purchaseAmount());
    }
}
