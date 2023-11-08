package lotto.lottoPurchase.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseServiceTest {

    private LottoPurchaseService lottoPurchaseService;

    @BeforeEach
    public void InsultMoneyEach() {
        lottoPurchaseService = new LottoPurchaseService();
    }

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 구매 개수에 따른 로또를 발행한다.")
    @Test
    void 구매_금액에_따른_실물_로또_발행() {
        String input = "6000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        lottoPurchaseService.process();

        assertThat(out.toString()).contains("6개를 구매했습니다.");
    }

}
