package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumberGeneratorTest {

    @ParameterizedTest
    @DisplayName("생성된 로또의 사이즈가 6이어야 한다.")
    @MethodSource("createLottoNumber")
    void lottoSize(List<Integer> lotto) {
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("생성된 로또가 중복 숫자가 없어야 된다.")
    @MethodSource("createLottoNumber")
    void duplicateLotto(List<Integer> lotto) {
        Assertions.assertThat(lotto.stream().distinct().count()).isEqualTo(6);
    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers()),
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers()),
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers()),
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers()),
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers()),
                Arguments.arguments(new LottoNumberGenerator().pickUniqueNumbers())
        );
    }
}
