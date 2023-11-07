package lotto.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyNumberTest {
    @DisplayName("올바르게 생성되었는지 확인")
    @Test
    void createRightMoney(){
        MoneyNumber moneyNumber = new MoneyNumber("5000");
        Assertions.assertEquals(moneyNumber.toString(),"5000");
    }
}
