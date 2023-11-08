package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {

    @DisplayName("입력한 돈 만큼 로또가 발행 된다.")
    @Test
    void checkNumberOfLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateRandomNumbers(5);
        List<List<Integer>> tmpgenerated = randomNumberGenerator.getRandomNumbers();

        assertEquals(5, tmpgenerated.size());
    }

    @DisplayName("각 로또 번호는 6자리여야 한다.")
    @Test
    void checkNumberOfLottoNums() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateRandomNumbers(5);
        List<List<Integer>> tmpgenerated = randomNumberGenerator.getRandomNumbers();
        for (List<Integer> singleLotto : tmpgenerated) {
            assertEquals(6, singleLotto.size()); // 각 로또 번호는 6자리여야 합니다.

        }

    }

    @DisplayName("각 로또 번호는 1부터 45 사이여야 한다.")
    @Test
    void checkNumberBoundary() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateRandomNumbers(5);
        List<List<Integer>> tmpgenerated = randomNumberGenerator.getRandomNumbers();
        for (List<Integer> singleLotto : tmpgenerated) {
            for (int number : singleLotto) {
                assert (number >= 1 && number <= 45);
            }

        }

    }

}
