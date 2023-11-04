package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchasePrice;

import java.util.Arrays;
import java.util.List;

public class InputMapper {

    public LottoPurchasePrice toLottoPurchasePrice(String lottoPurchasePrice) {
        Integer purchasePrice = Integer.parseInt(lottoPurchasePrice);
        return new LottoPurchasePrice(purchasePrice);
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
