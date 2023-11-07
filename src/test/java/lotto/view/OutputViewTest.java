package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

import lotto.domain.LottoResultCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }
    @Test
    @DisplayName("Test printAboutPurchase method")
    void testPrintAboutPurchase() {
        // Arrange
        int amount = 2;
        List<Lotto> purchaseLotto = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );

        // Act
        // Redirect console output for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printAboutPurchase(amount, purchaseLotto);

        // Restore standard output
        System.setOut(System.out);

        String expectedOutput = """

                2개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [7, 8, 9, 10, 11, 12]
                """;

        // Assert
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    @DisplayName("Test outputWinningResult method")
    void testOutputWinningResult() {
        // Arrange
        LottoResultCount lottoResultCount = new LottoResultCount();
        lottoResultCount.addFourCount();
        double rate = 2500.0;

        // Act
        // Redirect console output for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.outputWinningResult(lottoResultCount, rate);

        // Restore standard output
        System.setOut(System.out);

        String expectedOutput = """
                
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 2500.0%입니다.""";

        // Assert
        assertEquals(expectedOutput, outputStream.toString());
    }
}
