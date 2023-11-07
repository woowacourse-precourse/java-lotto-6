package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 티켓 1장을 발행한 후 출력한다.")
    @Test
    void produceLottoTicketTest() {
        // Given
        List<Integer> testTicket = Lotto.produceLottoTicket();

        // When & Then
        System.out.println(testTicket.toString());
    }

    @DisplayName("주어진 quantity만큼 로또 티켓을 발행한 후 출력한다. quantity에 대한 유효성 검증은 Purchase에서 이루어진다.")
    @Test
    void gatherLottoTicketsTest() {
        // Given
        int testQuantity = 5;

        // When & Then
        List<Lotto> testList = Lotto.gatherLottoTickets(testQuantity);
    }
}