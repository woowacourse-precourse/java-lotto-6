package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomLottoNumberGeneratorTest {

    RandomLottoNumberGenerator randomLottoNumberGenerator;
    List<Integer> randomNumbers;
    @BeforeEach
    void setUp() {
        randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        randomNumbers = randomLottoNumberGenerator.generateRandomNumbers();
    }

    @Test
    @DisplayName("중복되지 않는6자리 숫자를 생성한다.")
    void generateSixNumbersTest() {
        //given

        //when

        //then
        assertThat(randomNumbers.stream().distinct().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("생성한 6자리 숫자는 오름차순으로 정렬되어 있다.")
    void sortedTest() {
        //given
        boolean flag = true;

        //when
        for (int i = 1; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i - 1) > randomNumbers.get(i)) {
                flag = false;
            }
        }

        //then
        assertThat(flag).isEqualTo(true);
    }

    @Test
    @DisplayName("생성한 6자리 숫자는 1 ~ 45 범위 내 숫자이다.")
    void NumberRangeTest() {
        //given

        //when

        //then
        assertThat(randomNumbers.stream().filter(num -> num < 1 || num > 45).count()).isEqualTo(0);
    }
}