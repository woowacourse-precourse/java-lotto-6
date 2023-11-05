package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoShopTest {
    LottoShop lottoShop;

    @Test
    void createLottoTickets_test() {
        // given
        LottoMachine lottoMachine = new LottoMachine(new LottoNotRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
        int budget = 6000;

        List<Lotto> purchased = lottoShop.createLottoTickets(budget);
        int expected = budget / lottoMachine.getLottoTicketPrice();

        // when
        int actual = purchased.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getLottoPrice_test() {
        // given
        LottoMachine lottoMachine = new LottoMachine(new LottoNotRandomGenerator());
        lottoShop = new LottoShop(lottoMachine);
        int expected = lottoShop.getLottoTicketPrice();

        // when
        int actual = lottoMachine.getLottoTicketPrice();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
