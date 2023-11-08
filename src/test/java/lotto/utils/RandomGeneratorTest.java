package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomGeneratorTest {

    @DisplayName("지정된 범위에 해당하는 지정된 개수의 서로 다른 난수 배열 생성")
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

    @DisplayName("개수가 로또 번호의 개수와 다를 때 에러 발생")
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

    @DisplayName("중복된 숫자가 생성될 때 에러 발생")
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

    @DisplayName("생성된 숫자가 1부터 45사이가 아닐 때 예외 발생")
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