package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.configure.DomainConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ResultTest {
    Result result;

    @BeforeEach
    void init() {
        this.result = new Result();
    }

    @Test
    void testGetNumOfEachRank() {
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );
        List<Lotto> testCases = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 28)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 10, 11)),
                new Lotto(Arrays.asList(4, 3, 5, 6, 15, 27)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16))
        );
        for (Lotto testCase : testCases) {
            this.result.addCount(testCase, winningNumbers);
        }

        int[] expected = { 2, 1, 1, 2, 1 };
        for (int i = 0; i < DomainConfiguration.RANGE_OF_RANK; i++) {
            assertThat(this.result.getCount(i + 1)).isEqualTo(expected[i]);
        }
    }
}