package lotto.domain;

import lotto.constant.NumericConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    LottoFactory lottoFactory = new LottoFactory(new DefualtLottoNumbersGenerator());
    @Test
    @DisplayName("만들어진 로또의 갯수는, 인자로 넘겨준 값과 같아야한다.")
    void createdLottoSizeTest() {
        int count = 0;
        List<Lotto> lottos = lottoFactory.createLottos(count);

        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}