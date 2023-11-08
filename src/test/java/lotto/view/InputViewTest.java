package lotto.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private static List<Integer> numbers;

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,a,b", "1.2.3.4.5.6"})
    @DisplayName("올바르지 않은 입력값")
    void wrongInput(String inputNumber){
        assertThatThrownBy(()-> InputView.numberList(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
