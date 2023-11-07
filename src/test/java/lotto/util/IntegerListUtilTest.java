package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.validation.IntegerListValidator;
import org.junit.jupiter.api.Test;

public class IntegerListUtilTest {

    @Test
    public void 문자를_구분자로_구분하여_정수리스트_생성() {
        // Given
        String numbersWithComma = "1,2,3";
        List<Integer> numbers = List.of(1,2,3);

        // When
        List<Integer> result = IntegerListUtil.parseListseperatedBy(
                numbersWithComma,",");

        // Then
        assertThat(result).isEqualTo(numbers);
    }

    @Test
    public void 문자를_구분자로_구분하여_정수리스트_생성_정수가아니면_예외발생() {
        // Given
        String numbersWithComma = "1,2,k";

        // When && Then
        assertThatThrownBy(() -> IntegerListUtil.parseListseperatedBy(
                numbersWithComma,","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수 범위의 값이 필요합니다.");
    }
}
