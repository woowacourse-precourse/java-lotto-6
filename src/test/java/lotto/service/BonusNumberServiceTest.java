package lotto.service;

import lotto.constant.LottoConstant;
import lotto.exception.BonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberServiceTest {

    @Test
    @DisplayName("보너스 번호 형식 검증")
    void testEnsureValidFormat() {
        // 유효한 형식의 보너스 번호
        assertDoesNotThrow(() -> BonusNumberException.ensureValidFormat("10"));

        // 유효하지 않은 형식의 보너스 번호
        assertThrows(BonusNumberException.class,
                () -> BonusNumberException.ensureValidFormat("invalid"));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 중복 검증")
    void testEnsureNotDuplicatedWithWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        // 중복되지 않는 보너스 번호
        assertDoesNotThrow(() ->
                BonusNumberException.ensureNotDuplicatedWithWinningNumbers(winningNumbers, 7));

        // 당첨 번호와 중복되는 보너스 번호
        assertThrows(BonusNumberException.class,
                () -> BonusNumberException.ensureNotDuplicatedWithWinningNumbers(winningNumbers, 1));
    }

    @Test
    @DisplayName("보너스 번호 범위 검증")
    void testEnsureWithinValidRange() {
        // 유효 범위 내의 보너스 번호
        assertDoesNotThrow(() ->
                BonusNumberException.ensureWithinValidRange(LottoConstant.MIN_LOTTO_NUMBER));

        // 유효 범위를 벗어난 보너스 번호
        assertThrows(BonusNumberException.class,
                () -> BonusNumberException.ensureWithinValidRange(LottoConstant.MAX_LOTTO_NUMBER + 1));
    }
}