package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}