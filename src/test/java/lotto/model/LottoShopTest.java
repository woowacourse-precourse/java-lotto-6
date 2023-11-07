package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
    LottoShop lottoShop;

    @BeforeEach
    void init_lottoShop() {
        LottoMachine lottoMachine = new LottoMachine(new LottoNotRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
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
