package lotto;

import model.Purchase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchasePriceTest {

    @Test
    void 구매금액입력(){
        Purchase purchase = new Purchase();
        purchase.Number(14000);
        int result = purchase.getPurchaseNumber();
        assertThat(result).isEqualTo(14);
    }
}
