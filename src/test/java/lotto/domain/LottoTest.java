package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Rank 계산 parameterized test")
    @Nested
    class calculateRank {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        @ParameterizedTest
        @MethodSource("provideNumbersAndRank")
        void calculateRankTest(List<Integer> winningNumbers,
                               Integer bonusNumber,
                               Rank expected) {
            //given
            //when
            Rank actual = lotto.calculateRank(winningNumbers, bonusNumber);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        private static Stream<Arguments> provideNumbersAndRank() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6), 45, Rank.FIRST),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 7), 6, Rank.SECOND),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 7), 8, Rank.THIRD),
                    Arguments.of(List.of(1, 2, 3, 4, 7, 8), 45, Rank.FORTH),
                    Arguments.of(List.of(1, 2, 3, 7, 8, 9), 45, Rank.FIFTH),
                    Arguments.of(List.of(1, 2, 7, 8, 9, 10), 45, Rank.LOSER)
            );
        }
    }
}
