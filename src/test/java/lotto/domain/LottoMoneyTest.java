package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoMoneyTest {
    @DisplayName("로또 구입 금액은 1000원 이상이어야 한다.")
    @Test
    void validateMoney() {
        assertThatThrownBy(() -> new LottoMoney(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입한 로또 갯수를 반환한다.")
    @Test
    void getLottoCount() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        assertThat(lottoMoney.getLottoCount()).isEqualTo(1);
    }
}