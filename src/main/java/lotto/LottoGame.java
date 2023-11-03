package lotto;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumbers;
import lotto.service.MessageService;
public class LottoGame {
    private final MessageService messageService = new MessageService();
    private LottoPurchase lottoPurchase = new LottoPurchase();
    private LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();
    private BonusNumber bonusNumber = new BonusNumber();
    public void LottoPlay() {
        messageService.inputPurchasePrice();
        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        messageService.outputPurchaseAmount(purchaseAmount);
        lottoPurchase.purchaseLottoNumbers(purchaseAmount);
        messageService.inputWinningNumberMessage();
        List<Integer> winningNumbers = lottoWinningNumbers.inputWinningNumbers();
        messageService.inputBonusNumberMessage();
        System.out.println(bonusNumber.getBonusNumber());

    }



}
