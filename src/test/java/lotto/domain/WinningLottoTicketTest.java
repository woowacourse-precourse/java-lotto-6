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

    @Test
    @DisplayName("당첨 번호 중 5개가 일치하고 보너스 번호가 일치하지 않는 경우 THIRD 등수 반환")
    void whenFiveNumbersMatchWithoutBonus_thenReturnThirdRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3, 4, 5, 8);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.THIRD, result);
    }

    @Test
    @DisplayName("당첨 번호와 하나도 일치하지 않는 경우 NONE 등수 반환")
    void whenNoNumbersMatch_thenReturnNoneRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 13);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.NONE, result);
    }

    @Test
    @DisplayName("당첨 번호 중 4개가 일치하는 경우 FOURTH 등수 반환")
    void whenFourNumbersMatch_thenReturnFourthRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3, 4, 7, 8);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 9);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.FOURTH, result);
    }

    @Test
    @DisplayName("당첨 번호 중 3개가 일치하는 경우 FIFTH 등수 반환")
    void whenThreeNumbersMatch_thenReturnFifthRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 10);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.FIFTH, result);
    }

    @Test
    @DisplayName("보너스 번호만 일치하는 경우 NONE 등수 반환")
    void whenOnlyBonusNumberMatches_thenReturnNoneRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.NONE, result);
    }

    @Test
    @DisplayName("당첨 번호 중 2개만 일치하는 경우 NONE 등수 반환")
    void whenTwoNumbersMatch_thenReturnNoneRank() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 7, 8, 9, 10);
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, 11);
        Lotto lotto = new Lotto(playerNumbers);

        Rank result = winningLottoTicket.match(lotto);

        assertEquals(Rank.NONE, result);
    }
}