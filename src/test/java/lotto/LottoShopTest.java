package lotto;

import static lotto.Properties.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.model.LottoShop;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoShopTest {

    private final LottoShop lottoShop = LottoShop.ofPrice(LOTTO_PRICE);

    @DisplayName("로또 1장의 가격은 1000원이다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "3000,3", "4000,4", "5000,5"})
    void lottoPrice(long money, int numberOfPlays) {
        LottoTicket ticket = lottoShop.issueLottoTicket(money);
        assertThat(ticket.numberOfPlays()).isEqualTo(numberOfPlays);
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(longs = {0, 500, 999})
    void invalidMoneyLessThanLottoPrice(long money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoShop.issueLottoTicket(money));
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(longs = {1012, 2023, 3034, 4045, 5056})
    void invalidMoneyNotMultipleOfLottoPrice(long money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoShop.issueLottoTicket(money));
    }
}
