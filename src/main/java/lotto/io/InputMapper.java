package lotto.io;

import lotto.constants.ViewElement;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchasePrice;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    public PurchasePrice toPurchasePrice(String lottoPurchasePrice) {
        Integer purchasePrice = Integer.parseInt(lottoPurchasePrice);
        return PurchasePrice.from(purchasePrice);
    }

    public Lotto toLotto(String lotto) {
        List<Integer> wingingNumbers = Arrays.stream(lotto.split(ViewElement.DIVISION_COMMA))
                .map(Integer::parseInt)
                .toList();
        return Lotto.from(wingingNumbers);
    }

    public BonusNumber toBonusNumber(String bonusNumber, Lotto lotto) {
        Integer bonus = Integer.parseInt(bonusNumber);
        return BonusNumber.of(bonus, lotto);
    }
}
