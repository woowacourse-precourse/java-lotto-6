package lotto.service;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class WinningServiceTest {
    @DisplayName("당첨 번호를 예외없이 생성한다.")
    @Test
    void createWinningNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        // when
        WinningService winningService = new WinningService();
        // then
        assertThatCode(() -> {
            WinningNumber winningNumber = winningService.createWinningNumber(winningNumbers, bonusNumber);
        }).doesNotThrowAnyException();
    }
}
