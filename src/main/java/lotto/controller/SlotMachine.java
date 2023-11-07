package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static lotto.constant.Config.*;
import static lotto.constant.WinningMessage.*;

public class SlotMachine {

    public static void run() {
        // 구입 금액 요청
        BuyPrice price = requestUntilValidated(() -> BuyPrice.from(InputView.askBuyPrice()));
        int count = price.getBuyCount();
        Tickets tickets = Tickets.generate(count);
        OutputView.printBuyLottos(count, tickets.toString());

        // 당첨 번호 및 보너스 번호 요청
        Lotto winningTicket = requestUntilValidated(() -> Lotto.from(InputView.askWinningNumbers()));
        LottoNumber bonusNumber = requestUntilValidated(() -> LottoNumber.from(InputView.askBonusNumber()));

        // 당첨 통계 계산 및 출력
        RankMachine rankMachine = createRankMachine();
        rankMachine.applyTickets(tickets, winningTicket, bonusNumber);
        OutputView.printWinningStatistics(rankMachine.getWinningStatistics(), rankMachine.getRateOfReturn());
    }

    private static <T> T requestUntilValidated(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static RankMachine createRankMachine() {
        return new RankMachine(List.of(
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
    }
}
