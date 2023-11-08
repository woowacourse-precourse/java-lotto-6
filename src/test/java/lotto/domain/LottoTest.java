package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

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

    @DisplayName("로또 번호 6개보다 작을 경우 예외 발생")
    @Test
    void validate_isRightLottoCnt() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 1보다 작을 경우 예외 발생")
    @Test
    void validate_isRightLottoRange1() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 45보다 클 경우 예외 발생")
    @Test
    void validate_isRightLottoRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 99)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행한 로또랑 잘 매칭되어 반한되는지 확인")
    @Test
    void matchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matchCount(myLotto)).isEqualTo(6);
    }
}