package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {
    @DisplayName("1부터 45사이의 숫자를 생성하는 지 확인 한다")
    @RepeatedTest(100)
    void generateRandomNumbersBetweenOneAndFortyFive() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Integer> actual = numberGenerator.generateNumbers();

        assertThat(actual).allMatch(i -> i >= 1 && i <= 45);
    }

}