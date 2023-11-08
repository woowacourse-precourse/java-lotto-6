package lotto.domain;

import lotto.utils.LottoPlace;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningScoresTest {

    @Test
    void 초기화_테스트() {
        WinningScores winningScores = new WinningScores();

        Assertions.assertThat(winningScores.toString())
                .contains("3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" +
                        "\n6개 일치 (2,000,000,000원) - 0개");

    }

    @Test
    void 결과_집계_테스트_1() {
        WinningScores winningScores = new WinningScores();

        winningScores.increaseScore(LottoPlace.FIRST);

        Assertions.assertThat(winningScores.toString())
                .contains("3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" +
                        "\n6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 결과_집계_테스트_2() {
        WinningScores winningScores = new WinningScores();

        winningScores.increaseScore(LottoPlace.FIRST);
        winningScores.increaseScore(LottoPlace.FOURTH);

        Assertions.assertThat(winningScores.toString())
                .contains("3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" +
                        "\n6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 순수익_테스트_1() {
        WinningScores winningScores = new WinningScores();

        winningScores.increaseScore(LottoPlace.FIRST);
        winningScores.increaseScore(LottoPlace.FOURTH);

        Assertions.assertThat(winningScores.getWinningProfit())
                .isEqualTo(2000050000);
    }

    @Test
    void 순수익_테스트_2() {
        WinningScores winningScores = new WinningScores();

        winningScores.increaseScore(LottoPlace.SECOND);

        Assertions.assertThat(winningScores.getWinningProfit())
                .isEqualTo(3000000);
    }
}
