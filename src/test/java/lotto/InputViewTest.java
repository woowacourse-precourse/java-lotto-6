package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @DisplayName(",기준 split 변환 테스트")
    @Test
    void generateNumberListTest() {
        String winningString = "1,2,3,4,5,6";
        String[] result = winningString.split(",");

        for(int i = 0 ; i < result.length; i++){
            Assertions.assertThat(result[i]).isEqualTo("%d", (i+1));
        }
    }

    @DisplayName("문자를 숫자로 변환하는 테스트")
    @Test
    void convertToTest() {
        String numString = "1";
        Assertions.assertThat(Integer.parseInt(numString)).isEqualTo(1);
    }

    @DisplayName("문자를 숫자로 변환할때 때 문자가 숫자가 아닐 경우 예외 테스트")
    @Test
    void convertToExceptionTest() {
        String numString = "i";
        assertThatThrownBy(() -> Integer.parseInt(numString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
