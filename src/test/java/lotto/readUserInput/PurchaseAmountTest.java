package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void beforeSetUp() {
        purchaseAmount = new PurchaseAmount();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 로또구매() {
        String money = "7000";
        System.setIn(new ByteArrayInputStream(money.getBytes()));
        purchaseAmount.read();
        Assertions.assertThat(purchaseAmount.purchasedAmountPrint()).isEqualTo("7개를 구매했습니다.");
    }

}