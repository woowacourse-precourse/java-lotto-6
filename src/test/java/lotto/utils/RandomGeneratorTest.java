package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void generate_성공() {
        List<Integer> expected = List.of(8, 21, 23, 41, 42, 43);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(RandomGenerator.generate()).isEqualTo(expected);
                },
                expected
        );
    }

    @Test
    void generate_길이가맞지않음() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(RandomGenerator::generate).isInstanceOf(IllegalStateException.class);
                },
                List.of(1),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
    }

    @Test
    void generate_중복() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(RandomGenerator::generate).isInstanceOf(IllegalStateException.class);
                },
                List.of(1, 1, 1, 1, 1, 1),
                List.of(1, 2, 3, 4, 5, 5),
                List.of(1, 1, 3, 4, 5, 5)
        );
    }

    @Test
    void generate_유효하지않은숫자() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(RandomGenerator::generate).isInstanceOf(IllegalStateException.class);
                },
                List.of(1, 2, 3, 4, 5, 0),
                List.of(1, 2, 3, 47, 5, 6),
                List.of(1, -2, 3, 4, 5, 11)
        );
    }
}