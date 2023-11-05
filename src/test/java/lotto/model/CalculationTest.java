package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testDisplayStatistics() {
        List<Integer> result = List.of(1, 0, 0, 0, 0);
        int purchaseAmount = 8000;
        Calculation calculation = new Calculation(result, purchaseAmount);

        calculation.displayStatistics();

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("당첨 통계\r\n");
        expectedOutput.append("---\r\n");
        expectedOutput.append("3개 일치 (5,000원) - 1개\r\n");
        expectedOutput.append("4개 일치 (50,000원) - 0개\r\n");
        expectedOutput.append("5개 일치 (1,500,000원) - 0개\r\n");
        expectedOutput.append("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\r\n");
        expectedOutput.append("6개 일치 (2,000,000,000원) - 0개\r\n");
        expectedOutput.append("총 수익률은 62.5%입니다.");

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedOutput.toString().trim());

    }

}
