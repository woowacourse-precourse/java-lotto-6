package lotto;
import java.util.List;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumbers;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private LottoPurchase lottoPurchase = new LottoPurchase();
    private LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
    public void LottoPlay() {
        messageService.inputPurchasePrice();
        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        messageService.outputPurchaseAmount(purchaseAmount);
        lottoPurchase.purchaseLottoNumbers(purchaseAmount);
        messageService.inputWinningNumberMessage();
        List<Integer> winningNumbers = lottoWinningNumbers.inputWinningNumbers();
        for(int i = 0; i < winningNumbers.size(); i++){
            System.out.print(winningNumbers.get(i));
        }
    }



}
