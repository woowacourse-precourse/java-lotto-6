package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BuyPrice;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyPriceTest {
    @DisplayName("1000원 단위의 입력이 아니라면 예외가 발생한다.")
    @Test
    void inputBuyPriceValidateTest(){
        assertThatThrownBy(() -> new BuyPrice(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
