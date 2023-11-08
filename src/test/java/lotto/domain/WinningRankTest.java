package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {
    @DisplayName("매치카운트와 보너스매치가 1등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_1등_True() {
        assertThat(WinningRank.FIRST.isMatch(6, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 2등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_2등_True() {
        assertThat(WinningRank.SECOND.isMatch(5, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 2등에 부합하지 않을 때 False이다.")
    @Test
    void 매치카운트_보너스매치_2등_False() {
        assertThat(WinningRank.THIRD.isMatch(5, true)).isFalse();
    }

    @DisplayName("매치카운트와 보너스매치가 3등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_3등_True() {
        assertThat(WinningRank.THIRD.isMatch(5, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 4등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_4등_True() {
        assertThat(WinningRank.FOURTH.isMatch(4, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 5등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_5등_True() {
        assertThat(WinningRank.FIFTH.isMatch(3, false)).isTrue();
    }

    @DisplayName("1등 메시지를 반환 한다.")
    @Test
    void 로또_1등_메시지_성공() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        lottoBuyer.addWinCount(WinningRank.FIRST);
        String message = "6개 일치 (2,000,000,000원) - 1개";

        assertThat(WinningRank.FIRST.getMessage(lottoBuyer)).isEqualTo(message);
    }

    @DisplayName("2등 메시지를 반환 한다.")
    @Test
    void 로또_2등_메시지_성공() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        lottoBuyer.addWinCount(WinningRank.SECOND);
        String message = "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개";

        assertThat(WinningRank.SECOND.getMessage(lottoBuyer)).isEqualTo(message);
    }

    @DisplayName("3등 메시지를 반환 한다.")
    @Test
    void 로또_3등_메시지_성공() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        lottoBuyer.addWinCount(WinningRank.THIRD);
        String message = "5개 일치 (1,500,000원) - 1개";

        assertThat(WinningRank.THIRD.getMessage(lottoBuyer)).isEqualTo(message);
    }

    @DisplayName("4등 메시지를 반환 한다.")
    @Test
    void 로또_4등_메시지_성공() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        lottoBuyer.addWinCount(WinningRank.FOURTH);
        String message = "4개 일치 (50,000원) - 1개";

        assertThat(WinningRank.FOURTH.getMessage(lottoBuyer)).isEqualTo(message);
    }

    @DisplayName("5등 메시지를 반환 한다.")
    @Test
    void 로또_5등_메시지_성공() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        lottoBuyer.addWinCount(WinningRank.FIFTH);
        String message = "3개 일치 (5,000원) - 1개";

        assertThat(WinningRank.FIFTH.getMessage(lottoBuyer)).isEqualTo(message);
    }
}