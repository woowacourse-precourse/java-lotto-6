package lotto.domain;

import lotto.domain.number.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @DisplayName("입력받은 갯수만큼 로또를 랜덤으로 생성 한다.")
    @Test
    void createRandomLottos() {
        LottoFactory lottoFactory = new LottoFactory(new RandomNumberGenerator());
        int count = 20;
        LottoBundle lottoBundle = lottoFactory.createBundle(count);

        Assertions.assertThat(lottoBundle.getLottos()).hasSize(20);
    }
}