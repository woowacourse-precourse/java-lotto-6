package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_숫자가_1에서_45_범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLotto.INVALID_RANGE_MESSAGE);
    }

    @Test
    void 올바른_당첨_로또_번호() {
        List<Integer> validNumbers = List.of(11, 12, 13, 14, 15, 16);

        WinningLotto winningLotto = new WinningLotto(validNumbers);

        assertEquals(validNumbers, winningLotto.getWinningNumber().getNumbers());
    }

    @Test
    void 보너스_번호가_중복되면_예외가_발생한다() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> winningLotto.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLotto.DUPLICATE_NUMBER_MESSAGE);
    }

    @Test
    void 올바른_보너스_번호() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        int validNumber = 17;

        winningLotto.setBonusNumber(validNumber);

        assertEquals(validNumber, winningLotto.getBonusNumber());
    }
}