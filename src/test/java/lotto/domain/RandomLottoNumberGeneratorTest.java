package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomLottoNumberGeneratorTest {

    @Test
    @DisplayName("6자리 숫자를 생성한다.")
    void generateRandomNumbersTest() {
        //given
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();

        //when
        List<Integer> randomNumbers = randomLottoNumberGenerator.generateRandomNumbers();

        //then
        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}