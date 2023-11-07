package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RandomNumbersTest {
    @Test
    @DisplayName("만들어진 번호의 갯수는 6개이다.")
    void createdRandomNumbersHasSixNumber() {
        RandomNumbers randomNumbers = new RandomNumbers();

        List<Integer> sortedNumbers = randomNumbers.createRandomNumbers();
        assertThat(sortedNumbers).hasSize(6);
    }

}