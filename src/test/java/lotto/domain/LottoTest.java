package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void 여섯자리_숫자를_입력하지_않은_경우_예외를_던진다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 중복되는_숫자를_입력한_경우_예외를_던진다() {
        List<Integer> numbers = List.of(1, 1, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 숫자의_범위가_1_미만인_로또번호가_존재할_경우_예외를_던진다() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 숫자의_범위가_45_초과인_로또번호가_존재할_경우_예외를_던진다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 로또가_요구사항에_맞는_숫자로_이루어진_경우_예외를_던지지_않는다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @Test
    void 로또_내에_보너스_번호가_포함되어_있는_경우_true_를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 1;

        assertTrue(lotto.contains(bonusNumber));
    }

    @Test
    void 로또_내에_보너스_번호가_포함되어있지_않은_경우_false_를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        assertFalse(lotto.contains(bonusNumber));
    }

    @Test
    void 로또_결과가_6개_일치인_경우_해당하는_Result를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto compareLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, compareLotto);
        Result expected = Result.SIX_MATCH;

        Result actual = lotto.countMatch(compareLotto, bonusNumber);

        assertEquals(expected, actual);
    }
}