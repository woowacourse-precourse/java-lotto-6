package lotto;

import lotto.util.Convert;
import lotto.util.ExceptionHandling;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConvertTest {
    @DisplayName("문자열에서 숫자로 변환이 잘되는지 확인한다.")
    @Test
    void 문자열_숫자_변환_확인() {
        String input = "34";
        int result=Convert.convertToNumber(input);
        assertThat(result).isEqualTo(34);
    }
    @DisplayName("문자열에서 숫자리스트로 변환이 잘되는지 확인한다.")
    @Test
    void 문자열_숫자_리스트_변환_확인() {
        String input = "1,3,4";
        List<Integer> result=Convert.convertToNumbers(input);
        assertThat(result).contains(1,3,4);
    }
}
