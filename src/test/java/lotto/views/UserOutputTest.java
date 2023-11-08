package lotto.views;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserOutputTest {
    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    @DisplayName("당첨 통계를 출력한다. 이때, 수익률은 소수점 둘째 자리에서 반올림한다.")
    void printWinningStatistics() {
        // given
        Map<LottoRank, Integer> winningResult = new HashMap<>();
        winningResult.put(LottoRank.FIRST_PLACE, 1);
        winningResult.put(LottoRank.SECOND_PLACE, 1);
        winningResult.put(LottoRank.THIRD_PLACE, 1);
        winningResult.put(LottoRank.FOURTH_PLACE, 1);
        winningResult.put(LottoRank.FIFTH_PLACE, 1);
        Double totalReturnRate = 62.599;

        // when
        UserOutput.printWinningStatistics(winningResult, totalReturnRate);

        // then
        String expected = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                총 수익률은 62.6%입니다.""";

        Assertions.assertThat(output.toString()).isEqualTo(expected);
    }
}
