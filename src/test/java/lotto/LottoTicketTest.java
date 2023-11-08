package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @DisplayName("로또 목록을 문자열로 전달한다.")
    @Test
    void createAscendingNumber() {
        assertThat(new LottoTicket(new LottoTicketMaker().make(2))
                .makeLottoToString())
                .anySatisfy(element -> Assertions.assertThat(element).isInstanceOf(String.class));
    }
}