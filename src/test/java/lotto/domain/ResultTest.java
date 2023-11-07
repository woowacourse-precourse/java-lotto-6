package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.configure.DomainConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultTest {
    Result result;

    @BeforeEach
    void init() {
        this.result = new Result();
    }

    @Test
    void testGetNumOfEachRank() {
        this.result.addCount(1);
        this.result.addCount(2);
        this.result.addCount(3);
        this.result.addCount(3);
        this.result.addCount(4);

        int[] expected = { 1, 1, 2, 1, 0 };
        for (int i = 0; i < DomainConfiguration.RANGE_OF_RANK; i++) {
            assertThat(this.result.getCount(i + 1)).isEqualTo(expected[i]);
        }
    }

    @Test
    void testCalculateTotalReward() {
        this.result.addCount(1);
        this.result.addCount(2);
        this.result.addCount(3);
        this.result.addCount(3);
        this.result.addCount(4);

        int expected = DomainConfiguration.REWARD_PER_RANK.get(1)
                + DomainConfiguration.REWARD_PER_RANK.get(2)
                + DomainConfiguration.REWARD_PER_RANK.get(3) * 2
                + DomainConfiguration.REWARD_PER_RANK.get(4);

        assertThat(this.result.calculateTotalReward()).isEqualTo(expected);
    }
}