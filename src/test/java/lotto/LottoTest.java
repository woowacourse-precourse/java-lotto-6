package lotto;

import lotto.model.Bonus;
import lotto.model.Lotto;
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
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 1 부터 45 사이의 수가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName}, value={0}")
    @MethodSource("outOfRangeParametersProvider")
    void createLottoByOutOfRange(List<Integer> value) {
        assertThatThrownBy(() -> new Lotto(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> outOfRangeParametersProvider() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(41, 42, 43, 44, 45, 46))
        );
    }

    @DisplayName("구매한 로또 번호와 당첨 로또 번호 중 일치하는 번호의 갯수 반환")
    @ParameterizedTest(name = "{displayName} : {0}, 기대값: {1}")
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

    @DisplayName("구매한 로또 번호와 보너스 번호가 일치하는지 확인")
    @ParameterizedTest(name = "{displayName} : {0}, 기대값: {1}")
    @MethodSource("bonusNumberMatchParametersProvide")
    void checkBonusNumberMatch(List<Integer> bought, boolean expected) {
        Bonus bonusNumber = new Bonus(7);
        Lotto boughtLotto = new Lotto(bought);
        assertThat(bonusNumber.hasBonusNumber(boughtLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> bonusNumberMatchParametersProvide() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), false),
                Arguments.of(List.of(10, 2, 3, 45, 5, 7), true)
        );
    }
}
