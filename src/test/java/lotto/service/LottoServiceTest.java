package lotto.service;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("당첨 번호 길이 검증")
    void testInvalidSizeThrowsException() {
        List<Integer> numbersWithInvalidSize = Arrays.asList(1, 2, 3, 4); // Incorrect size

        assertThrows(LottoException.class, () -> {
            LottoException.ensureValidSize(numbersWithInvalidSize);
        });
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 LottoException을 발생")
    void testDuplicatesThrowException() {
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 3, 4, 5); // 중복된 숫자 포함

        assertThrows(LottoException.class, () -> {
            LottoException.ensureDistinctNumbers(numbersWithDuplicates);
        });
    }

    @Test
    @DisplayName("범위를 벗어난 숫자가 있으면 LottoException을 발생")
    void testOutOfRangeThrowsException() {
        List<Integer> numbersOutOfRange = Arrays.asList(0, 2, 3, 4, 5, 60); // 유효 범위를 벗어난 숫자 포함

        assertThrows(LottoException.class, () -> {
            LottoException.ensureNumbersWithinRange(numbersOutOfRange);
        });
    }
}