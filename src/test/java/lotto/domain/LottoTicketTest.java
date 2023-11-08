package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

class LottoTicketTest {

    @DisplayName("유효한 번호들로 로또 티켓을 생성한다.")
    @Test
    void createValidLottoTicket() {
        LottoTicket ticket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(ticket).isNotNull();
        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("번호 개수가 6개 미만이면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNumbersAreLessThanSix() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 정확히 6개여야 합니다.");
    }

    @DisplayName("번호 개수가 6개 초과이면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNumbersAreMoreThanSix() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 정확히 6개여야 합니다.");
    }

    @DisplayName("번호에 중복된 값이 있으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNumbersAreDuplicated() {
        assertThatThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호에 중복된 숫자가 있습니다.");
    }
}
