package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EvaluatorTest {
    @DisplayName("로또 번호 6개 중 보너스 번호와 일치하는 숫자가 있다면 예외가 발생한다.")
    @Test
    void createEvaluatorWithDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 3;
        assertThatThrownBy(() -> new Evaluator(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}