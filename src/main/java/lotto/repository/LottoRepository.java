package lotto.repository;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoRepository {
    private PurchaseAmount purchaseAmount;
    private Lotteries lotteries;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public LottoRepository() {
        lotteries = new Lotteries();
    }

    public String updatePurchaseAmount(String amountInput) {
        purchaseAmount = new PurchaseAmount(amountInput);
        return purchaseAmount.getResult();
    }

    public int getPurchaseQuantity() {
        return purchaseAmount.getQuantity();
    }

    public void insertLotto(Lotto lotto) {
        lotteries.addLotto(lotto);
    }

    public String getLotteriesInfo() {
        return lotteries.concatLotteries();
    }

    public void updateWinningNumbers(List<Integer> numbers) {
        winningNumbers = new Lotto(numbers);
    }

    public void updateBonusNumber(int number) {
        bonusNumber = new BonusNumber(number, winningNumbers);
    }

    public String getLottoResult() {
        return lotteries.getResult(winningNumbers, bonusNumber);
    }
}
