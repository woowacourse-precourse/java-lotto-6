package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
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

    @Test
    void 로또_번호들이_문자열로_정확히_변환되는지_테스트() {
        LottoOutput output = new LottoOutput();
        List<Integer> lottoNumbers = Arrays.asList(5, 12, 23, 34, 45, 56);
        String expectedMessage = "[5, 12, 23, 34, 45, 56]";
        assertEquals(expectedMessage, output.getLottoNumbersMessage(lottoNumbers));
    }

    @Test
    void 세_개의_로또_번호_리스트가_올바르게_출력되는지_테스트() {
        LottoOutput output = new LottoOutput();
        List<Integer> lottoNumbers1 = Arrays.asList(5, 12, 23, 34, 45, 56);
        List<Integer> lottoNumbers2 = Arrays.asList(6, 13, 24, 35, 46, 57);
        List<Integer> lottoNumbers3 = Arrays.asList(7, 14, 25, 36, 47, 58);

        String outputForThreeTickets = output.getLottoNumbersMessage(lottoNumbers1) + "\n" +
                output.getLottoNumbersMessage(lottoNumbers2) + "\n" +
                output.getLottoNumbersMessage(lottoNumbers3);

        String expectedOutput = "[5, 12, 23, 34, 45, 56]\n" +
                                "[6, 13, 24, 35, 46, 57]\n" +
                                "[7, 14, 25, 36, 47, 58]";

        assertEquals(expectedOutput, outputForThreeTickets);
    }
}
