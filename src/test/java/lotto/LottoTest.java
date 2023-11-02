package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 번호와 당첨 로또 번호 중 일치하는 번호의 갯수 반환")
    @ParameterizedTest(name = "{displayName} : {0}")
    @MethodSource("matchCountParametersProvide")
    void checkMatchCount(List<Integer> bought, int expected) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto boughtLotto = new Lotto(bought);
        assertThat(boughtLotto.count(winningLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> matchCountParametersProvide() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 20, 3, 4, 5, 6), 5),
                Arguments.of(List.of(1, 22, 31, 4, 5, 6), 4),
                Arguments.of(List.of(10, 2, 3, 45, 5, 30), 3)
        );
    }
}