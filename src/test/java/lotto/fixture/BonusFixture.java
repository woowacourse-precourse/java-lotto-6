package lotto.fixture;

import lotto.domain.Bonus;

public enum BonusFixture {
    당첨_번호에_포함되는_보너스_번호(1),
    당첨_보너스_번호(7),
    정상_보너스_번호(10),
    범위를_벗어난_보너스_번호(50);
    private final int bonusNumber;

    BonusFixture(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Bonus 생성() {
        return new Bonus(bonusNumber);
    }
}
