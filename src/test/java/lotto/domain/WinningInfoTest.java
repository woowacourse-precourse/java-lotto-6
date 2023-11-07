package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningInfoTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함된 경우 예외를 발생시킨다.")
    @Test
    void validateBonusNumber() {
        // given
        int bonusNumber = 1;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateSize() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateNumberRange() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateBonusNumberRange() {
        // given
        int bonusNumber = 46;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 중복된 경우 예외를 발생시킨다.")
    @Test
    void validateDuplicateNumber() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호와 로또 번호를 비교한다.")
    @ParameterizedTest
    @MethodSource("createLottoNumbersFixture")
    void matchTest(List<Integer> winningNumbers, int bonusNumber, List<Integer> lottoNumbers, Rank expectedRank) {
        WinningInfo winningInfo = WinningInfo.from(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(lottoNumbers);

        Rank result = winningInfo.match(lotto);
        assertThat(expectedRank).isEqualTo(result);
    }

    private static Stream<Arguments> createLottoNumbersFixture() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 2, 3, 4, 7, 8), Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 2, 3, 7, 8, 9), Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Arrays.asList(1, 7, 8, 9, 10, 11), Rank.MISS)
        );
    }
}
