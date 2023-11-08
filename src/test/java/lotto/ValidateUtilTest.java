package lotto;

import lotto.domain.ValidateUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateUtilTest {

    @Test
    void stringToArrayListTest() {
        List<Integer> expectedOutput = Arrays.asList(1, 3, 4, 5);
        List<Integer> numbers = ValidateUtil.stringToArrayList("1,3 , 4,5");
        assertThat(numbers)
                .isEqualTo(expectedOutput);

        expectedOutput = Arrays.asList(1, 4, 5);
        numbers = ValidateUtil.stringToArrayList("1,4,5");
        assertThat(numbers)
                .isEqualTo(expectedOutput);

        assertThatThrownBy(() -> ValidateUtil.toNumeric("a,1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void toNumericTest() {
        ;
        assertThat(ValidateUtil.toNumeric("11"))
                .isEqualTo(11);

        assertThatThrownBy(() -> ValidateUtil.toNumeric("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 숫자가 특정 두 숫자 사이의 값이 아니면 예외발생")
    @Test
    void isInRangeTest() {
        assertThatThrownBy(() -> ValidateUtil.isInRange(10,15,20))
                .isInstanceOf(IllegalArgumentException.class);
    }
}