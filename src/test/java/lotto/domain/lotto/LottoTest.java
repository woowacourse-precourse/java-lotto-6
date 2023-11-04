package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given & when & then
        assertThatThrownBy(() -> Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // given & when & then
        assertThatThrownBy(() -> Lotto.createFrom(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createLotto_exception_outOfRangeNumber() {
        // given & when & then
        assertThatThrownBy(() -> Lotto.createFrom(List.of(0, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 숫자가 로또에 존재함을 확인할 수 있다.")
    @Test
    void contains() {
        // given
        Lotto lotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.contains(1);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("두 개 로또의 비교후 동일한 숫자의 개수를 찾을 수 있다.")
    @Test
    void extractSameCount() {
        // given
        Lotto firstLotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 7));

        // when
        int sameCount = firstLotto.extractSameCount(secondLotto);

        // then
        assertThat(sameCount).isEqualTo(5);
    }
}