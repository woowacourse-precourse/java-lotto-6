package lotto.model;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_ALREADY_USE;

import java.util.List;

public class LottoCompany {

    private final GoalNumbers goalNumbers;
    private final BonusNumber bonusNumber;

    private LottoCompany(final GoalNumbers goalNumbers, final BonusNumber bonusNumber) {
        this.goalNumbers = goalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoCompany of(final GoalNumbers goalNumbers, final BonusNumber bonusNumber) {
        validateIsBonusNumberDuplicate(goalNumbers, bonusNumber);
        return new LottoCompany(goalNumbers, bonusNumber);
    }

    private static void validateIsBonusNumberDuplicate(final GoalNumbers goalNumbers, final BonusNumber bonusNumber) {
        int bonus = bonusNumber.getNumber();
        List<Integer> goals = goalNumbers.getNumbers();

        if (goals.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ALREADY_USE.getMessage());
        }
    }

    public List<Lotto> collectLottosWithSizeExceptBonus(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> lotto.isContainsNumbersWithSize(goalNumbers.getNumbers(), matchSize))
                .filter(lotto -> !lotto.isContainsNumber(bonusNumber.getNumber()))
                .toList();
    }

    public List<Lotto> collectLottosWithSizeIncludeBonus(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> lotto.isContainsNumbersWithSize(goalNumbers.getNumbers(), matchSize))
                .filter(lotto -> lotto.isContainsNumber(bonusNumber.getNumber()))
                .toList();
    }
}
