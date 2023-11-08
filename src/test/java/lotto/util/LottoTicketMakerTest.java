package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketMakerTest {
    @DisplayName("로또 티켓을 만들어서 전달한다")
    @Test
    void createLottoTicket() {
        assertThat(new LottoTicketMaker().make(5)).isInstanceOf(List.class);
    }
}
