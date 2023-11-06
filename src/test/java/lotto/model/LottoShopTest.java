package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoShopTest {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";
    LottoShop lottoShop;

    @BeforeEach
    void init_lottoShop() {
        LottoMachine lottoMachine = new LottoMachine(new LottoNotRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
    }

    @DisplayName("구입할 때 지불한 금액이 양수가 아니면 예외가 발생해야 한다. 예외가 발생하지 않으면 테스트에 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -100, 0})
    void 구입_금액_양수_예외_테스트(int money) {
        assertThatThrownBy(() -> {
            lottoShop.createLottoTickets(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER);
    }

    @DisplayName("구입할 때 지불한 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생해야 한다. 예외가 발생하지 않으면 테스트에 실패한다.")
    @ParameterizedTest
    @ValueSource(ints = {100, 1100})
    void 구입_금액_1000단위_예외_테스트(int money) {
        assertThatThrownBy(() -> {
            lottoShop.createLottoTickets(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEADER);
    }

    @DisplayName("구입한 금액에 맞는 개수의 로또가 구입됐는지 테스트한다. 예상한 개수와 다르면 테스트에 실패한다.")
    @Test
    void 구입한_로또_개수_테스트() {
        // given
        int budget = 6000;

        List<Lotto> purchased = lottoShop.createLottoTickets(budget);
        int expected = budget / lottoShop.getLottoTicketPrice();

        // when
        int actual = purchased.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
