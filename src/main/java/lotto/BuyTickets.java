package lotto;

import lotto.ENUM.ExceptionCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BuyTickets {
    private Map<Integer, List<Integer>> LotteryNumbers = new HashMap<>();
    private String purchaseAmount;
    private int ticketAmounts;

    public BuyTickets() {
        while (true) {
            try {
                purchaseAmount = SystemIO.requestPurchaseAmount();
                ticketAmounts = validate(purchaseAmount);
                LotteryNumbers = makeLotteryNumber(ticketAmounts);
                SystemIO.showTickets(LotteryNumbers);
                break;
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validate(String stringPurchaseAmount) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(ExceptionCase.PURCHASE_AMOUNT_IS_NOT_INTEGER.getErrMessage());
        }
        return validateMultipleOfThousand(purchaseAmount);
    }

    private Map<Integer, List<Integer>> makeLotteryNumber(int numberOfTickets) {
        Map<Integer, List<Integer>> tickets = new HashMap<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lotteryNumbers = pickUniqueNumbersInRange(1, 45, 6);
            tickets.put(i, lotteryNumbers);
        }
        return tickets;
    }

    private int validateMultipleOfThousand(int purchaseAmount) {
        if (!(purchaseAmount % 1000 == 0)) {
            throw new IllegalStateException(ExceptionCase.NOT_SATISFY_CONDITION_OF_PURCHASE_AMOUNT.getErrMessage());
        }
        return purchaseAmount / 1000;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<Integer, List<Integer>> getLotteryNumbers() {
        return LotteryNumbers;
    }
}
