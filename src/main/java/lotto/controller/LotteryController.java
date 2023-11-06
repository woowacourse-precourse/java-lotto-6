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
        System.out.println("구입금액을 입력해 주세요.");
        payment = inputView.askPayment();
        ticketCount = payment / 1000;
        List<List<Integer>> lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningTicketNumbers = inputView.askWinningTicketNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputView.askBonusNumber();
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        outputView.printWinningLotteryTickets(winningTicketsCount);

        String revenueRate = revenue.calculateRevenue(payment, winningTicketsCount);
        outputView.printRevenueRate(revenueRate);
    }
}
