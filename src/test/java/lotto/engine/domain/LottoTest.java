package lotto.engine.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.engine.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @ParameterizedTest(name = "[{index}차]시도: numbers: {0}")
    @DisplayName("로또 번호에 중복된 숫자가 존재하지 않으며 길이가 6이면 로또 객체 생성에 성공한다.")
    @MethodSource("getLotto")
    void createLotto(List<Integer> numbers) {
        /// given
        // when
        Lotto lotto = new Lotto(numbers);
        // then

    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void failCreateLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void failCreateLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static Stream<Arguments> getLotto() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 7)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 9)),
                Arguments.arguments(List.of(1, 2, 3, 4, 9, 10)),
                Arguments.arguments(List.of(1, 2, 3, 8, 9, 10)),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45))
        );
    }
}