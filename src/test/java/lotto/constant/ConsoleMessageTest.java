package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleMessageTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("인자가 없는 메세지 출력 테스트")
    void printNoArgumentsMessage() {
        // given
        ConsoleMessage inputPriceMsg = ConsoleMessage.INPUT_BUY_PRICE;
        String expectedInputPriceMsg = "구매금액을 입력해 주세요.\n";

        // when
        inputPriceMsg.print();

        // then
        assertThat(outContent.toString()).isEqualTo(expectedInputPriceMsg);

    }

    @Test
    @DisplayName("구매 장수 입력시 출력 테스트")
    void buyMessage() {
        // given
        ConsoleMessage buyMessage = ConsoleMessage.BUY;
        int lottoCount = 8;
        String expectedBuyMessage = "8개를 구매했습니다.\n";

        // when
        buyMessage.print(lottoCount);

        // then
        assertThat(outContent.toString()).isEqualTo(expectedBuyMessage);
    }

    @Test
    @DisplayName("수익률 출력 테스트")
    void rateOfReturnMessage() {
        // given
        ConsoleMessage rateOfReturnMsg = ConsoleMessage.RATE_OF_RETURN;
        double rateOfReturn = 62.455;
        String expectedRateOfReturnMsg = "총 수익률은 62.5%입니다.\n";

        // when
        rateOfReturnMsg.print(rateOfReturn);

        // then
        assertThat(outContent.toString()).isEqualTo(expectedRateOfReturnMsg);
    }

}
