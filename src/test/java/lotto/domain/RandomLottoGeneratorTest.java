package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomLottoGeneratorTest {

    @ParameterizedTest(name = "크기 : {0}")
    @CsvSource({"0", "-1"})
    @DisplayName("생성하는 로또의 개수가 음수일 경우, 예외를 던진다")
    void generateTest_whenSizeIsNotPositive_throwException(int size) {
        assertThatThrownBy(() -> RandomLottoGenerator.generate(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 개수는 양수이어야 합니다");
    }

    @ParameterizedTest(name = "크기 : {0}")
    @CsvSource({"1", "6"})
    @DisplayName("생성하는 로또의 개수가 양수일 경우, 랜덤한 로또를 개수에 맞춰 생성한다")
    void generateTest(int size) {

        List<Lotto> lottos = RandomLottoGenerator.generate(size);
        int actualSize = lottos.size();

        assertThat(actualSize).isEqualTo(size);
    }
}
