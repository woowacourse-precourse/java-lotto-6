package lotto;
import lotto.domain.LottoPurchase;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    public void LottoPlay(){
        messageService.inputPurchasePrice();
        messageService.outputPurchaseAmount(lottoPurchase.getPurchaseAmount());
    }
}
