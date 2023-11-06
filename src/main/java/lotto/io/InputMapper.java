package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    private static final String DIVISION = ",";

    public PurchasePrice toPurchasePrice(String lottoPurchasePrice) {
        Integer purchasePrice = Integer.parseInt(lottoPurchasePrice);
        return PurchasePrice.from(purchasePrice);
    }

    public Lotto toLotto(String lotto) {
        List<Integer> wingingNumbers = Arrays.stream(lotto.split(DIVISION))
                .map(Integer::parseInt)
                .toList();
        return Lotto.from(wingingNumbers);
    }

    public BonusNumber toBonusNumber(String bonusNumber, Lotto lotto) {
        Integer bonus = Integer.parseInt(bonusNumber);
        return BonusNumber.of(bonus, lotto);
    }
}
