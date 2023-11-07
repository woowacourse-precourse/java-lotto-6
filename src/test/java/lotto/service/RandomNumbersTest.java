package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {

    @Test
    void 로또번호개수확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw().size()).isEqualTo(6);
    }

    @Test
    void 로또번호범위확인() {
        RandomNumbers randomNumbers = new RandomNumbers();
        Assertions.assertThat(randomNumbers.draw())
                .allSatisfy(number -> Assertions.assertThat(number).isBetween(1, 49));
    }


}