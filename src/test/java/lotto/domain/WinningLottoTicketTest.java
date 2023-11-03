package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTicketTest {

    @Test
    @DisplayName("당첨 번호와 완전히 일치하는 경우 FIRST 등수 반환")
    void whenAllNumbersMatch_thenReturnFirstRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
        Lotto lotto = new Lotto(winningNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.FIRST, result);
    }

    @Test
    @DisplayName("보너스 번호가 일치하는 경우 SECOND 등수 반환")
    void whenFiveNumbersAndBonusNumberMatch_thenReturnSecondRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.SECOND, result);
    }
}