package lotto.view.output;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import lotto.view.output.writer.ConsoleWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 출력 뷰")
class LottoPrizeOutputViewTest {

    private LottoPrizeOutputView lottoPrizeOutputView;
    private ConsoleWriter mockConsoleWriter;

    @BeforeEach
    void setUp() {
        mockConsoleWriter = mock(ConsoleWriter.class);
        lottoPrizeOutputView = new LottoPrizeOutputView(mockConsoleWriter);
    }

    @Test
    @DisplayName("당첨 번호 입력 메시지를 출력합니다.")
    void Should_Print_Input_Prize_Number_Message() {
        //when
        lottoPrizeOutputView.printInputPrizeNumberMessage();

        //then
        verify(mockConsoleWriter).println("당첨 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("보너스 번호 입력 메시지를 출력합니다.")
    void Should_Print_Input_Bonus_Number_Message() {
        //when
        lottoPrizeOutputView.printInputBonusNumberMessage();

        //then
        verify(mockConsoleWriter).println("보너스 번호를 입력해 주세요.");
    }
}
