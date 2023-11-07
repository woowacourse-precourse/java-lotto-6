package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final WinningNumber winningNumber
            = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

    @DisplayName("보너스 번호가 당첨 번호에 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void doesBonusExistsLotto_Then_ExceptionOccurs(final int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 당첨 번호에 없으면 예외가 발생하지 않는다.")
    @Test
    void doesBonusNotExistsLotto_Then_NoExceptionOccurs() {
        assertThatCode(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 당첨 번호와 3개 미만으로 일치하면 꼴등이다.")
    @Test
    void givenLottoAllDifferent_Then_NoRankReturns() {
        final Lotto ticket = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("로또 번호가 당첨 번호와 3개 일치하면 5등이다.")
    @Test
    void givenLottoMatchThree_Then_FifthRankReturns() {
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 14, 22, 45));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("로또 번호가 당첨 번호와 4개 일치하면 4등이다.")
    @Test
    void givenLottoMatchFour_Then_FourthRankReturns() {
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 22, 45));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("로또 번호가 당첨 번호와 5개 일치하면 3등이다.")
    @Test
    void givenLottoMatchFive_Then_ThirdRankReturns() {
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("로또 번호가 당첨 번호와 5개 일치하고, 보너스 번호와 일치하면 2등이다.")
    @Test
    void givenLotto_MatchFive_MatchBonus_Then_SecondRankReturns() {
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("로또 번호가 당첨 번호가 모두 일치하면 1등이다.")
    @Test
    void givenLotto_MatchAll_Then_FirstRankReturns() {
        final Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.compare(ticket)).isEqualTo(LottoRank.FIRST);
    }
}
