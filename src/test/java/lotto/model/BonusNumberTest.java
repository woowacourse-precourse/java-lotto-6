package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void createBonusNumberRangeOverByNegative(){
        assertThatThrownBy(() -> new BonusNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void createBonusNumberRangeOverByPositive(){
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}