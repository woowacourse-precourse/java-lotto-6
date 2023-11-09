package lotto.fixture;

import lotto.domain.Winning;

import static lotto.fixture.BonusFixture.당첨_보너스_번호;
import static lotto.fixture.LottoFixture.WINNING;

public enum WinningFixture {
    당첨_정보(당첨_보너스_번호, WINNING);

    private final BonusFixture bonusFixture;
    private final LottoFixture lottoFixture;

    WinningFixture(BonusFixture bonusFixture, LottoFixture lottoFixture) {
        this.bonusFixture = bonusFixture;
        this.lottoFixture = lottoFixture;
    }

    public Winning 생성() {
        return new Winning(lottoFixture.생성(), bonusFixture.생성());
    }
}
