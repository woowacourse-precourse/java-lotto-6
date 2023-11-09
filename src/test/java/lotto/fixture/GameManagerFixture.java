package lotto.fixture;

import lotto.domain.GameManager;

import static lotto.fixture.UserFixture.총_2장_구매_당첨_X_유저;
import static lotto.fixture.UserFixture.총_3장_구매_1등_한장_유저;
import static lotto.fixture.WinningFixture.당첨_정보;

public enum GameManagerFixture {
    총_2장_중_당첨_X_게임(총_2장_구매_당첨_X_유저, 당첨_정보),
    총_3장_중_1등_로또_1장_게임(총_3장_구매_1등_한장_유저, 당첨_정보);

    private final UserFixture userFixture;
    private final WinningFixture winningFixture;

    GameManagerFixture(final UserFixture userFixture,
                       final WinningFixture winningFixture) {
        this.userFixture = userFixture;
        this.winningFixture = winningFixture;
    }

    public GameManager 생성() {
        return new GameManager(userFixture.생성(), winningFixture.생성());
    }
}
