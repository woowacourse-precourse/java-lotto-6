package lotto.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MarginCalculatorTest {

    @DisplayName("총 수익률을 정확하게 가져오는지 확인한다.")
    @Test
    void totalMarginTest() {
        // Arrange
        int money = 8000;
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(answer, 7);

        // Assert
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTicket lottoTicket = new LottoTicket(money);
                    WinningConfirm winningConfirm = new WinningConfirm(lottoTicket.getLottoTicket(), winningNumbers);
                    MarginCalculator marginCalculator = new MarginCalculator(money, winningConfirm);
                    assertThat(marginCalculator.getMargin()).isEqualTo(62.5);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
