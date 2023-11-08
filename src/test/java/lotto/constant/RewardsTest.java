package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RewardsTest {

    @Test
    void of() {
        Rewards firstExpected = Rewards.of(6, false);
        Rewards secondExpected = Rewards.of(5, true);
        Rewards thirdExpected = Rewards.of(5, false);
        Rewards fourthExpected = Rewards.of(4, true);
        Rewards fifthExpected = Rewards.of(3, false);
        Rewards loseExpected = Rewards.of(2, true);

        assertThat(firstExpected).isEqualTo(Rewards.FIRST);
        assertThat(secondExpected).isEqualTo(Rewards.SECOND);
        assertThat(thirdExpected).isEqualTo(Rewards.THIRD);
        assertThat(fourthExpected).isEqualTo(Rewards.FOURTH);
        assertThat(fifthExpected).isEqualTo(Rewards.FIFTH);
        assertThat(loseExpected).isEqualTo(Rewards.LOSE);
    }
}