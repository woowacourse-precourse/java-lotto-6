package lotto.view;

import lotto.config.WinningPrize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class OutputViewTest {
    private static ByteArrayOutputStream console;

    @BeforeEach
    void streamSetup() {
        console = new ByteArrayOutputStream();
        System.setOut(new PrintStream(console));
    }

    @AfterEach
    void streamRestore() {
        System.setOut(System.out);
    }

    @Test
    public void printBuyingCount() {
        OutputView.printBuyingCount(12);
        assertThat(console.toString())
                .contains("12개를 구매했습니다.");
    }

    @Test
    public void printEachLotto() {
        OutputView.printEachLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(console.toString())
                .contains("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void printEachResult() {
        OutputView.printEachResult(WinningPrize.SECOND_PLACE, 3);
        assertThat(console.toString())
                .contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 3개");
    }

    @DisplayName("수익률이 소숫점 둘째 자리에서 반올림이 제대로 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"72.24,72.2", "32.68,32.7", "42,42.0"})
    public void printProfitResult(double input, String answer) {
        OutputView.printProfitResult(input);
        assertThat(console.toString())
                .contains(String.format("총 수익률은 %s%%입니다.", answer));
    }
}
