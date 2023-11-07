package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void initWinningLotto() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto = new WinningLotto(lotto, 7);
    }

    @DisplayName("주어진 사용자의 로또가 당첨됐는지 안됐는지 여부를 판단한다.")
    @Test
    void checkWinningStatus() {
        //given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        Boolean isDrawn = winningLotto.isDrawnLotto(userLotto);
        //then
        assertThat(isDrawn).isTrue();
    }

    @DisplayName("주어진 사용자의 로또가 당첨 됐다면 어떤 당첨 종류를 알려준다.")
    @Test
    void getWinningCategory() {
        //given
        Lotto userLotto = new Lotto(List.of(11, 21, 31, 4, 5, 6));
        //when
        LottoPrize lottoPrizeType = winningLotto.findLottoPrizeType(userLotto);
        //then
        assertThat(lottoPrizeType).isEqualTo(LottoPrize.FIFTH_PRIZE);
    }

    @DisplayName("주어진 사용자의 로또가 당첨 안됐다면 예외를 발생시킨다.")
    @Test
    void noWinningCategoryThrowException() {
        //given
        Lotto userLotto = new Lotto(List.of(11, 21, 31, 41, 5, 6));
        //when, then
        assertThatThrownBy(
                () -> winningLotto.findLottoPrizeType(userLotto))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("[ERROR] 보너스 넘버와 로또에 맞는 등수가 없습니다.");
    }

    @DisplayName("주어진 당첨 번호가 로또 번호에 이미 존재하는 값이면 예외를 발생시킨다.")
    @Test
    void NumberAlreadyUsedInLottoThrowException() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when, then
        assertThatThrownBy(
                () -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복한 값이 들어갈 수 없습니다.");
    }

    @DisplayName("주어진 당첨 번호가 범위 밖에 있다면 예외를 발생시킨다.")
    @Test
    void NumberOutRangeThrowException() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when, then
        assertThatThrownBy(
                () -> new WinningLotto(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}