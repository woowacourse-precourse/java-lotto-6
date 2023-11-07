package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.core.BonusNumber;
import lotto.core.LotteryTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    static final LotteryTicket WINNING_LOTTERY_TICKET = new LotteryTicket(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호는 1부터 45까지의 숫자만 가능하다.")
    @Test
    void validateRange() {
        assertThatThrownBy(() -> new BonusNumber(WINNING_LOTTERY_TICKET, 100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(WINNING_LOTTERY_TICKET, 0))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertDoesNotThrow(() -> new BonusNumber(WINNING_LOTTERY_TICKET, 10));
    }

    @DisplayName("보너스 번호는 당첨 번호에 포함될 수 없다.")
    @Test
    void validateAlreadyExistsInWinningNumbers() {
        assertThatThrownBy(() -> new BonusNumber(WINNING_LOTTERY_TICKET, 4))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertDoesNotThrow(() -> new BonusNumber(WINNING_LOTTERY_TICKET, 45));
    }
}
