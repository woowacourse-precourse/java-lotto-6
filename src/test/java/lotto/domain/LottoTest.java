package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
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

    @ParameterizedTest(name = "입력 값 : {0}")
    @MethodSource("generateLotto")
    @DisplayName("범위 밖 숫자를 입력하면 예외가 발생한다.")
    void 범위_밖_숫자_입력시_예외_테스트(List<Integer> lottoNumbers) {
        //when, then
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 45");
    }

    static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 55)),
                Arguments.of(List.of(1, 2, 311, 4, 5, 55)),
                Arguments.of(List.of(111, 2, 3, 4, 5, 55))
        );
    }
}
