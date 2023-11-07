package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    @DisplayName("Winning 열거형에서 상금을 올바르게 반환하는지 테스트")
    @Test
    void getWinningAmount() {
        assertThat(Winning.NOT_WINNING.getWinningAmount()).isEqualTo(0);
        assertThat(Winning.THIRD.getWinningAmount()).isEqualTo(5_000);
        assertThat(Winning.FOURTH.getWinningAmount()).isEqualTo(50_000);
        assertThat(Winning.FIFTH.getWinningAmount()).isEqualTo(1_500_000);
        assertThat(Winning.FIFTH_BONUS.getWinningAmount()).isEqualTo(30_000_000);
        assertThat(Winning.SIXTH.getWinningAmount()).isEqualTo(2_000_000_000);
    }

    @DisplayName("Winning 열거형에서 일치하는 숫자 개수를 올바르게 반환하는지 테스트")
    @Test
    void getMatchCount() {
        assertThat(Winning.NOT_WINNING.getMatchCount()).isEqualTo(0);
        assertThat(Winning.THIRD.getMatchCount()).isEqualTo(3);
        assertThat(Winning.FOURTH.getMatchCount()).isEqualTo(4);
        assertThat(Winning.FIFTH.getMatchCount()).isEqualTo(5);
        assertThat(Winning.FIFTH_BONUS.getMatchCount()).isEqualTo(7);
        assertThat(Winning.SIXTH.getMatchCount()).isEqualTo(6);
    }

    @DisplayName("Winning 열거형에서 정상적인 번호 조합을 체크하는 테스트")
    @Test
    void checkWinning() {
        assertThat(Winning.checkWinning(6, false)).isEqualTo(Winning.SIXTH);
        assertThat(Winning.checkWinning(5, true)).isEqualTo(Winning.FIFTH_BONUS);
        assertThat(Winning.checkWinning(5, false)).isEqualTo(Winning.FIFTH);
        assertThat(Winning.checkWinning(4, false)).isEqualTo(Winning.FOURTH);
        assertThat(Winning.checkWinning(3, false)).isEqualTo(Winning.THIRD);
        assertThat(Winning.checkWinning(0, false)).isEqualTo(Winning.NOT_WINNING);
    }
}
