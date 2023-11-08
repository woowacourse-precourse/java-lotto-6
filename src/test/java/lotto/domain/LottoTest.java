package lotto.domain;

import static lotto.global.exception.ErrorMessage.DUPLICATED_NUMBER_ERROR;
import static lotto.global.exception.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호_개수_초과() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6),
                Number.valueOf(7)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 중복된_로또_번호_예외_발생() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(5)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 개수를 정상적으로 반환한다.")
    void 로또_번호_개수_계산() {
        assertThat(Lotto.from(List.of(
                        Number.valueOf(1),
                        Number.valueOf(2),
                        Number.valueOf(3),
                        Number.valueOf(4),
                        Number.valueOf(5),
                        Number.valueOf(6)))
                .getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("특정 번호가 로또 번호에 속하면 true를 반환한다.")
    void 특정_번호가_포함된_경우_포함_검사() {
        assertThat(Lotto.from(List.of(
                        Number.valueOf(1),
                        Number.valueOf(2),
                        Number.valueOf(3),
                        Number.valueOf(4),
                        Number.valueOf(5),
                        Number.valueOf(6)))
                .contains(Number.valueOf(4)))
                .isEqualTo(true);
    }

    @Test
    @DisplayName("특정 번호가 로또 번호에 속하지 않으면 false를 반환한다.")
    void 특정_번호가_포함되지_않은_경우_포함_검사() {
        assertThat(Lotto.from(List.of(
                        Number.valueOf(1),
                        Number.valueOf(2),
                        Number.valueOf(3),
                        Number.valueOf(4),
                        Number.valueOf(5),
                        Number.valueOf(6)))
                .contains(Number.valueOf(8)))
                .isEqualTo(false);
    }
}
