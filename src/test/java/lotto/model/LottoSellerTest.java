package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSellerTest {
    private LottoSeller lottoSeller;

    @BeforeEach
    void beforeAll() {
        lottoSeller = new LottoSeller();
    }

    @DisplayName("구입 금액에 해당하는 만큼 발행해야할 로또 갯수를 계산할 수 있다.")
    @ParameterizedTest(name = "투입금액 : {0} , 로또 갯수 : {1}개")
    @CsvSource(value = {"1000,1", "15000,15", "20000,20"})
    void calculateLottoTickets(int purchasingMoney, int result) {
        assertThat(lottoSeller.calculateLottoTickets(purchasingMoney))
                .isEqualTo(result);
    }
}