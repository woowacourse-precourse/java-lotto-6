package lotto.model;

import static lotto.view.exception.InputException.BONUS_NUMBER_ALREADY_USE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCompanyTest {

    @Test
    @DisplayName("정답 번호와 보너스 번호가 서로 독립적이면 정상 생성된다.")
    void allNumberUniqueTest() {
        // given
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("7");

        // when & then
        assertDoesNotThrow(() -> LottoCompany.of(goalNumbers, bonusNumber));
    }

    @Test
    @DisplayName("정답 번호와 보너스 번호가 겹치면 예외가 발생한다.")
    void bonusNumberAlreadyUsedExceptionTest() {
        // given
        GoalNumbers goalNumbers = GoalNumbers.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.from("6");

        // when & then
        assertThatThrownBy(() -> LottoCompany.of(goalNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_ALREADY_USE.getMessage());
    }
}
