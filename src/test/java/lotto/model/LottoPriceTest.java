package lotto.model;
import static org.junit.jupiter.api.Assertions.*;

import lotto.util.ErrorMessage;
import lotto.util.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPriceTest {
    @ParameterizedTest
    @DisplayName("금액에 정수 형이 아닌 글자가 입력 된다.")
    @ValueSource(strings = {"천원", "1000원}"})
    public void 정수형이_아닌_입력이_들어온다(String input) {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new LottoPrice(input);
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_PRICE_MUST_BE_INTEGER.getMessage());

    }

    @ParameterizedTest
    @DisplayName("금액이 1000원 이하인 숫자가 입력된다.")
    @ValueSource(strings = {"100", "50"})
    public void 천원_이하의_숫자가_들어온다(String price) {
        IllegalArgumentException illegalArgumentException=assertThrows(CustomException.class, () -> {
            new LottoPrice(price);
        });
        assertEquals(illegalArgumentException.getMessage(), ErrorMessage.LOTTO_PRICE_MUST_UP_1000.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액이 1000원 단위가 아니다.")
    @ValueSource(strings = {"1500", "3450"})
    public void 천원_단위가_아닌_숫자가_들어온다(String price) {
        IllegalArgumentException illegalArgumentException = assertThrows(CustomException.class, () -> {
            new LottoPrice(price);
        });
        assertEquals(illegalArgumentException.getMessage(),ErrorMessage.LOTTO_PRICE_MUST_MULTIPLY_1000.getMessage());
    }

    @ParameterizedTest
    @DisplayName("올바른 금액이 입력된다.")
    @ValueSource(strings = {"1000", "5000"})
    public void 올바른_금액이_입력된다(String price) {
        assertNotNull(new LottoPrice(price));
    }
}
