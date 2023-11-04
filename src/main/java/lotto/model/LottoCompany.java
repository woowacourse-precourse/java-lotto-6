package lotto.model;

import java.util.List;

public class LottoCompany {

    private final GoalNumbers goalNumbers;
    private final BonusNumber bonusNumber;

    private LottoCompany(final GoalNumbers goalNumbers, final BonusNumber bonusNumber) {
        this.goalNumbers = goalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoCompany of(final GoalNumbers goalNumbers, final BonusNumber bonusNumber) {
        return new LottoCompany(goalNumbers, bonusNumber);
    }

    public List<Lotto> calculateLottosWithSizeExceptBonus(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> goalNumbers.isNumbersSameWithSize(lotto.getNumbers(), matchSize))
                .filter(lotto -> !bonusNumber.isNumbersContainBonus(lotto.getNumbers()))
                .toList();
    }

    public List<Lotto> calculateLottosWithSizeIncludeBonus(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> goalNumbers.isNumbersSameWithSize(lotto.getNumbers(), matchSize))
                .filter(lotto -> bonusNumber.isNumbersContainBonus(lotto.getNumbers()))
                .toList();
    }
}
