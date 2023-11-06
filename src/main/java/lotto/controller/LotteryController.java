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
    private int bonusNumber;
    private String revenueRate;
    private List<List<Integer>> lotteryTickets;
    private Map<Integer, Integer> winningTicketsCount;
    private List<Integer> winningTicketNumbers;
    private Revenue revenue;

    public LotteryController()  {
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
        setWinningTickets();
        System.out.println("보너스 번호를 입력해 주세요.");
        setBonusNumber();
        winningTicketsCount = judgeWinningTickets.countWinningTickets(ticketCount, lotteryTickets, winningTicketNumbers, bonusNumber);
        outputView.printWinningLotteryTickets(winningTicketsCount);
        revenueRate = revenue.calculateRevenue(payment, winningTicketsCount);
        outputView.printRevenueRate(revenueRate);
    }


    private String setValidPayment() {
        String input = inputView.getUserInput();
        try {
            isValidPayment(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setValidPayment();
        }
        return input;
    }

    private void setPayment() {
        String input = setValidPayment();
        payment = Integer.parseInt(input);
        ticketCount = payment / 1000;
        System.out.println();
    }

    private void isValidPayment(String input) {
        if(!input.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
    }
    private void setTickets() {
        lotteryTickets = issueLottery.issueTickets(ticketCount);
        outputView.printLotteryTickets(ticketCount, lotteryTickets);
        System.out.println();
    }
    private void setWinningTickets() {
        winningTicketNumbers = inputView.askWinningTicketNumbers();
    }
    private void setBonusNumber() {
     bonusNumber = inputView.askBonusNumber();
    }




}
