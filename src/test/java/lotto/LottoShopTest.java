package lotto;

import static lotto.Properties.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoShop;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoShopTest {

    private final LottoShop lottoShop = LottoShop.ofPrice(LOTTO_PRICE);

    @DisplayName("로또 1장의 가격은 1000원이다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3", "4000,4", "5000,5"})
    void lottoPrice(long money, int numberOfPlays) {
        LottoTicket ticket = lottoShop.issueLottoTicket(money);
        assertThat(ticket.getPlayCount()).isEqualTo(numberOfPlays);
    }
}
