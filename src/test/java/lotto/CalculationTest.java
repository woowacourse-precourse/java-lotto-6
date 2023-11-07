package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    private final Calculation calculator = new Calculation();

    @Test
    public void 숫자비교테스트_안겹침() {
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumber = List.of(7, 8, 9, 10, 11, 12);
        
        int count = calculator.compare_number(userNumber, lottoNumber);
        
        assertThat(count).isZero();
    }

    @Test
    public void 숫자비교테스트_3개겹침() {
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumber = List.of(4, 5, 6, 7, 8, 9);
        
        int count = calculator.compare_number(userNumber, lottoNumber);
        
        assertThat(count).isEqualTo(3); // Since 4, 5, and 6 are matching
    }

    @Test
    public void get_score_test() {
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonus_number = 7;
        int[] scoreNumber = {0,0,0,0,0,0,0,0};
        int[] expected_score = {0,0,0,0,0,0,0,2};

        calculator.get_score(userNumber,lottoNumber,bonus_number,scoreNumber);
        calculator.get_score(userNumber,lottoNumber,bonus_number,scoreNumber);

        assertEquals(scoreNumber[6],expected_score[6],"The expected list does not match the actual list.");
    }
}
