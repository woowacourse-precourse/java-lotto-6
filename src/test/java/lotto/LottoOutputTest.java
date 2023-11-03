package lotto;

import lotto.view.LottoOutput;
import org.junit.jupiter.api.Test;

public class LottoOutputTest {

    @Test
    void 로또_구매_개수_출력_테스트() {
        LottoOutput lottoOutput = new LottoOutput();
        lottoOutput.printNumberOfTickets(5);
    }
}
