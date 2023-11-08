package lotto.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

class BounsNumberTest {
    @Test
    void createBonusNumberRangeOverByNegative(){
        assertThatThrownBy(() -> new BounsNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void createBonusNumberRangeOverByPositive(){
        assertThatThrownBy(() -> new BounsNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}