package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @DisplayName("로또를 생성하고 구매 개수만큼 발행하고 사이즈와 숫자 범위를 검증한다.")
    @Test
    void createLottoTicketTest() {
        int numberOfPurchase = 10;
        LottoTicket lottoTicket = new LottoTicket(10);
        List<Lotto> purchasedLottoTicket = lottoTicket.getLottoTicket();

        assertThat(purchasedLottoTicket).hasSize(numberOfPurchase);
        purchasedLottoTicket.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers).hasSize(6);
            numbers.forEach(number -> assertThat(number).isBetween(1, 45));
        });
    }
}