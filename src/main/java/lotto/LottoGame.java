package lotto;
import lotto.domain.LottoPurchase;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private LottoPurchase lottoPurchase = new LottoPurchase();
    public void LottoPlay() {
        messageService.inputPurchasePrice();
        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        messageService.outputPurchaseAmount(purchaseAmount);
        lottoPurchase.purchaseLottoNumbers(purchaseAmount);

    }



}
