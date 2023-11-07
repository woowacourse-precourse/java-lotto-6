package lotto.utils;

import lotto.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class GenerateLottoNumbersTest {
    private static final GenerateLottoNumbers generateLottoNumbers = new GenerateLottoNumbers();

    @DisplayName("로또 구매 수량 반환 기능 테스트")
    @Test
    public void getBuyingQuantityTest() {
        // given
        int buyingPrice = 10000;
        // when
        int result = generateLottoNumbers.getBuyingQuantity(buyingPrice);
        // then
        assertThat(result).isEqualTo(buyingPrice / Constants.LOTTO_PRICE);
    }
}
