package lotto;

import lotto.controller.RankMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Config.*;
import static lotto.constant.WinningMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankMachineTest {
    @Test
    @DisplayName("5개의 랭크에 대해 정상 출력 되는지")
    void getWinningStatistics() {
        RankMachine rankMachine = new RankMachine(List.of(
                new Rank(RANK_FIFTH, REWARD_FIFTH, (ticket, winningTicket, bonusNumber) ->
                        ticket.countMatched(winningTicket) == 3),
                new Rank(RANK_FOURTH, REWARD_FOURTH, (ticket, winningTicket, bonusNumber) ->
                        ticket.countMatched(winningTicket) == 4),
                new Rank(RANK_THIRD, REWARD_THIRD, (ticket, winningTicket, bonusNumber) ->
                        ticket.countMatched(winningTicket) == 5 && !ticket.hasNumber(bonusNumber)),
                new Rank(RANK_SECOND, REWARD_SECOND, (ticket, winningTicket, bonusNumber) ->
                        ticket.countMatched(winningTicket) == 5 && ticket.hasNumber(bonusNumber)),
                new Rank(RANK_FIRST, REWARD_FIRST, (ticket, winningTicket, bonusNumber) ->
                        ticket.countMatched(winningTicket) == 6)
        ));
        Lotto winningTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        applySampleTickets(rankMachine, winningTicket, bonusNumber);

        System.out.println(rankMachine.getWinningStatistics());
        assertThat(rankMachine.getWinningStatistics())
                .contains("6개 일치 (2,000,000,000원) - 1개");
    }

    void applySampleTickets(RankMachine rankMachine, Lotto winningTicket, LottoNumber bonusNumber) {
        new ArrayList<>(List.of(
                // 6개 일치
                List.of(1, 2, 3, 4, 5, 6),

                // 5개 및 보너스 일치
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 6, 7),
                List.of(1, 2, 3, 5, 6, 7),

                // 5개 일치
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 9),

                // 4개 일치
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 8, 10),
                List.of(1, 2, 3, 4, 8, 11),
                List.of(1, 2, 3, 4, 8, 12),

                // 3개 일치
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 8, 9, 11),
                List.of(1, 2, 3, 8, 9, 12),
                List.of(1, 2, 3, 8, 9, 13),
                List.of(1, 2, 3, 8, 9, 14),
                List.of(1, 2, 3, 8, 9, 15),
                List.of(1, 2, 3, 8, 9, 16),

                // 2개 일치 - 꽝
                List.of(1, 2, 8, 9, 10, 11),
                List.of(1, 2, 8, 9, 10, 12),
                List.of(1, 2, 8, 9, 10, 13),
                List.of(1, 2, 8, 9, 10, 14),
                List.of(1, 2, 8, 9, 10, 15),

                // 1개 일치 - 꽝
                List.of(1, 8, 9, 10, 11, 12),
                List.of(1, 8, 9, 10, 11, 13),
                List.of(1, 8, 9, 10, 11, 14),
                List.of(1, 8, 9, 10, 11, 15),
                List.of(1, 8, 9, 10, 11, 16),
                List.of(1, 8, 9, 10, 11, 17),

                // 0개 일치 - 꽝
                List.of(8, 9, 10, 11, 12, 13)
        )).forEach(numbers -> rankMachine.applyTicket(new Lotto(numbers), winningTicket, bonusNumber));
    }
}
