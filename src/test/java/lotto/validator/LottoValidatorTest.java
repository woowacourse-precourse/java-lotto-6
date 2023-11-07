package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    BasicValidator<List<Integer>> lottoValidator = new LottoValidator();

    @Test
    void 로또_번호에_대한_입력값_검증() {
        assertThatThrownBy(() -> lottoValidator.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6자리 이어야 합니다.");

        assertThatThrownBy(() -> lottoValidator.validate(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1과 45 사이여야 합니다.");

        assertThatThrownBy(() -> lottoValidator.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");

    }
}