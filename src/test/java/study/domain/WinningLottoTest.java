package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("보너스 넘버가 1 ~ 45의 숫자가 아니라면 에러를 발생시켜야 한다.")
    @Test
    void validate_범위가_아닌_수가_있는경우() {
        assertThatThrownBy(
                () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버가 로또에 있는수 라면 에러를 발생시켜야 한다.")
    @Test
    void validate_중복된_수가_있는경우() {
        assertThatThrownBy(
                () -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("정답 로또에 숫자가 잘 저장되는지 확인한다.")
    @Test
    void contains() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertTrue(winningLotto.contains(1));
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
