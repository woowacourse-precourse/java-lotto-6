package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("[Unit] LotteryRound에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class LotteryRoundTest {
    @Test
    void constructor_같은값으로_인자를_넣어도_같지_않다() {
        LotteryRound round = new LotteryRound(1);

        assertThat(new LotteryRound(1))
                .isNotSameAs(round);
    }

    @Test
    void next_반환값으로_다른_객체를_반환한다() {
        LotteryRound round = new LotteryRound(1);

        assertThat(round.next())
                .isNotSameAs(round);
    }
}
