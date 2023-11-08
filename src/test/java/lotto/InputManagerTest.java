package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputManagerTest{
    @DisplayName("문자열을 ','로 분리하고 각 요소를 정수로 변환하여 리스트로 반환한다.")
    @Test
    void parseNumbers() {
        InputManager inputManager = new InputManager();

        List<Integer> numbers = inputManager.parseNumbers("1,2,3,4,5,6");

        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
