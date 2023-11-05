package lotto.model;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_ALREADY_USE;

import java.util.List;

public class LottoCompany {

    private final GoalNumbers goalNumbers;
    private final LottoNumber bonusNumber;

    private LottoCompany(final GoalNumbers goalNumbers, final LottoNumber bonusNumber) {
        this.goalNumbers = goalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoCompany of(final GoalNumbers goalNumbers, final LottoNumber bonusNumber) {
        validateIsBonusNumberDuplicate(goalNumbers, bonusNumber);
        return new LottoCompany(goalNumbers, bonusNumber);
    }

    private static void validateIsBonusNumberDuplicate(final GoalNumbers goalNumbers, final LottoNumber bonusNumber) {
        List<LottoNumber> goals = goalNumbers.getNumbers();

        if (goals.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ALREADY_USE.getMessage());
        }
    }

    public List<Lotto> collectLottosWithOption(final List<Lotto> lottos, final int matchSize, final boolean hasBonus) {
        return lottos.stream()
                .filter(lotto -> lotto.isContainsNumbersWithSize(goalNumbers.getNumbers(), matchSize))
                .filter(lotto -> lotto.isContainsNumber(bonusNumber) == hasBonus)
                .toList();
    }
}
