package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @DisplayName("당첨 번호를 저장한다.")
    @Test
    void saveWinningNumbers() {
        //Given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Winning winning = new Winning();
        //When
        winning.setNumbers(numbers);
        //Then
        assertThat(winning.getNumbers()).isEqualTo(numbers);
    }
}