package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("1부터 45까지의 숫자가 아닌경우 예외가 발생한다")
    @Test
    void notArrangeNumber(){
        int number = 46;
        assertThatThrownBy(() -> BonusNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1부터 45까지의 숫자인 경우 BonusNumer생성되는지")
    @Test
    void CorrectNumber(){
        int number = 44;
        assertTrue(BonusNumber.create(number) instanceof BonusNumber);
    }
}
