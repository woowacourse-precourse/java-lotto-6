package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @DisplayName("로또 가격으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void validateDividedByLottoPrice(){
        int money = 1001;

        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Amount(money));
    }
}
