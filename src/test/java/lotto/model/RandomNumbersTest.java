package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersTest {

    @DisplayName("입력값만큼 로또를 생성하는지 확인한다.")
    @Test
    void checkLottoPapersNumber() {
        int lottoPapers = 12;
        Integer answer = 12;
        RandomNumbers randomNumbers = new RandomNumbers(lottoPapers);

        assertThat(randomNumbers.getSizeOfRandomNumbers()).isEqualTo(answer);

    }
}
