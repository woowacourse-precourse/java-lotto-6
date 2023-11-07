package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.lottoGenerateMethod.LottoAutoGenerateMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsGeneratorTest {

    @Test
    @DisplayName("단 하나의 인스턴스를 가져야 한다")
    void getInstance() {
        //given
        LottoTicketsGenerator instance = LottoTicketsGenerator.getInstance();

        //when
        LottoTicketsGenerator otherInstance = LottoTicketsGenerator.getInstance();

        //then
        assertEquals(instance, otherInstance);
    }

    @Test
    @DisplayName("주어진 개수만큼 로또가 생성되어야 한다.")
    void needToGenerateGivenNumberOfLottoTicket() {
        //given
        int count = 3;
        LottoTicketsGenerator instance = LottoTicketsGenerator.getInstance();

        //when
        LottoTickets lottoTickets = instance.generateLottoTickets(count, new LottoAutoGenerateMethod());

        //then
        assertEquals(count, lottoTickets.size());
    }

}