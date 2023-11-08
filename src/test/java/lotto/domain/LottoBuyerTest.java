package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {
    @DisplayName("1등에 해당하는 우승 횟수를 증가한다.")
    @Test
    void 우승_횟수_증가_1등() {
        WinningRank rank = WinningRank.FIRST;
        LottoBuyer lottoBuyer = new LottoBuyer();

        lottoBuyer.addWinCount(rank);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("2등에 해당하는 우승 횟수를 증가한다.")
    @Test
    void 우승_횟수_증가_2등() {
        WinningRank rank = WinningRank.SECOND;
        LottoBuyer lottoBuyer = new LottoBuyer();

        lottoBuyer.addWinCount(rank);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("3등에 해당하는 우승 횟수를 증가한다.")
    @Test
    void 우승_횟수_증가_3등() {
        WinningRank rank = WinningRank.THIRD;
        LottoBuyer lottoBuyer = new LottoBuyer();

        lottoBuyer.addWinCount(rank);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("4등에 해당하는 우승 횟수를 증가한다.")
    @Test
    void 우승_횟수_증가_4등() {
        WinningRank rank = WinningRank.FOURTH;
        LottoBuyer lottoBuyer = new LottoBuyer();

        lottoBuyer.addWinCount(rank);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("5등에 해당하는 우승 횟수를 증가한다.")
    @Test
    void 우승_횟수_증가_5등() {
        WinningRank rank = WinningRank.FIFTH;
        LottoBuyer lottoBuyer = new LottoBuyer();

        lottoBuyer.addWinCount(rank);

        assertThat(1)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("1등에 해당하는 우승 횟수를 반환한다.")
    @Test
    void 우승_횟수_반환_1등() {
        WinningRank rank = WinningRank.FIRST;
        LottoBuyer lottoBuyer = new LottoBuyer();

        assertThat(0)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("2등에 해당하는 우승 횟수를 반환한다.")
    @Test
    void 우승_횟수_반환_2등() {
        WinningRank rank = WinningRank.SECOND;
        LottoBuyer lottoBuyer = new LottoBuyer();

        assertThat(0)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("3등에 해당하는 우승 횟수를 반환한다.")
    @Test
    void 우승_횟수_반환_3등() {
        WinningRank rank = WinningRank.THIRD;
        LottoBuyer lottoBuyer = new LottoBuyer();

        assertThat(0)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("4등에 해당하는 우승 횟수를 반환한다.")
    @Test
    void 우승_횟수_반환_4등() {
        WinningRank rank = WinningRank.FOURTH;
        LottoBuyer lottoBuyer = new LottoBuyer();

        assertThat(0)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }

    @DisplayName("5등에 해당하는 우승 횟수를 반환한다.")
    @Test
    void 우승_횟수_반환_5등() {
        WinningRank rank = WinningRank.FIFTH;
        LottoBuyer lottoBuyer = new LottoBuyer();

        assertThat(0)
                .isEqualTo(lottoBuyer.getWinCount(rank));
    }
}