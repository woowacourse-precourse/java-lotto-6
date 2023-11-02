package lotto;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    public void LottoPlay(){
        messageService.inputPurchasePrice();
    }
}
