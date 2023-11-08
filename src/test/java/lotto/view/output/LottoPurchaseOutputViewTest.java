package lotto.view.output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import lotto.view.output.writer.ConsoleWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구입 출력 뷰")
class LottoPurchaseOutputViewTest {
    private LottoPurchaseOutputView lottoPurchaseOutputView;
    private ConsoleWriter mockConsoleWriter;

    @BeforeEach
    void setUp() {
        mockConsoleWriter = mock(ConsoleWriter.class);
        lottoPurchaseOutputView = new LottoPurchaseOutputView(mockConsoleWriter);
    }

    @Test
    @DisplayName("로또 구입 금액 입력 메시지를 출력합니다.")
    void Should_Print_Input_Prize_Number_Message() {
        //when
        lottoPurchaseOutputView.printInputPurchasingAmountMessage();

        //then
        verify(mockConsoleWriter).println("구입금액을 입력해 주세요.");
    }
}
