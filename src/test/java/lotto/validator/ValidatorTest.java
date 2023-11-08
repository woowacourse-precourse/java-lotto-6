package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("숫자가 아니면 예외 처리")
    @Test
    void isNumberTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isNumber("1000j"));
    }

    @DisplayName("1000원보다 돈이 적으면 예외 처리")
    @Test
    void isOverThousandTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isOverThousand(0));
    }

    @DisplayName("1000원으로 나누어 떨이지지 않으면 예외 처리")
    @Test
    void divideByThousandTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.divideByThousand(1500));
    }

    @DisplayName("로또에 중복된 수 있으면 예외 처리")
    @Test
    void haveDuplicateTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.haveDuplicate(List.of(1, 2, 3, 4, 5, 5)));
    }

    @DisplayName("로또 번호 6개가 아니면 예외 처리")
    @Test
    void isSixNumberTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isSixNumber(List.of(1, 2, 3, 4, 5)));
    }

    @DisplayName("숫자가 로또 숫자 범위가 아니면 예외 처리")
    @Test
    void isInRangeTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isInRange(46));
    }

    @DisplayName("보너스와 당첨 로또번호가 중복되면 예외 처리")
    @Test
    void isNotDuplicateTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isNotDuplicate(1, List.of(1, 2, 3, 4, 5, 6)));
    }
}
