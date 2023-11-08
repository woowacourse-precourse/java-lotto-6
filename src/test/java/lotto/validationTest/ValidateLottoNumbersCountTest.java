package lotto.validationTest;

import lotto.Validation;
import lotto.enums.LottoInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
public static void validateLottoNumbersCount(List<Integer> lotto) {
    if (lotto.size() != LottoInfo.NUMBERS_PER_LOTTO.getNumber()) {
        throw new IllegalArgumentException(ErrorMessage.NOT_EQUAL_LOTTO_LENGTH.getMessage());
    }
}
*/
public class ValidateLottoNumbersCountTest {
    @Test
    public void 입력받은_수의_개수가_NUMBERS_PER_LOTTO_보다_1개_작음_오류있음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i < LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateLottoNumbersCount(items));
    }

    @Test
    public void 입력받은_수의_개수가_NUMBERS_PER_LOTTO_와_같음_오류없음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i <= LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(i);
        }
        Assertions.assertDoesNotThrow(
                () -> Validation.validateLottoNumbersCount(items));
    }

    @Test
    public void 입력받은_수의_개수가_NUMBERS_PER_LOTTO_보다_1개_많음_오류있음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i <= LottoInfo.NUMBERS_PER_LOTTO.getNumber()+1; i++) {
            items.add(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateLottoNumbersCount(items));
    }
}
