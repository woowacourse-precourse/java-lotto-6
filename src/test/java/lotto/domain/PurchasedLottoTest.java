package lotto.domain;

import lotto.utils.numbergenerators.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PurchasedLottoTest {


    @DisplayName("구입 금액에 맞춰 로또를 발급한다.")
    @Test
    void issueLotto() {
        // given
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        List<Lotto> lottos = purchasedLotto.issueLotto(3000, randomNumberGenerator);

        // then
        assertThat(lottos.size()).isEqualTo(3);
    }
}