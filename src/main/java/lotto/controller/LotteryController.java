package lotto.controller;

import lotto.domain.IssueLottery;
import lotto.domain.JudgeWinningTickets;
import lotto.domain.Revenue;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryController {

    private InputView inputView;
    private IssueLottery issueLottery;
    private OutputView outputView;
    private JudgeWinningTickets judgeWinningTickets;
    private int payment;
    private int ticketCount;
    private Map<Integer, Integer> winningTicketsCount;
    private Revenue revenue;


    public void lottoGameStart() {
        inputView = new InputView();
        issueLottery = new IssueLottery();
        outputView = new OutputView();
        judgeWinningTickets = new JudgeWinningTickets();
        revenue = new Revenue();

        payment = inputView.askPayment();
        ticketCount = payment / 1000;
        List<List<Integer>> lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
        System.out.println();
        List<Integer> winningTicketNumbers = inputView.askWinningTicketNumbers();
        int bonusNumber = inputView.askBonusNumber();
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        outputView.printWinningLotteryTickets(winningTicketsCount);

        String revenueRate = revenue.calculateRevenue(payment, winningTicketsCount);
        outputView.printRevenueRate(revenueRate);
    }
}
