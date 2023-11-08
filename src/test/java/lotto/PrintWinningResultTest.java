package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintWinningResultTest {
    private static final int[] lottoResult = {100, 0, 0, 3, 2, 1};
    PrintWinningResult printWinningResult = new PrintWinningResult(lottoResult);

    @DisplayName("로또와 당첨 번호 비교 결과에 따른 올바른 결과가 출력된다.")
    @Test
    void createPrintLottoResult() {
        String expectedOutput =
                "3개 일치 (5,000원) - 0개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 3개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n";

        assertEquals(expectedOutput, printWinningResult.printLottoResult());
    }

    @DisplayName("보너스 번호에 1이상 45 이하의 수가 있으면 예외가 발생한다.")
    @Test
    void createPrintProfitResult() {
        double profitPercentage = 62.5;
        String expectedOutput = "총 수익률은 62.5%입니다.";

        assertEquals(expectedOutput, printWinningResult.printProfitResult(profitPercentage));
    }
}