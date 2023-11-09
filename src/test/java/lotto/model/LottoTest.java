package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("로또 번호가 포함되어 있는지 판별한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void givenNumberExistsInLotto_Then_TrueReturns(final int number) {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(LottoNumber.of(number))).isTrue();
    }

    @DisplayName("동일한 로또와 비교하는 경우 일치하는 개수는 6개이다.")
    @Test
    void givenSameLotto_Then_SixReturns() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto other = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.findMatchCount(other)).isEqualTo(MatchCount.SIX);
    }

    @DisplayName("서로 다른 숫자를 가지는 로또와 비교하는 경우 일치하는 개수는 0개이다.")
    @Test
    void givenDifferentLotto_Then_SixReturns() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto other = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.findMatchCount(other)).isEqualTo(MatchCount.NONE);
    }

    @DisplayName("주어진 로또에서 일치하는 번호의 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("generateLottoTicketsWithMatchCount")
    void givenNumberOfLotto_Then_MatchCountReturns(
            final Lotto ticket,
            final MatchCount matchCount
    ) {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.findMatchCount(ticket)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> generateLottoTicketsWithMatchCount() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(8, 21, 23, 41, 42, 43)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(3, 5, 11, 16, 32, 38)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(7, 11, 16, 35, 36, 44)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(1, 8, 11, 31, 41, 42)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(13, 14, 16, 38, 42, 45)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(7, 11, 30, 40, 42, 43)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(2, 13, 22, 32, 38, 45)), MatchCount.NONE),
                Arguments.of(new Lotto(List.of(1, 3, 5, 14, 22, 45)), MatchCount.THREE)
        );
    }
}
