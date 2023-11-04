package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.OutputView;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void testPrintPurchase() {
        //given
        int number = 8;
        String expected = "8개를 구매했습니다.";

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printPurchase(number);

        // then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    void testPrintLottos() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        String expected =
                "[1, 2, 3, 4, 5, 6]\n" +
                "[7, 8, 9, 10, 11, 12]\n";

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printLottos(lottos);

        // then
        assertEquals(expected, outputStream.toString().trim());
    }   // 콘솔상으로 보이는 값은 같으나 에러가 Failed 발생. 추후 Bug Fix 필요.

    @Test
    void testPrintPrizeStatistics() {
        // given
        List<Integer> prizeCounts = List.of(5, 4, 3, 2, 1);
        String expected =
                "당첨 통계\n---\n" +
                "3개 일치 (5,000원) - 5개\n" +
                "4개 일치 (50,000원) - 4개\n" +
                "5개 일치 (1,500,000원) - 3개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n";
        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printPrizeStatistics(prizeCounts);

        // then
        assertEquals(expected, outputStream.toString().trim());
    }   // 콘솔상으로 보이는 값은 같으나 에러가 Failed 발생. 추후 Bug Fix 필요.

    @Test
    void testPrintRateOfReturn() {
        // given
        double rate = 48.26;
        String expected = "총 수익률은 48.3%입니다.";

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        OutputView.printRateOfReturn(rate);

        // then
        assertEquals(expected, outputStream.toString().trim());
    }
}
