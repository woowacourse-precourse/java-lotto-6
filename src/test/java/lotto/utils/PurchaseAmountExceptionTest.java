package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseAmountExceptionTest{
    PurchaseAmountException purchaseAmountException = new PurchaseAmountException();

    @Test
    void 숫자가_아닌_값을_입력한_경우() {
        assertThrows(IllegalArgumentException.class, () ->
                        purchaseAmountException.notNumeric("a"), "[ERROR]숫자를 입력하세요.");
    }

    @Test
    void 숫자가_1000_단위로_나누어_떨어지지_않을_경우 (){
        assertThrows(IllegalArgumentException.class, () ->
                purchaseAmountException.notDivisible("1001"), "[ERROR]1000으로 나누어 떨어지지 않습니다.");
    }
}
