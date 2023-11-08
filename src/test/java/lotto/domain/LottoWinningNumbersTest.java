package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.BonusNumber;
import domain.LottoWinningNumbers;
import domain.WinningNumbers;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoWinningNumbersTest {
    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개를 넘지 못 하면 예외가 발생한다.")
    void createLottoWinningNumbersByLessSize() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5)), BonusNumber.createBonusNumber(7)));
    }

    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개를 넘으면 예외가 발생한다.")
    void createLottoWinningNumbersByOverSize() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)),
                        BonusNumber.createBonusNumber(8)));
    }

    @Test
    @DisplayName("중복된 로또 당첨 번호가 있다면 예외가 발생한다.")
    void createLottoWinningNumbersByDuplicateNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 5)),
                        BonusNumber.createBonusNumber(7)));
    }

    @ParameterizedTest
    @DisplayName("범위를 넘은 로또 당첨 번호가 있다면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoWinningNumbersByOutOfRange(int outOfRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, outOfRangeNumber)),
                        BonusNumber.createBonusNumber(7)));
    }

    @Test
    @DisplayName("보너스 번호가 로또 당첨 번호와 중복된다면 예외가 발생한다.")
    void createLottoWinningNumbersByDuplicateBonusNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(6)));
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위를 벗어났다면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoWinningNumbersByOutOfRangeBonusNumber(int outOfRangeNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(outOfRangeNumber)));
    }

    @Test
    @DisplayName("로또 당첨 번호 생성")
    void createLottoWinningNumbers() {
        assertDoesNotThrow(
                () -> LottoWinningNumbers.createWinningNumbers(
                        WinningNumbers.createWinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        BonusNumber.createBonusNumber(7)));
    }
}
