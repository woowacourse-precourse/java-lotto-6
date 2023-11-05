package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class LottoControllerTest {
    private final LottoController lottoController = TestConstant.testLottoConfig.lottoController();

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @DisplayName("로또 구매부터 추첨까지 과정을 수행한다.")
    @Test
    void run() {
        setConsoleInput(String.valueOf(TestConstant.minPaymentAmount), "1,2,3,4,5,6", "45");
        lottoController.run();

        assertThat(output()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 200,000.0% 입니다."
        );
    }

    private String output() {
        return captor.toString().trim();
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private void setConsoleInput(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
