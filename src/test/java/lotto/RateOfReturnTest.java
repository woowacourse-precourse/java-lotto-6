package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import lotto.service.generator.RateofReturn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    private PrintStream standardOut;
    private OutputStream captor;
    RateofReturn rateofreturn = new RateofReturn();

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

    final void run(long totalwinningmoney, long buymoney) {
        try {
            runMain(totalwinningmoney, buymoney);
        } finally {
            Console.close();
        }
    }

    @DisplayName("수익률 계산 확인")
    @Test
    public void RateOfReturn_테스트() {
        //given
        long totalwinningmoney = 5000;
        long buymoney1 = 8000;
        long buymoney2 = 9000;
        long buymoney3 = 10000;
        String prediction1 = "총 수익률은 62.5%입니다.";    //62.5%
        String prediction2 = "총 수익률은 55.6%입니다.";    //55.555555555...%
        String prediction3 = "총 수익률은 50.0%입니다.";    //50.0%
        //when1
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run(totalwinningmoney, buymoney1);
            assertThat(output()).contains(prediction1);
        });
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run(totalwinningmoney, buymoney2);
            assertThat(output()).contains(prediction2);
        });
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run(totalwinningmoney, buymoney3);
            assertThat(output()).contains(prediction3);
        });
    }

    public void runMain(long totalwinningmoney, long buymoney) {
        RateofReturn.CalculateRateOfReturn(totalwinningmoney, buymoney);
    }
}
