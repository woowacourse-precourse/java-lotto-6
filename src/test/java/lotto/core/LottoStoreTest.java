package lotto.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.numbergenerator.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private InputStream originalIn;

    @BeforeEach
    public void setUpStreams() {
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void start() {
        OutputManager outputManager = new OutputManager();
        NumberGenerator numberGenerator = new NumberGenerator();
        Calculator calculator = new Calculator();
        LottoTicketScratcher lottoTicketScratcher = new LottoTicketScratcher();
        LottoStore storeForTest = LottoStore.createStoreForTest(lottoTicketScratcher, calculator, numberGenerator,
                outputManager);

        String input = "8000\n1,2,3,4,5,6\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        storeForTest.start();

        String output = outContent.toString();
        assertThat(output).contains("구입 금액을 입력해 주세요.");
        assertThat(output).contains("8개를 구매했습니다.");
        assertThat(output).contains("당첨 번호를 입력해 주세요.");
        assertThat(output).contains("보너스 번호를 입력해 주세요.");
        assertThat(output).contains("당첨 통계");
        assertThat(output).contains("총 수익률은");
    }
}