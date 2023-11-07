package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoDrawMachineTest {
    @DisplayName("당첨 번호와 보너스 번호 확인")
    @Test
    public void 당첨_번호와_보너스_번호_저장() {
        // given
        List<Integer> winningNumbers = List.of(6, 5, 4, 3, 2, 1);
        int bonusNumber = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(winningNumbers, bonusNumber);

        // when
        List<Integer> drawnWinningNumbers = lottoDrawMachine.getWinningNumbers();
        int drawnBonusNumber = lottoDrawMachine.getBonusNumber();

        // then
        assertAll(
                "당첨 번호와 보너스 번호 확인",
                () -> assertEquals(drawnWinningNumbers, winningNumbers),
                () -> assertEquals(drawnBonusNumber, bonusNumber)
        );
    }
}