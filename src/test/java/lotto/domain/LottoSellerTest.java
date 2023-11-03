package lotto.domain;

import static lotto.constant.message.ErrorMessage.HAS_REMAINDER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {
    LottoSeller seller = new LottoSeller();

    @DisplayName("입력받은 돈이 1000원 단위가 아니라면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {300, 1234, 1030})
    void checkRemainder(int money) {
        assertThatThrownBy(() ->
                seller.checkRemainder(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HAS_REMAINDER);
    }

    @DisplayName("필요한 개수만큼 올바른 로또를 발행하는지 검수")
    @Test
    void makeLottoTickets() {
        seller.checkRemainder(3000);
        assertDoesNotThrow(() -> {
            List<Lotto> tickets = seller.makeLottoTickets();
            assertThat(tickets.size()).isEqualTo(3);
        });
    }
}