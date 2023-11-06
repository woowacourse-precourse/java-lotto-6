package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationTest {
    private final Calculation calculator = new Calculation();

    @Test
    public void whenNoNumbersMatch_thenCountShouldBeZero() {
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumber = List.of(7, 8, 9, 10, 11, 12);
        
        int count = calculator.compare_number(userNumber, lottoNumber);
        
        assertThat(count).isZero();
    }

    @Test
    public void whenSomeNumbersMatch_thenCountShouldBeCorrect() {
        List<Integer> userNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumber = List.of(4, 5, 6, 7, 8, 9);
        
        int count = calculator.compare_number(userNumber, lottoNumber);
        
        assertThat(count).isEqualTo(3); // Since 4, 5, and 6 are matching
    }
}
