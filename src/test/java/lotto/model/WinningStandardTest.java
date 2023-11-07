package lotto.model;

import static lotto.model.WinningStandard.checkMatchNumbers;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStandardTest {

    @ParameterizedTest
    @MethodSource("getLottoNumbersAndRanking")
    @DisplayName("당첨 번호 순위 계산 맞는지 확인")
    void testCheckMatchNumbers(List<Integer> numbers, WinningStandard standard) {
        //given
        Lotto lotto = new Lotto(numbers);

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        //when
        WinningStandard rank = checkMatchNumbers(lotto, winningLotto);

        //then
        Assertions.assertThat(rank).isEqualTo(standard);
    }

    private static Stream<Arguments> getLottoNumbersAndRanking() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), WinningStandard.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), WinningStandard.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), WinningStandard.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 7, 15), WinningStandard.FORTH),
                Arguments.of(List.of(1, 2, 3, 14, 15, 18), WinningStandard.FIFTH),
                Arguments.of(List.of(1, 2, 7, 14, 15, 18), WinningStandard.ETC)
        );
    }
}