package lotto.validator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    @DisplayName("로또 숫자의 개수가 6이 아닐 때 예외 처리 테스트")
    void input_validate_when_size_not_6(){
        assertThatThrownBy(() -> LottoValidator.validate(new ArrayList<>(List.of(1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또는 반드시 6개 숫자를 가져야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 때 예외 처리 테스트")
    void input_validate_when_duplicates(){
        assertThatThrownBy(() -> LottoValidator.validate(new ArrayList<>(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복 숫자가 존재합니다.");
    }

    @Test
    @DisplayName("로또 숫자 중 하나가 1보다 작을 때 예외 처리 테스트")
    void input_validate_when_number_less_than_min() {
        assertThatThrownBy(() -> LottoValidator.validate(new ArrayList<>(List.of(0, 1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 숫자 중 하나가 45보다 클 때 예외 처리 테스트")
    void input_validate_when_number_greater_than_max() {
        assertThatThrownBy(() -> LottoValidator.validate(new ArrayList<>(List.of(1,2,3,4,5,46))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("로또 숫자가 오름차순이 아닐 때 예외 처리 테스트")
    void input_validate_when_not_ascending_order() {
        assertThatThrownBy(() -> LottoValidator.validate(new ArrayList<>(List.of(1, 2, 3, 4, 40, 30))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 오름 차순으로 정렬되어야 합니다.");
    }
}