package lotto.domain;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {
    @DisplayName("구입 금액 만큼 로또를 생성 한다")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000, 6000})
    void issueLottoPerAttempt(int amount) {
        LottoStore lottoStore = new LottoStore(amount);

        while (lottoStore.isOpen()) {
            lottoStore.issueLotto();
        }

        assertThat(lottoStore.getIssuedLotto().size())
                .isEqualTo(amount / LOTTO_PRICE.getValue());
    }
}