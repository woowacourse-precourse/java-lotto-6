package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    public PurchasePrice toPurchasePrice(String lottoPurchasePrice) {
        Integer purchasePrice = Integer.parseInt(lottoPurchasePrice);
        return new PurchasePrice(purchasePrice);
    }

    public Lotto toLotto(String winningNumbers) {
        List<Integer> wingingNumbers = Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
        return new Lotto(wingingNumbers);
    }

    public BonusNumber toBonusNumber(String bonusNumber, Lotto lotto) {
        Integer bonus = Integer.parseInt(bonusNumber);
        return new BonusNumber(bonus, lotto);
    }
}
