package lotto.controller;

import lotto.domain.IssueLottery;
import lotto.domain.JudgeWinningTickets;
import lotto.domain.Lotto;
import lotto.domain.Revenue;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LotteryController {

    private InputView inputView;
    private IssueLottery issueLottery;
    private OutputView outputView;
    private JudgeWinningTickets judgeWinningTickets;
    private int payment;
    private int ticketCount;
    private int bonusNumber;
    private String revenueRate;
    private Lotto lotto;
    private List<List<Integer>> lotteryTickets;
    private Map<Integer, Integer> winningTicketsCount;
    private List<Integer> winningTicketNumbers;
    private Revenue revenue;


    public LotteryController() {
        inputView = new InputView();
        issueLottery = new IssueLottery();
        outputView = new OutputView();
        judgeWinningTickets = new JudgeWinningTickets();
        revenue = new Revenue();
    }

    public void lottoGameStart() {
        System.out.println("구입금액을 입력해 주세요.");
        setPayment();
        setTickets();
        System.out.println("당첨 번호를 입력해 주세요.");
        setWinningTicket();
        System.out.println("보너스 번호를 입력해 주세요.");
        setBonusNumber();
        setWinningStatistics();
        setRevenue();
    }


    private void setPayment() {
        String input = inputView.askPayment();
        payment = Integer.parseInt(input);
        ticketCount = payment / 1000;
        System.out.println();
    }


    private void setTickets() {
        lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
        System.out.println();
    }

    private void setWinningTicket() {
        winningTicketNumbers = new ArrayList<Integer>();
        winningTicketNumbers = inputView.askWinningTicket();
        lotto = new Lotto(winningTicketNumbers);
        winningTicketNumbers = lotto.getNumbers();
        System.out.println();
    }

    private void setBonusNumber() {
        String input = inputView.askBonusNumber();
        bonusNumber = Integer.parseInt(input);
        System.out.println();
    }

    private void setRevenue() {
        revenueRate = revenue.calculateRevenue(payment, winningTicketsCount);
        outputView.printRevenueRate(revenueRate);
    }

    private void setWinningStatistics() {
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        outputView.printWinningStatistics(winningTicketsCount);
    }

}
