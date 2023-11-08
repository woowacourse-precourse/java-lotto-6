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

    @Test
    void createLottoMoneyByNotPositiveValue(){
        assertThatThrownBy(()-> new LottoAmountofMoney("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoMoneyByNotDivided(){
        assertThatThrownBy(()-> new LottoAmountofMoney("1999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createLottoMoneyByZero(){
        assertThatThrownBy(()-> new LottoAmountofMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}