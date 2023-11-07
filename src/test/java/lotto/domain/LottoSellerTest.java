package lotto.domain;

import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {
    LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());

    @DisplayName("구매자가 지불한 금액에 맞는 로또를 생성한다.")
    @Test
    void createLottoByCash() {
        Cash cash = new Cash(3000);

        assertThat(lottoSeller.sellLottos(cash).getSize()).isEqualTo(3);
    }

}