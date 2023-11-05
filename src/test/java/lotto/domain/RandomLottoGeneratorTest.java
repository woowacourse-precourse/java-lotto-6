package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomLottoGeneratorTest {

    @ParameterizedTest(name = "크기 : {0}")
    @CsvSource({"0", "-1"})
    void generateTest_whenSizeIsNotPositive_throwException(int size) {
        assertThatThrownBy(() -> RandomLottoGenerator.generate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 개수는 양수이어야 합니다");

    }
}
