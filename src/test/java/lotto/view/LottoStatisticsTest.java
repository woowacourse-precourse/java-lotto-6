package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.constants.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("로또 등수 통계 출력 테스트")
    public void testPrintStatistics() {
        List<LottoRank> lottoRanks = Arrays.asList(
                LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH,
                LottoRank.FIFTH, LottoRank.FIFTH
        );

        LottoStatistics lottoStatistics = new LottoStatistics(lottoRanks);

        lottoStatistics.printStatistics();

        // 예상 출력 결과
        String expectedOutput = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 2개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n";

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
