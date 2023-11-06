package lotto.domain;

import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createInvalidRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 로또 번호의 일치되는 번호 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("비교할_두개의_로또번호_설정")
    void compareLottoNumbers(List<Integer> 당첨번호, List<Integer> 로또번호, int 예상결과) {
        // given
        Lotto 당첨로또 = new Lotto(당첨번호);
        Lotto 발행된로또 = new Lotto(로또번호);

        // when
        int 일치개수 = 당첨로또.countMatching(발행된로또);

        // then
        assertEquals(예상결과, 일치개수);
    }

    static Stream<Arguments> 비교할_두개의_로또번호_설정() {
        return Stream.of(
            Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), List.of(4, 6, 7, 8, 9, 10), 2),
            Arguments.arguments(List.of(5, 2, 3, 4, 10, 6), List.of(5, 2, 3, 4, 10, 6), 6),
            Arguments.arguments(List.of(10, 11, 12, 3, 4, 6), List.of(1, 2, 7, 8, 9, 5), 0)
        );
    }
}