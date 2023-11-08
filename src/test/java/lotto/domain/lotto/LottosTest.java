package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
    Lottos lottos;

    @BeforeEach
    void SetUp() {
        lottos = new Lottos();
    }

    @Test
    void 로또_추가() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        int expectedTicketsSize = 1;

        lottos.insertLotto(lotto);

        assertEquals(expectedTicketsSize, lottos.getLottoTickets().size());
    }
}
