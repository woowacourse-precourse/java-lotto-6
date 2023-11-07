package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {
    private List<Integer> lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = List.of(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(ints = {800, 1200})
    @DisplayName("로또 티켓 구입 금액이 1000원 미만이거나 1000원의 배수가 아닐 때 예외가 발생한다.")
    void getTicketPriceByOverSize(int buyingCost) {
        assertThatThrownBy(() -> new LottoTicket(lottoNumber, buyingCost))
                .isInstanceOf(IllegalArgumentException.class);
    }
}