package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    @Test
    void printAllTickets_shouldPrintCorrectMessage() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView outputView = new OutputView();
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 20, 30, 40, 41, 42))
        );

        // Act
        outputView.printAllTickets(tickets);

        // Assert
        String expectedOutput = "2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[10, 20, 30, 40, 41, 42]\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printRankResult_shouldPrintCorrectMessage() {
        // Arrange
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView outputView = new OutputView();
        int[] rankCount = {1, 2, 3, 4, 5};
        double profitability = 50.0;

        // Act
        outputView.printRankResult(rankCount, profitability);

        // Assert
        String expectedOutput = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 2개\n" +
                "5개 일치 (1,500,000원) - 3개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개\n" +
                "6개 일치 (2,000,000,000원) - 5개\n" +
                "총 수익률은 50.0%입니다.\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
