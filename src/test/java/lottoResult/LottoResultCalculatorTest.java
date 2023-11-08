package lottoResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @DisplayName("리스트를 비교하여 일치하는 값의 개수를 반환한다.")
    @Test
    void CountMatchingValuesInLists() {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        int score = calculateScore(userNumbers, winningNumbers);
        assertThat(score).isEqualTo(4); // Assuming 4 numbers match
    }

    private int calculateScore(List<Integer> userNumbers, List<Integer> winningNumberList) {
        int score = 0;
        for (int userNumber : userNumbers) {
            score += countMatches(userNumber, winningNumberList);
        }
        return score;
    }

    private int countMatches(int userNumber, List<Integer> winningNumberList) {
        if (winningNumberList.contains(userNumber)) {
            return 1;
        }
        return 0;
    }
}