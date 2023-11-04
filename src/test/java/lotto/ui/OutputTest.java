package lotto.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    public void setup() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("로또 구매 갯수를 출력하는 함수를 검증한다.")
    public void testPrintPurchaseCount() {
        //given
        int count = 5;
        String expectedOutput = "\n" + count + "개를 구매했습니다.\n";

        // when
        Output.printPurchaseCount(count);
        String actualOutput = outputMessage.toString();

        // then
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("로또 묶음을 출력하는 함수의 기능을 검증한다.")
    public void testPrintLottoBundle() {
        //given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        LottoBundle lottoBundle = new LottoBundle(lottos);
        String expectedOutput = "[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n";

        // when
        Output.printLottoBundle(lottoBundle);
        String actualOutput = outputMessage.toString();

        // then
        assertEquals(expectedOutput, actualOutput);
    }

}
