package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    private static Stream<Arguments> normalLottoArguments() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(45, 23, 42, 17, 35, 31)),
                Arguments.arguments(List.of(35, 1, 45, 32, 12, 22))
        );
    }

    private static Stream<Arguments> exceptionLottoArguments() {
        return Stream.of(
                Arguments.arguments("0이 포함된 경우", List.of(0, 2, 3, 4, 5, 8)),
                Arguments.arguments("음수가 포함된 경우", List.of(-1, 3, 23, 34, 15, 21)),
                Arguments.arguments("45보다 큰 수가 포함된 경우", List.of(46, 23, 29, 36, 21, 45)),
                Arguments.arguments("중복된 수가 포함된 경우", List.of(2, 3, 2, 5, 23, 5)),
                Arguments.arguments("6개보다 많은 수가 포함된 경우", List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "로또 숫자 : {0}")
    @MethodSource("normalLottoArguments")
    @DisplayName("정상적인 로또 테스트")
    void normalLottoTest(List<Integer> lottoNumbers) {
        assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("exceptionLottoArguments")
    @DisplayName("예외적인 로또 테스트")
    void exceptionLottoTest(String testName, List<Integer> lottoNumbers) {
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}