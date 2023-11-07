package lotto;

import java.util.List;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.constant.ErrorConst.LOTTO_COUNT_NOT_SIX;
import static lotto.domain.constant.ErrorConst.LOTTO_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다")
    void createLottoByUnderSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5));
        }).withMessage(LOTTO_COUNT_NOT_SIX);
    }

    @Test
    @DisplayName("로또 번호 중 45보다 큰 번호가 있으면 예외가 발생한다")
    void createLottoByOutOfMaximumNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 46));
        }).withMessage(LOTTO_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("로또 번호 중 1보다 작은 번호가 있으면 예외가 발생한다")
    void createLottoByOutOfMinimumNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(List.of(1, 2, 3, 0, 5, 6));
        }).withMessage(LOTTO_OUT_OF_RANGE);
    }

    @Test
    @DisplayName("모든 검증을 통과하면 로또 번호가 발행된다")
    void createLottoSuccessfully() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();

        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}