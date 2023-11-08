package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {
    @ParameterizedTest
    @CsvSource({"999, 0", "1000,1", "3000, 3", "10000, 10"})
    @DisplayName("구매 금액 소진시까지 로또를 구입한다.")
    void purchaseLottoUntilZero(int amount, int size) {
        //given
        Money money = Money.from(amount);
        LottoStore lottoStore = new LottoStore(new LottoNumberGenerator());
        //when
        //then
        Assertions.assertThat(lottoStore.purchaseLottoTickets(money).getSize()).isEqualTo(size);
    }
}