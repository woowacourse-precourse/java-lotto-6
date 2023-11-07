package lotto.validation;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @DisplayName("숫자가 아닌 문자가 있는경우 예외가 발생한다")
    @Test
    public void 숫자가_아닌_문자가_있는경우_예외가_발생한다() {
        // given
        String amount = "1000j";

        // when
        // then
        assertThatThrownBy(() -> Validation.checkIsNumber(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000의 배수가 아니면 예외가 발생한다")
    @Test
    public void 천의_배수가_아니면_예외가_발생한다() {
        // given
        String amount = "2001";

        // when
        // then
        assertThatThrownBy(() -> Validation.checkIsDivideByThousand(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 길이가 맞지 않는 경우 예외가 발생한다")
    @Test
    public void 로또_길이가_맞지_않는_경우_예외가_발생한다() {
        // given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6, 7);
        int length = 6;

        // then
        assertThatThrownBy(() -> Validation.checkLottoNumberLength(length, lotto)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    public void 범위를_벗어난_숫자가_있으면_예외가_발생한다() {
        // given
        int start = 1;
        int end = 45;
        int num = 1000;

        // then
        assertThatThrownBy(() -> Validation.checkNumberIsBetweenStartAndEnd(start, end, num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자가 존재하면 예외가 발생한다")
    @Test
    public void 중복되는_숫자가_존재하면_예외가_발생한다() {
        // given
        List<Integer> lotto = List.of(1, 2, 3, 5, 5, 6);

        // then
        assertThatThrownBy(() -> Validation.checkDuplicate(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 중복되면 예외가 발생한다")
    @Test
    public void 보너스_번호가_중복되면_예외가_발생한다() {
        // given
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 1;

        // then
        assertThatThrownBy(() -> Validation.checkLottoNumbersHasBonusNumber(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 문자가 들어있으면 예외가 발생한다.")
    @Test
    public void 로또_번호에_문자가_들어있으면_예외가_발생한다() {
        String lotto = "1,2,3,a,5,6";
        assertThatThrownBy(() -> Validation.checkStringConsistOfNaturalNumbers(lotto.split(",")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}