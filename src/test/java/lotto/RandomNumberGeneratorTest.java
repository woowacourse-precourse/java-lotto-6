package lotto;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        randomNumbers = randomNumberGenerator.createNewRandomNumber();
    }

    @DisplayName("생성된 랜덤 번호의 크기가 6인지 확인하는 테스트")
    @Test
    void createRandomNumberHasCorrectSize() {
        assertThat(randomNumbers).hasSize(6);
    }

    @DisplayName("생성된 랜덤 번호의 각 번호가 1에서 45사이에 있는지 확인하는 테스트")
    @Test
    void createRandomNumberHasCorrectRange() {
        assertThat(randomNumbers).allMatch(value -> value >= 1 && value <= 45);
    }

    @DisplayName("생성된 랜덤 번호가 중복되지 않는지 확인하는 테스트")
    @Test
    void createRandomNumberWithOutDuplicated() {
        assertThat(randomNumbers).doesNotHaveDuplicates();
    }

    @DisplayName("생성된 랜덤 번호가 오름차순으로 정렬됐는지 확인하는 테스트")
    @Test
    void createRandomNumberByAscending() {
        assertThat(randomNumbers).isSortedAccordingTo(Integer::compareTo);
    }
}
