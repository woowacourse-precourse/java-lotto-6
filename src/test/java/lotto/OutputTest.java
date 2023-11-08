package lotto;

import lotto.constants.PrizeEnum;
import lotto.io.OutputHandler;
import org.junit.jupiter.api.*;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }
    @DisplayName("수익률 출력 테스트.")
    @Test
    void test_print_return_rate() {
        OutputHandler.printReturnRate(0.6255);
        assertThat(output()).contains("총 수익률은 62.6%입니다.");
    }
    @DisplayName("최소 수익률 출력 테스트.")
    @Test
    void test_print_return_rate_min() {
        OutputHandler.printReturnRate(0);
        assertThat(output()).contains("총 수익률은 0.0%입니다.");
    }

    @DisplayName("최대 수익률 출력 테스트.")
    @Test
    void test_print_return_rate_max() {
        OutputHandler.printReturnRate(2_000_000);
        assertThat(output()).contains("총 수익률은 200000000.0%입니다.");
    }

    @DisplayName("상금 출력 테스트.")
    @Test
    void test_print_prize()  {
        OutputHandler.printPrize(PrizeEnum.FIFTH.getComment(), PrizeEnum.FIFTH.getAmount(), 1);
        assertThat(output()).contains("3개 일치 (5,000원) - 1개");
    }
}
