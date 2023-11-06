package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendorTest {

    @Test
    @DisplayName("지불한 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다")
    void purchaseLotto_NotDivided1000_ThrownException() {
        // given
        BigDecimal paymentAmount = BigDecimal.valueOf(1200);
        LottoVendor lottoVendor = new LottoVendor();

        // when
        // then
        assertThatThrownBy(() -> lottoVendor.purchaseLotto(paymentAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지불한 금액이 1,000원으로 나누어 떨어지는 경우 로또를 몫만큼 발행한다.")
    void purchaseLotto_Divided1000() {
        // given
        BigDecimal paymentAmount = BigDecimal.valueOf(2000);
        LottoVendor lottoVendor = new LottoVendor();

        // when
        List<Lotto> lottos = lottoVendor.purchaseLotto(paymentAmount);

        // then
        assertAll(
                () -> assertThat(lottos).isNotNull(),
                () -> assertThat(lottos).hasSize(2)
        );
    }
}
