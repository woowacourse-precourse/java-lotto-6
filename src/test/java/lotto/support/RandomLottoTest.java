package lotto.support;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomLottoTest {

    @Test
    void lottoTimes만큼_RandomLotto가생겨나는지() {
        RandomLotto randomLotto = new RandomLotto();
        Long lottoTimes = 3L;

        List<Lotto> lottos = randomLotto.RandomLottos(lottoTimes);
        assertThat(lottos.size()).isEqualTo(lottoTimes.intValue());

    }

}