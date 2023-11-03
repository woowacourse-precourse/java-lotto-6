package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("정답 번호와 동일한 보너스 번호일 경우 예외가 발생한다.")
    @Test
    void validateDuplicateBonusNumber() {
        // given
        List<Integer> answerNumber = List.of(1,2,3,4,5,6);
        int bonus = 1;
        BonusNumber bonusNumber = new BonusNumber();

        // when, then
        assertThatThrownBy(() -> bonusNumber.validateDuplicateBonusNumber(answerNumber, bonus))
                .isInstanceOf(IllegalArgumentException.class);

    }

}