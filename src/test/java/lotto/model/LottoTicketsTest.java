package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = new LottoTickets();
    }

    @DisplayName("Lotto를 성공적으로 추가한다")
    @Test
    void addLottoSuccessfully() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTickets.addLotto(lotto1);
        lottoTickets.addLotto(lotto2);

        assertEquals(2, lottoTickets.getLottoTickets().size());
        assertEquals(lotto1, lottoTickets.getLottoTickets().get(0));
    }
}