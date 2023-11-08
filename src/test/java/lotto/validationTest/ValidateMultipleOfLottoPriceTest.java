package lotto.validationTest;

import lotto.Validation;
import lotto.enums.LottoInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
public static void validateMultipleOfLottoPrice(int x) {
    if (x%LOTTO_PRICE.getNumber() != 0) {
        throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
    }
}
*/
public class ValidateMultipleOfLottoPriceTest {
    @Test
    public void 로또_가격의_배수_오류없음() {
        Assertions.assertDoesNotThrow(
                () -> Validation.validateMultipleOfLottoPrice(LottoInfo.LOTTO_PRICE.getNumber()*12));
    }

    @Test
    public void 로또_가격의_배수아님_오류있음() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateMultipleOfLottoPrice(LottoInfo.LOTTO_PRICE.getNumber()-1));
    }
}
