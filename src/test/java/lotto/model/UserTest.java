package lotto.model;

import static lotto.exception.InvalidLottoException.InvalidLottoError.DUPLICATE_LOTTO;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_RANGE;
import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("보너스 번호가 최대값을 초과하면 예외가 발생한다.")
    public void 보너스_번호가_최대값을_초과하면_예외가_발생한다() {
        //given
        int overMaxNumber = LOTTO_MAX_NUMBER + 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when & then
        assertThatThrownBy(() -> new User(lotto, overMaxNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 최소값 미만이면 예외가 발생한다.")
    public void 보너스_번호가_최소값_미만이면_예외가_발생한다() {
        //given
        int underMinNumber = LOTTO_MIN_NUMBER - 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when & then
        assertThatThrownBy(() -> new User(lotto, underMinNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복이면 예외가 발생한다.")
    public void 보너스_번호가_로또_번호와_중복이면_예외가_발생한다() {
        //given
        int duplicateNumber = 6;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, duplicateNumber));

        //when & then
        assertThatThrownBy(() -> new User(lotto, duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_LOTTO.getMessage());
    }
}
