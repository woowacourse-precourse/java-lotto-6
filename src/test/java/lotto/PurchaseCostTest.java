package lotto;

import lotto.domain.PurchaseCost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseCostTest {


    @DisplayName("당첨번호 입력 기능이 잘 작동하는가?")
    @Test
    void PurchaseFunctionCheck(){
        PurchaseCost purchaseCost = new PurchaseCost("8000");
        Assertions.assertEquals(purchaseCost.getPurchaseCost(), 8);
    }


    @DisplayName("숫자가 아닌 경우 예외 발생")
    @Test
    void isPurchaseCostNumeric(){
        PurchaseCost purchaseCost = new PurchaseCost("8000");
        assertThatThrownBy(() -> purchaseCost.validateNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0보다 작거나 같은 경우 예외 발생")
    @Test
    void isLottoZeroOrNegative(){
        PurchaseCost purchaseCost = new PurchaseCost("8000");
        assertThatThrownBy(() -> purchaseCost.validateNegativeNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("입력받은 로또 구입 금액을 1000천 단위로 입력 받지 않은 경우")
    @Test
    void isLottoThousandsUnit(){
        PurchaseCost purchaseCost = new PurchaseCost("8000");
        assertThatThrownBy(() -> purchaseCost.validateNumberUnit("5302"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
