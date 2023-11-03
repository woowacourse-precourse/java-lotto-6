package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.controller.InputConverter.convertPrice;

public class convertPriceTest {
    @DisplayName("입력받은 가격 정수형으로 후처리")
    @Test
    void convertPriceTest() {
        String inputPrice = "1000";
        int price = convertPrice(inputPrice);
        Assertions.assertThat(price).isEqualTo(1000);
    }
}
