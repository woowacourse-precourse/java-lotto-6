package lotto.service;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    @Test
    void 로또번호개수확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw().size()).isEqualTo(Lotto.LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또번호범위확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw())
                .allSatisfy(number -> Assertions.assertThat(number).isBetween(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
    }
}