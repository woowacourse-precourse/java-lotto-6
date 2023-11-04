package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.view.LottoOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoOutputTest {

    private LottoOutput lottoOutput;

    @BeforeEach
    void setUp() {
        lottoOutput = new LottoOutput();
    }

    @Test
    void 구매금액_입력_메시지_반환_테스트() {
        String expectedMessage = "구매금액을 입력해 주세요.";
        String actualMessage = lottoOutput.requestAmountMessage();
        assertEquals(expectedMessage, actualMessage, "구매금액 입력 메시지가 올바르지 않습니다.");
    }

    @Test
    void 구매한_티켓_수_메시지_반환_테스트() {
        int ticketCount = 5;
        String expectedMessage = "5개를 구매했습니다.";
        String actualMessage = lottoOutput.printNumberOfTicketsMessage(ticketCount);
        assertEquals(expectedMessage, actualMessage, "구매한 티켓 수 메시지가 올바르지 않습니다.");
    }
}
