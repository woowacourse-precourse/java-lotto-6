package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.List;

public class Player {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private PurchaseAmount purchaseAmount;

    private Player(List<Integer> numbers, Integer bonusNumber, Integer purchaseAmount) {
        this.lotto = Lotto.create(numbers);
        this.bonusNumber = LottoNumber.create(bonusNumber);
        this.purchaseAmount = PurchaseAmount.create(purchaseAmount);
    }

    public static Player create(List<Integer> numbers, Integer bonusNumber, Integer purchaseAmount) {
        return new Player(numbers, bonusNumber, purchaseAmount);
    }

    public int getPurchasedLottoCount() {
        return PurchaseAmount.calculatePurchasedLottoCount(purchaseAmount.getPurchaseAmount());
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber.getLottoNumber();
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount.getPurchaseAmount();
    }
}
