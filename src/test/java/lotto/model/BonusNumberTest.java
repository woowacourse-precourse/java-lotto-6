package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void createBonusNumberRangeOverByNegative(){
        assertThatThrownBy(() -> new BonusNumber(-1, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void createBonusNumberRangeOverByPositive(){
        assertThatThrownBy(() -> new BonusNumber(50, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void createBonusNumberDuplicated(){
        List<Integer> lotto = new ArrayList<>();
        lotto.add(1);
        lotto.add(2);
        lotto.add(3);
        lotto.add(4);
        lotto.add(5);
        lotto.add(6);
        Lotto lottoTest = new Lotto(lotto);
        assertThatThrownBy(() -> new BonusNumber(1, lottoTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

}