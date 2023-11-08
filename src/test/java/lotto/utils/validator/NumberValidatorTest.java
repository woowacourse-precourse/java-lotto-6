package lotto.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberValidatorTest {
    private final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    private final Integer WINNING_BONUS_NUMBER = 20;
    private final Integer WINNING_BONUS_NUMBER_DUPLICATE = 6;
    @Test
    @DisplayName("당첨번호와 보너스 번호가 겹치지 않는 경우")
    void 당첨번호와_보너스_번호가_겹치지_않는_경우() throws Exception {
        //given
        // 상수에 있음
        //when then
        assertThatCode(() -> NumberValidator.duplicateBonusNumberCheck(WINNING_NUMBERS,WINNING_BONUS_NUMBER))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨번호와 보너스 번호가 겹치는 경우")
    void 당첨번호와_보너스_번호가_겹치는_경우() throws Exception {
        //given
        // 상수에 있음

        //when then
        assertThatThrownBy(() -> NumberValidator.duplicateBonusNumberCheck(WINNING_NUMBERS, WINNING_BONUS_NUMBER_DUPLICATE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}