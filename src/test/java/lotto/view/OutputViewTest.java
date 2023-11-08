package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 구매금액_출력테스트() {
        OutputView.promptForBuyAmount();
        assertThat(outContent.toString()).isEqualTo("구입금액을 입력해 주세요. ");
    }

    @Test
    void 수익률_출력테스트() {
        OutputView.printBenefits(52.22);
        assertThat(outContent).isEqualTo("총 수익률은 52.2%입니다.");
    }
}