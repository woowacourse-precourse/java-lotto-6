package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.WinningNum;
import lotto.model.Result;
import lotto.model.Ticket;
import lotto.model.Lotto;
import java.util.List;

public class LottoControllerTest {
    @DisplayName("로또 번호와 당첨 번호 및 보너스 번호를 비교하여 당첨 여부와 종류를 판별 후 반환값 테스트")
    @Test
    void determineTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // SAME5_BONUS
        Lotto lotto2 = new Lotto(List.of(2, 4, 6, 8, 10, 12)); // SAME3
        Ticket ticket = new Ticket(List.of(lotto1, lotto2));
        WinningNum winningNum = new WinningNum(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;
        assertThat(LottoController.determine(ticket, winningNum, bonusNum))
                .isEqualTo(List.of(Result.SAME5_BONUS, Result.SAME3));
    }
}
