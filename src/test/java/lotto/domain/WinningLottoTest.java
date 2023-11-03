package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.Error.Domain.BONUS_NUMBER_ALREADY_EXIST;
import static lotto.Error.Domain.WRONG_LOTTO_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    private final Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("보너스 번호가 로또 번호 중 하나와 중복되면 예외가 발생한다.")
    void 보너스_번호_중복_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_ALREADY_EXIST.getText());
    }

    @Test
    @DisplayName("보너스 번호가 45 초과면 예외가 발생한다.")
    void 보너스_번호_45_초과_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @Test
    @DisplayName("보너스 번호가 1 미만이면 예외가 발생한다.")
    void 보너스_번호_0_미만_예외() {
        assertThatThrownBy(() -> new WinningLotto(answerLotto, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_LOTTO_NUMBER_RANGE.getText());
    }

    @ParameterizedTest()
    @MethodSource("lottoParameter")
    @DisplayName("로또 번호와 개수가 일치해야한다.")
    void 로또_번호_일치_정상(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        int count = winningLotto.countSameLottoNumber(target);
        Set<Integer> set = new HashSet<>(parameter);
        set.retainAll(answerLotto.getNumbers());
        //then
        assertThat(set).hasSize(count);
    }

    @ParameterizedTest()
    @MethodSource("lottoParameter")
    @DisplayName("parameter로 주어진 Lotto와 보너스 번호가 일치하면 true, 아니면 false")
    void 보너스_번호_일치_정상(List<Integer> parameter) {
        // given
        Lotto target = new Lotto(parameter);
        WinningLotto winningLotto = new WinningLotto(answerLotto, 7);
        //when
        boolean expected = parameter.stream().anyMatch(e -> e.equals(7));
        //then
        assertThat(winningLotto.isSameWithBonus(target)).isEqualTo(expected);
    }

    private static Stream<Arguments> lottoParameter() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(4, 5, 6, 7, 8, 9)),
                Arguments.of(List.of(10, 11, 12, 13, 14, 16)),
                Arguments.of(List.of(1, 2, 4, 45, 5, 6)),
                Arguments.of(List.of(4, 6, 31, 1, 41, 20)),
                Arguments.of(List.of(6, 7, 4, 3, 2, 1)),
                Arguments.of(List.of(9, 3, 7, 10, 19, 34))
        );
    }
}