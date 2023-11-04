package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void showTickets_ShouldPrintCorrectFormat() {
        List<LottoTicket> tickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        OutputView.showTickets(tickets);

        String expectedOutput = "2개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[7, 8, 9, 10, 11, 12]\n";

        assertTrue(outContent.toString().equals(expectedOutput));
    }

    @Test
    void showResults_ShouldPrintCorrectFormat() {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        results.put(LottoRank.FIRST, 1);
        results.put(LottoRank.THIRD, 2);
        double profitRatio = 150.01;

        OutputView.showResults(results, profitRatio);

        String expectedOutput = "당첨 통계\n" +
                "---------\n" +
                "6개 일치 (2000000000원)- 1개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원)- 0개\n" + // 보너스 볼 일치 추가
                "4개 일치 (1500000원)- 2개\n" + // 기존의 잘못된 위치 수정
                "3개 일치 (50000원)- 0개\n" + // 실제 값에 맞게 업데이트
                "2개 일치 (5000원)- 0개\n" + // 실제 값에 맞게 추가
                "총 수익률은 150.01%입니다.\n"; // 수익률 형식은 올바름


        assertEquals(expectedOutput, outContent.toString());
    }
}
