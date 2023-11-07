package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @DisplayName("로또 구매 금액이 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoTicketBy() {
        assertThatThrownBy(() -> new LottoTicket(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 티켓을 생성하면 오름차순으로 정렬된 번호로 출력된다.")
    @Test
    void lottoTicketIsSorted() {
        LottoTicket lottoTicket = new LottoTicket(6000); // 예를 들어 6000원어치의 로또 티켓 생성
        List<List<Integer>> tickets = lottoTicket.getTickets();

        // 정렬된 상태인지 확인
        for (List<Integer> ticket : tickets) {
            List<Integer> sortedTicket = new ArrayList<>(ticket);
            Collections.sort(sortedTicket);
            assertThat(sortedTicket).isSorted();
        }
    }


}
