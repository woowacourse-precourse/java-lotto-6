package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OutputViewTest {

    @Test
    @DisplayName("메시지를 출력함")
    void printMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String message = "test message";
        OutputView.printMessage(message);
        assertEquals(message + "\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("빈 줄을 출력한다.")
    void printEmptyLine() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printEmptyLine();
        assertEquals("\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("로또 결과를 출력한다")
    void printResult() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = new LottoResult(winningNumbers);

        lottoResult.addResult(3, false);
        lottoResult.addResult(4, false);
        lottoResult.addResult(5, false);
        lottoResult.addResult(5, true);
        lottoResult.addResult(6, false);
        OutputView.printResult(lottoResult);

        String expectedOutput = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n";
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("로또 번호 목록을 출력한다")
    void printLottoNumbers() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        OutputView.printLottoNumbers(2, lottos);

        String expectedOutput = "2개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[7, 8, 9, 10, 11, 12]\n\n";
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    @DisplayName("수익률을 출력한다")
    void printWinningRate() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputView.printWinningRate(123.45);
        assertEquals("총 수익률은 123.45%입니다.\n", outContent.toString());
        System.setOut(System.out);
    }
}
