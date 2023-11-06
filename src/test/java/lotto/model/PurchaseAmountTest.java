package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountTest {
    private static final String errMessage = "구매 금액은 숫자형으로 입력해주세요";

    @Test
    void 구매금액이_나누어떨어지는가(){
        assertThatThrownBy(() ->{
            PurchaseAmount purchaseAmount = new PurchaseAmount();
            purchaseAmount.IsInputPriceDividedPurchasePrice(3001);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액이_0이아닌가(){
        assertThatThrownBy(() ->{
            PurchaseAmount purchaseAmount = new PurchaseAmount();
            purchaseAmount.IsNotZero(0);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
