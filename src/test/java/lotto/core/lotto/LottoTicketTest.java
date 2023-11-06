package lotto.core.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import lotto.core.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개 미만이라면 예외가 발생한다.")
    @Test
    void createLottoByLowerSize() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverNumberRange() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}