package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoComparatorTest {

    private final LottoComparator lottoComparator = new LottoComparator();

    @DisplayName("당첨 결과를 올바르게 반환한다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersForTesting")
    void givenUserLottoNumbers_whenComparingWithWinningLotto_thenReturnsCorrectResults(
            List<Integer> userNumbers,
            int expectedMatchCount, boolean expectedBonusMatch) {
        // Given
        Lotto userLotto = new Lotto(userNumbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        // When
        LottoResult result = lottoComparator.compare(winningLotto, userLotto);

        // then
        assertThat(result.matchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.bonusMatch()).isEqualTo(expectedBonusMatch);
    }

    private static Stream<Arguments> provideLottoNumbersForTesting() {
        return Stream.of(
                // 모든 번호 일치, 보너스 번호 불일치
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, false),
                // 3개 번호 일치, 보너스 번호 일치
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3, true),
                // 5개 번호 일치, 보너스 번호 일치
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5, true)
        );
    }
}

