package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("수익률 출력 정상 작동 테스트")
    @Test
    void showProfitTest() {
        Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
        prizeCounts.put(LottoPrize.matchSix, 1);
        prizeCounts.put(LottoPrize.matchFive, 2);
        int money = 5000;

        Profit.showProfit(prizeCounts, money);
        String systemOut = outputStream.toString();

        DecimalFormat decimalFormat = new DecimalFormat("#,###.#%");
        double profitRate = Profit.calculateProfitRate(2003000000, money);
        String expectedOutput = String.format("총 수익률은 %s입니다.", decimalFormat.format(profitRate / 100.0));
        assertThat(systemOut).contains(expectedOutput);
    }
}