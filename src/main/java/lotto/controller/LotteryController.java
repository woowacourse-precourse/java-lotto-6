package lotto.controller;

import lotto.domain.IssueLottery;
import lotto.domain.JudgeWinningTickets;
import lotto.domain.Revenue;
import lotto.validation.ValidInput;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LotteryController {

    private InputView inputView;
    private IssueLottery issueLottery;
    private OutputView outputView;
    private JudgeWinningTickets judgeWinningTickets;
    private ValidInput validInput;
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
        validInput = new ValidInput();
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

    private String paymentInput;
    private String setValidPayment() {
        paymentInput = inputView.getUserInput();
        try {
            validInput.validPayment(paymentInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setValidPayment();
        }
        return paymentInput;
    }
    private void setPayment() {
        String input = setValidPayment();
        payment = Integer.parseInt(input);
        ticketCount = payment / 1000;
        System.out.println();
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
