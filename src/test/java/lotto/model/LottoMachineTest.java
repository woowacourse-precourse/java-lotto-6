package lotto.model;

import static lotto.util.ExceptionMessage.TICKET_COUNT_IS_NULL;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

    @Test
    void 로또갯수만큼_Lotto를_발행한다() {
        LottoMachine lottoMachine = new LottoMachine(3);

        int ticketCount = lottoMachine.getIssuedLotto().size();

        assertEquals(ticketCount, 3);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,[ERROR] 구매 갯수는 최소 1개 이상이어야 합니다.",
        "-1,[ERROR] 구매 갯수는 최소 1개 이상이어야 합니다.",
    })
    void 로또갯수는_0이하이면_안된다(Integer ticketCount, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new LottoMachine(ticketCount));
        assertEquals(e.getMessage(), exceptionMessage);
    }

    @Test
    void 로또갯수는_null_이어서는_안된다() {
        NullPointerException e = assertThrows(NullPointerException.class,
            () -> new LottoMachine(null));
        assertEquals(e.getMessage(), TICKET_COUNT_IS_NULL.getMessage());
    }

}