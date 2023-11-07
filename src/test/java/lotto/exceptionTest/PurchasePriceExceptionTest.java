package lotto.exceptionTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.exception.PurchasePriceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasePriceExceptionTest extends NsTest {
    @Test
    @DisplayName("입력 값이 숫자로만 이루어진 경우, 아닌경우")
    void 구매가격_형식_검증() {
        // given
        String purchasePrice1 = "1000";
        String purchasePrice2 = "abc";

        // when & then
        Assertions.assertDoesNotThrow(() -> PurchasePriceException.validateOnlyNumeric(purchasePrice1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PurchasePriceException.validateOnlyNumeric(purchasePrice2));
    }

    @Test
    @DisplayName("입력 값이 int 범위를 벗어나지 않는 경우, 아닌경우")
    void Integer_최대범위_내_구매가격_검증() {
        // given
        String purchasePrice1 = "1000";
        String purchasePrice2 = "2147483648";

        // when & then
        Assertions.assertDoesNotThrow(() -> PurchasePriceException.validateNumberInRangeIntMax(purchasePrice1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PurchasePriceException.validateNumberInRangeIntMax(purchasePrice2));
    }

    @Test
    @DisplayName("입력 값이 최대값을 넘어가지 않는 경우, 아닌경우")
    void 설정된_범위_내_구매가격_검증(){
            // given
            int purchasePrice1 = 2147483000; //MAX_PURCHASE_PRICE
            int purchasePrice2 = 2147483001; //MAX_PURCHASE_PRICE+1

            // when & then
            Assertions.assertDoesNotThrow(() -> PurchasePriceException.validateNumberInRange(purchasePrice1));
            Assertions.assertThrows(IllegalArgumentException.class, () -> PurchasePriceException.validateNumberInRange(purchasePrice2));
    }

    @Test
    @DisplayName("입력 값이 로또 가격보다 크거나 같은 경우, 작은 경우")
    void 구매가격_최소치_이상_검증() {
        // given
        int purchasePrice1 = 1000;//LOTTO_PRICE
        int purchasePrice2 = 900;//LOTTO_PRICE-100

        // when & then
        Assertions.assertDoesNotThrow(() -> PurchasePriceException.validateSmallerthanLottoPrice(purchasePrice1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PurchasePriceException.validateSmallerthanLottoPrice(purchasePrice2));
    }

    @Test
    @DisplayName("입력 값이 천의 배수인 경우, 아닌경우")
    void 구매가격_1000의_배수인지_확인() {
        // given
        int purchasePrice1 = 2000;
        int purchasePrice2 = 2500;

        // when & then
        Assertions.assertDoesNotThrow(() -> PurchasePriceException.validateMultipleOfThousand(purchasePrice1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PurchasePriceException.validateMultipleOfThousand(purchasePrice2));

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
