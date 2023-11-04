package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("객체생성 중복 예외테스트")
    public void duplicateExceptionTest() {
        List<Integer> invalidList = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "6";

        assertThatThrownBy(() -> new WinnigNumbers(invalidList,bonusNumber)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("객체생성 숫자 범위 예외테스트")
    public void rangeExceptionTest() {
        List<Integer> invalidList = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "46";

        assertThatThrownBy(() -> new WinnigNumbers(invalidList,bonusNumber)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
