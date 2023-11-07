package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1부터 45사이 숫자가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInRangeNumber() {
        assertThatThrownBy(() -> Lotto.issueLotto(List.of(1, 2, 45, 30, 50, 10)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 여부를 확인한다.")
    @Test
    void judgeWinningRating() {
        // given
        Set<Integer> winnerLottoNumber = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lottoForFirst = Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lottoForSecond = Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lottoForThird = Lotto.issueLotto(List.of(1, 2, 3, 4, 5, 8)); // 3등
        Lotto lottoForFourth = Lotto.issueLotto(List.of(1, 2, 3, 4, 7, 8)); // 4등
        Lotto lottoForFifth = Lotto.issueLotto(List.of(1, 2, 3, 9, 7, 8)); // 5등
        Lotto lottoForNoLuck = Lotto.issueLotto(List.of(1, 2, 9, 10, 7, 8)); // 낙첨

        // when
        WinnerRating first = lottoForFirst.judgeWinner(winnerLottoNumber, bonusNumber);
        WinnerRating second = lottoForSecond.judgeWinner(winnerLottoNumber, bonusNumber);
        WinnerRating third = lottoForThird.judgeWinner(winnerLottoNumber, bonusNumber);
        WinnerRating fourth = lottoForFourth.judgeWinner(winnerLottoNumber, bonusNumber);
        WinnerRating fifth = lottoForFifth.judgeWinner(winnerLottoNumber, bonusNumber);
        WinnerRating noLuck = lottoForNoLuck.judgeWinner(winnerLottoNumber, bonusNumber);

        // then
        assertThat(first).isEqualTo(WinnerRating.FIRST);
        assertThat(second).isEqualTo(WinnerRating.SECOND);
        assertThat(third).isEqualTo(WinnerRating.THIRD);
        assertThat(fourth).isEqualTo(WinnerRating.FOURTH);
        assertThat(fifth).isEqualTo(WinnerRating.FIFTH);
        assertThat(noLuck).isEqualTo(WinnerRating.NO_LUCK);
    }
}