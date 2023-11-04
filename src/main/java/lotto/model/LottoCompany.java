package lotto.model;

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
}
