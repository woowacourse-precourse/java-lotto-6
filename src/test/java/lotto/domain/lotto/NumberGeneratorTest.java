package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
        randomNumbers = numberGenerator.createRandomNumbers();
    }

    @DisplayName("숫자 List를 생성한다.")
    @Test
    void createIntegerList() {
        assertThat(numberGenerator.createRandomNumbers()).isInstanceOf(List.class);
    }

    @DisplayName("6개의 숫자를 생성한다.")
    @Test
    void generateSixNumbers() {
        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @DisplayName("생성된 숫자는 1~45 사이의 수여야 한다.")
    @Test
    void pickNumber() {
        List<Integer> wrongNumbers = new ArrayList<>();
        for (int number : randomNumbers) {
            if (number < 1 || number > 45) {
                wrongNumbers.add(number);
            }
        }
        assertThat(wrongNumbers.size()).isEqualTo(0);
    }

    @DisplayName("중복값이 없어야 한다.")
    @Test
    void hasNotDuplicate() {
        assertThat(randomNumbers.stream().distinct().count()).isEqualTo(randomNumbers.size());
    }
}