package lotto.view;

import lotto.config.WinningPrize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void printProfitResult() {
        OutputView.printProfitResult(73.2F);
        assertThat(console.toString())
                .contains("총 수익률은 73.2%입니다.");
    }
}
