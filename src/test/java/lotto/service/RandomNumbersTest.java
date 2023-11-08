package lotto.service;

import lotto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    @Test
    void 로또번호개수확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw().size()).isEqualTo(LottoNumber.NUMBER_COUNT.getNumber());
    }

    @Test
    void 로또번호범위확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw())
                .allSatisfy(number -> Assertions.assertThat(number)
                        .isBetween(LottoNumber.MIN_NUMBER.getNumber(), LottoNumber.MAX_NUMBER.getNumber()));
    }
}