package lotto.domain;

import lotto.utils.numbergenerators.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class PurchasedLottoTest {


    @DisplayName("구입 금액에 맞춰 로또를 발급하고 발급된 로또를 반환한다.")
    @Test
    void issueLotto() {
        // given
        PurchasedLotto purchasedLotto = PurchasedLotto.of(3000, RandomNumberGenerator.getInstance());

        // when, then
        assertThat(purchasedLotto.getPurchasedLotto().size()).isEqualTo(3);
    }
}