package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {
    private RandomNumbers randomNumbers;
    @BeforeEach
    void beforeSetUp() {
        randomNumbers = new RandomNumbers();
    }

    @Test
    void 로또번호개수확인() {
        randomNumbers.draw();
        Assertions.assertThat(RandomNumbers.numbers.size()).isEqualTo(6);
    }

    @Test
    void 로또번호범위확인() {
        randomNumbers.draw();
        Assertions.assertThat(RandomNumbers.numbers)
                .allSatisfy(number -> Assertions.assertThat(number).isBetween(1, 49));
    }


}