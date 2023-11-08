package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    public final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 당첨번호가_보너스번호와_중복되는지_검증에_실패하면_예외발생() {
        // given
        List<Integer> givenWinnerLottoNumber = List.of(1, 2, 3, 4, 5, 6);

        // when
        assertThatThrownBy(() -> BonusNumber.fromStringWitValidateWinningNumber("5", givenWinnerLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 보너스번호는_반환할_수_있어야_함() {
        // given
        Integer givenBonusNumber = 7;
        List<Integer> givenWinnerLottoNumber = List.of(1, 2, 3, 4, 5, 6);

        // when
        BonusNumber bonusNumber = BonusNumber.fromStringWitValidateWinningNumber("7", givenWinnerLottoNumber);
        Integer number = bonusNumber.getBonusNumber();
        
        // then
        assertThat(number).isEqualTo(givenBonusNumber);
    }
}
