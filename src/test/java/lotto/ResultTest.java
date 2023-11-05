package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class ResultTest {
    String getExpectedMessage(Integer[] counts) {
        return String.format("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        """,
                counts[0], counts[1], counts[2], counts[3], counts[4]);
    }
    @DisplayName("5등 2번, 3등 1번인 당첨 결과 메시지 확인")
    @Test
    void checkWinningResultMessage() {
        Result result = new Result(3);
        result.putIt(Ranking.FIFTH);
        result.putIt(Ranking.FIFTH);
        result.putIt(Ranking.THIRD);
        String message = result.getWinningResult();

        assertThat(message).isEqualTo(getExpectedMessage(new Integer[]{2, 0, 1, 0, 0}));
    }

    @DisplayName("로또를 8장 산 경우 5등 1번한 경우 수익률 계산")
    @Test
    void calculateEarningRate() {
        Result result = new Result(8);
        result.putIt(Ranking.FIFTH);
        double rate = result.getEarningRate();

        assertThat(rate).isEqualTo(62.5);
    }
}
