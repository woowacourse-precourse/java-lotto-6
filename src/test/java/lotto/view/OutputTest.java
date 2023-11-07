package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    private static ByteArrayOutputStream outputMessage;

    protected String getOutput() {
        return outputMessage.toString();
    }

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("금액 입력 메세지 출력")
    void printWinningStatistics() {
        WinningResult winningResult = new WinningResult();
        winningResult.addResults(6,true);
        String expectedMessage = "당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 1개";

        Output.printWinningStatistics(winningResult);

        assertEquals(expectedMessage, getOutput().trim());
    }

    @Test
    @DisplayName("총 수익률 출력")
    void printTotalReturn() {
        double totalReturn = 62.5;
        String expectedMessage = "총 수익률은 62.5%입니다.";

        Output.printTotalReturn(totalReturn);

        assertEquals(expectedMessage, getOutput().trim());
    }
}
