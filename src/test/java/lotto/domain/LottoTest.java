package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또번호가 6자리 미만일 때 예외 처리 테스트.")
    @Test
    void verification1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(InvalidNumbersSizeException.class, () -> {
            new Lotto(numbers);
        });
    }

    @DisplayName("로또번호 중복될 때 예외 처리 테스트.")
    @Test
    void verification2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(DuplicateNumberException.class, () -> {
            new Lotto(numbers);
        });
    }
}
