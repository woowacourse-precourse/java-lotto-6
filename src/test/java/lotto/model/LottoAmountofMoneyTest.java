package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoAmountofMoneyTest {
    @Test
    void createLottoMoneyByNotNumberValue(){
        assertThatThrownBy(()-> new LottoAmountofMoney("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}