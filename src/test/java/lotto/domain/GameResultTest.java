package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void Prize_NONE_카운팅하면_오류_발생() {
        GameResult gameResult = GameResult.create();

        assertThatThrownBy(() -> gameResult.incrementPrizeCount(Prize.NONE))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void Prize_NONE_이외를_카운팅하면_정상_동작() {
        GameResult gameResult = GameResult.create();
        for (Prize prize : Prize.valuesWithoutDefault()) {
            gameResult.incrementPrizeCount(prize);
        }
    }
}