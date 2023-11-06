package lotto.domain.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class PurchaseTest {

    @DisplayName("투입한 금액을 1,000원으로 나눈 몫만큼 발행할 로또의 양을 리턴한다. paidPrice에 대한 검증이 이루어지므로 quantity는 자연수이다.")
    @Test
    void makePurchaseTest() {
        // Given
        String input = "5000";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Purchase purchase = new Purchase();

        // When
        int lottoQuantity = purchase.makePurchase();

        // Then
        Assertions.assertEquals(5, lottoQuantity);
    }

    @DisplayName("지불한 금액에 대한 유효성 검증을 테스트한다.")
    @Test
    void validatePriceTest() {
        // Given
        Purchase purchase = new Purchase();

        // When
        int validPrice = 2000;
        int invalidPrice = 1234;
        int zeroPrice = 0;

        // Then
        Assertions.assertDoesNotThrow(() -> purchase.validatePrice(validPrice));
        Assertions.assertThrows(IllegalArgumentException.class, () -> purchase.validatePrice(invalidPrice));
        Assertions.assertThrows(IllegalArgumentException.class, () -> purchase.validatePrice(zeroPrice));
    }
}