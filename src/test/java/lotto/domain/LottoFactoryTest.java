package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @DisplayName("구입한 금액에 수량에 맞는 로또가 발행된다.")
    @Test
    void create() {
        // given
        int money = 5000;


        // when
        LottoFactory lottoFactory = LottoFactory.create(new RandomNumberGenerator(), money);

        // then
        assertThat(lottoFactory.getLottoNumbers()).hasSize(5);
    }

}