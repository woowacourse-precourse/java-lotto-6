package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.TotalWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    @DisplayName("돈이 1000원으로 나눠 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void 돈이_천원으로_나눠_떨어지지_않는_경우_테스트() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 1000원보다 작을 경우 예외가 발생한다.")
    @Test
    void 돈이_천원보다_적을_경우_테스트() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45사이가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_범위_내의_숫자가_아닐_경우_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호들의 값이 6개가 아닌 경우 예외가 발생한다")
    @Test
    void 로또_번호_값들이_6개가_아닌_경우_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또번호에_중복이_있는_경우_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45사이에 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위_내의_숫자가_아닌_경우_테스트() {
        //given
        int bonusNumber = 47;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new TotalWinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복인 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복된_경우_테스트() {
        //given
        int bonusNumber = 5;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThatThrownBy(() -> new TotalWinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
