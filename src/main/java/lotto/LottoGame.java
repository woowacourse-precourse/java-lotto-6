package lotto;
import lotto.service.InputService;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private final InputService inputService = new InputService();
    public void LottoPlay(){
        messageService.inputPurchasePrice();
        System.out.println(Integer.parseInt(inputService.inputValue()));

    }
}
