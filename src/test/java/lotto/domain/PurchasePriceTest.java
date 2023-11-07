package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchasePriceTest {
    @DisplayName("로또 구입 금액이 숫자이지만, 양의 1000의 배수가 아니면 null이 반환된다.")
    @ParameterizedTest
    @CsvSource({"12", "0", "-1000"})
    void getNullByNonMultiplePrice(int price) {
        PurchasePrice actual = PurchasePrice.from(price);
        assertThat(actual).isEqualTo(null);
    }

    @DisplayName("로또 구입 금액이 양의 1000의 배수이면 해당 금액의 PurchasePrice가 생성된다.")
    @ParameterizedTest
    @CsvSource({"1000", "5000"})
    void getPurchasePriceByInputPrice(int price) {
        PurchasePrice purchasePrice = PurchasePrice.from(price);
        int actual = purchasePrice.getPrice();
        assertThat(actual).isEqualTo(price);
    }

    @DisplayName("로또 구입 개수는 로또 구입 금액을 1000으로 나눈 것이다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "5000,5"})
    void getCountByInputPrice(int price, int expected) {
        PurchasePrice purchasePrice = PurchasePrice.from(price);
        int actual = purchasePrice.getCount();
        assertThat(actual).isEqualTo(expected);
    }
}