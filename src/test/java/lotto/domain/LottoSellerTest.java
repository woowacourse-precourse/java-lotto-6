package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        lottoSeller = new LottoSeller();
    }

    @DisplayName("로또 구입 개수를 계산하는 기능 테스트")
    @Test
    void calculateNumberOfLottosTest() {
        int money = 2_000;
        int expectedAmount = 2;

        int lottoAmount = lottoSeller.calculateNumberOfLottos(money);

        assertThat(lottoAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("로또가 금액에 맞게 알맞은 수량으로 생성되는지 테스트")
    @Test
    void getLottosTest() {
        int money = 2_000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(money);
        int expectedAmount = 2;

        Lottos lottos = lottoSeller.getLottos(purchaseAmount);

        assertThat(lottos.getLottoAmount()).isEqualTo(expectedAmount);
    }
}