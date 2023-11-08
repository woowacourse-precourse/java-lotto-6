package lotto;

import java.util.stream.Stream;
import lotto.lottocompany.Lotto;
import lotto.lottocompany.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.lottocompany.Reward.*;
import static org.assertj.core.api.Assertions.*;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45의 숫자가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 99})
    void createLottoByNotLottoNumber(int lottoNumber) {
        //given
        List<Integer> lottoNumbers = List.of(lottoNumber, 1, 2, 3, 4, 5);
        // when //then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 당첨을 확인한다.")
    @ParameterizedTest(name = "로또번호: {0}, 결과: {3}")
    @MethodSource("lottoNumberWithReward")
    void checkFirstWinning(Lotto lotto, List<Integer> winningNumbers, int bonusNumber, Reward reward) {
        //given //when
        Reward result = lotto.checkWinning(winningNumbers, bonusNumber);

        //then
        assertThat(result).isEqualTo(reward);
    }

    private static Stream<Arguments> lottoNumberWithReward() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 6), 10, FIRST),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 7), 6, SECOND),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), List.of(1, 2, 3, 4, 5, 7), 10, THIRD),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 8, 7)), List.of(1, 2, 3, 4, 5, 6), 10, FOURTH),
                Arguments.arguments(new Lotto(List.of(1, 2, 3, 9, 8, 7)), List.of(1, 2, 3, 4, 5, 6), 10, FIFTH)
        );
    }
}
