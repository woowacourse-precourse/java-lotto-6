package lotto.validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusValidatorTest {

    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("보너스 번호 입력값에 숫자 이외의 값이 들어올 때 예외 처 테스트")
    public void input_validate_when_bonus_number_has_non_number() {
        assertThatThrownBy(() -> BonusValidator.validate("nonNumber" , winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
    }

    @Test
    @DisplayName("보너스 번호가 0보다 작을 때 예외 처리 테스트")
    void input_validate_when_less_than_zero() {
        assertThatThrownBy(() -> BonusValidator.validate("0" , winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 45보다 클 때 예외 처리 테스트")
    void input_validate_when_greater_than_max() {
        assertThatThrownBy(() -> BonusValidator.validate("46" , winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호랑 중복일 때 예외 처리 테스트")
    void input_validate_when_duplicate_with_winning_numbers() {
        assertThatThrownBy(() -> BonusValidator.validate("6", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
    }

}