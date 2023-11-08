package lotto;

import lotto.model.lotto.Lotto;
import lotto.util.generator.NumberGenerator;
import lotto.util.generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 임의의_6자리_숫자로_이루어진_로또를_발행한다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Lotto lotto = new Lotto(numberGenerator);
        System.out.println(lotto.getNumbers());
        assertEquals(lotto.getNumbers().size(), 6);
    }

    @Test
    void 로또_번호는_1부터_45_사이의_서로_다른_숫자이다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 당첨_번호가_1부터_45_사이_숫자가_아닐_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨_번호_중_중복된_숫자가_존재할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 중 중복된 숫자가 존재합니다.");
    }
}