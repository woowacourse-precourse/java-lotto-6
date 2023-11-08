package lotto.validationTest;

import lotto.Lotto;
import lotto.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
public static void validateDuplicate(List<Integer> lotto) {
    if (lotto.size() != lotto.stream().distinct().count()) {
        throw new IllegalArgumentException(ErrorMessage.NOT_DISTINCT_LIST.getMessage());
    }
}

public static void validateDuplicate(Lotto lotto, int number) {
    if (lotto.isInclude(number)) {
        throw new IllegalArgumentException(ErrorMessage.ALREADY_INCLUDED_NUMBER.getMessage());
    }
}
*/
public class ValidateDuplicateTest {
    @Test
    public void 입력_리스트에_중복된_숫자_오류있음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(i % 5 == 0 ? 5 : i % 5);
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateDuplicate(items));
    }

    @Test
    public void 입력_리스트에_중복된_숫자_없음_오류없음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(i+1);
        }
        Assertions.assertDoesNotThrow(
                () -> Validation.validateDuplicate(items));
    }

    @Test
    public void 로또에_있는_숫자_입력_오류있음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(i+1);
        }
        Lotto lotto = new Lotto(items);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateDuplicate(lotto, 1));
    }

    @Test
    public void 로또에_없는_숫자_입력_오류없음() {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            items.add(i+1);
        }
        Lotto lotto = new Lotto(items);
        Assertions.assertDoesNotThrow(
                () -> Validation.validateDuplicate(lotto, 7));
    }
}
