package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    public void testCreateWinningNumberWithBonusNumberDuplicate() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        int bonusNumber = 3;

        assertThrows(DuplicateNumberException.class, () -> {
            new WinningNumber(new Lotto(numbers), bonusNumber);
        });
    }

    @Test
    public void testCreateWinningNumberWithoutDuplicateNumber() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int bonusNumber = 4;

        assertThrows(InvalidNumberException.class, () -> {
            new WinningNumber(new Lotto(numbers), bonusNumber);
        });
    }

    @Test
    public void testCreateWinningNumberWithDuplicateNumber() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        int bonusNumber = 4;

        assertThrows(DuplicateNumberException.class, () -> {
            new WinningNumber(new Lotto(numbers), bonusNumber);
        });
    }


}