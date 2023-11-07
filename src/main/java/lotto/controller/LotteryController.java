package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.IssueLottery;
import lotto.domain.JudgeWinningTickets;
import lotto.domain.Lotto;
import lotto.domain.Revenue;
import lotto.validation.ValidInput;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
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
    private Lotto lotto;
    private List<List<Integer>> lotteryTickets;
    private Map<Integer, Integer> winningTicketsCount;
    private List<Integer> winningTicketNumbers;
    private Revenue revenue;
    private String paymentInput;
    private String winningTicketNumbersInput;
    private List<Integer> numbersForValidation;
    private List<String> tmp;
    private int numberForValidation;


    public LotteryController() {
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
        setWinningTicket();
        System.out.println("보너스 번호를 입력해 주세요.");
        setBonusNumber();
        setWinningStatistics();
        setRevenue();
    }

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


    private List<Integer> setValidWinningTicket() {
        numbersForValidation = new ArrayList<Integer>();
        winningTicketNumbersInput = Console.readLine().replaceAll("\\p{Z}", "");
        tmp = Arrays.asList(winningTicketNumbersInput.split(","));
        // lotto 클래스는 List<Integer> 타입을 인자값으로 갖기 때문에 리스트의 요소들이 모두 숫자인지를 검사한다.
        for (String x : tmp) {
            try {
                validInput.validNumber(x);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                setValidWinningTicket();
                break;
            }
            numberForValidation = Integer.parseInt(x);
            numbersForValidation.add(numberForValidation);
        }
        // lotto 클래스를 생성하여 유효한 로또 번호인지를 검사한다.
        try {
            lotto = new Lotto(numbersForValidation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setValidWinningTicket();
        }
        return numbersForValidation;
    }

    private void setWinningTicket() {
        winningTicketNumbers = new ArrayList<Integer>();
        winningTicketNumbers = setValidWinningTicket();
        lotto = new Lotto(winningTicketNumbers);
        winningTicketNumbers = lotto.getNumbers();
        System.out.println();
    }

    private String bonusNumberInput;

    private String setValidBonusNumber() {
        bonusNumberInput = inputView.getUserInput();
        try {
            validInput.validBonusNumber(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setValidBonusNumber();
        }
        return bonusNumberInput;
    }

    private void setBonusNumber() {
        String input = setValidBonusNumber();
        bonusNumber = Integer.parseInt(input);
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
