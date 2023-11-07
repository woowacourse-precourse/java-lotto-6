package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class InputHandlerTest {
    @DisplayName("split 메서드로 주어진 값을 구분한다.")
    @Test
    void splitLottoNumbers() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

//    @DisplayName("올바르지 않은 숫자 형식을 입력했을 때 예외가 발생한다.")
//    @Test
//    void inputInvalidNumberFormat() {
//
//    }
}
