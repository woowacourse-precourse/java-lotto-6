package lotto.domain;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import static lotto.exception.ExceptionMessage.*;

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

    @DisplayName("[Exception] 로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("numbersProvider")
    void createLottoByOutOfBoundNumber(int[] input) {
        List<Integer> numbers = Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage(OUT_OF_RANGE.getMessage());
    }

    private static Stream<int[]> numbersProvider() {
        return Arrays.stream(new int[][]{
                {0, 1, 2, 3, 4, 5},
                {46, 1, 2, 3, 4, 5}
        });
    }

    @DisplayName("[Success] 로또 번호와 당첨 번호 사이 일치하는 숫자의 개수를 리턴한다.")
    @Test
    void compareWithWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.countMatchNumbers(winningNumber))
                .isEqualTo(3);
    }

    @DisplayName("[Success] 로또 번호에 보너스 번호와 일치하는 값이 있으면 true를 리턴한다.")
    @Test
    void checkHasSameNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.hasSameNumber(1))
                .isTrue();
    }
}