package lotto.lottoTest;

import lotto.Lotto;
import lotto.enums.LottoInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
private void validate(List<Integer> numbers) {
    Validation.validateInRange(numbers, MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber());
    Validation.validateLottoNumbersCount(numbers);
    Validation.validateDuplicate(numbers);
}
*/
public class ValidateTest {
    @Test
    public void 입력받은게_null_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(null));
    }
    @Test
    public void 생성자에_범위에_맞지_않는_숫자_오류발생() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(LottoInfo.MAX_NUMBER.getNumber()+i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(items) );
    }

    @Test
    public void 입력받은_수의_개수가_NUMBERS_OF_LOTTO_보다_작음_오류발생() {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i < LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(LottoInfo.MIN_NUMBER.getNumber()+i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(items) );
    }

    @Test
    public void 입력받은_수의_개수가_NUMBERS_OF_LOTTO_보다_큼_오류발생() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i <= LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(LottoInfo.MIN_NUMBER.getNumber()+i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(items) );
    }

    @Test
    public void 입력받은_수에_중복이_있음_오류발생() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(LottoInfo.MIN_NUMBER.getNumber());
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Lotto(items) );
    }

    @Test
    public void 정상입력_오류없음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < LottoInfo.NUMBERS_PER_LOTTO.getNumber(); i++) {
            items.add(LottoInfo.MIN_NUMBER.getNumber()+i);
        }
        Assertions.assertDoesNotThrow(
                () -> new Lotto(items) );
    }
}
