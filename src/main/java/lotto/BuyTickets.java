package lotto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class BuyTickets {
    private Map<Long, List<Integer>> LotteryNumbers = new HashMap<>();

    public BuyTickets(String purchaseAmount) {
        int numberOfTickets = validate(purchaseAmount);
        LotteryNumbers = makeLotteryNumber(numberOfTickets);
        SystemIO.showTickets(LotteryNumbers);
    }

    private int validate(String stringPurchaseAmount) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
        return validateMultipleOfThousand(purchaseAmount);
    }

    private Map<Long, List<Integer>> makeLotteryNumber(int numberOfTickets) {
        Map<Long, List<Integer>> tickets = new HashMap<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lotteryNumbers = pickUniqueNumbersInRange(1, 45, 6);
            lotteryNumbers.sort(Comparator.naturalOrder());
            tickets.put(Long.valueOf(i), lotteryNumbers);
        }
        return tickets;
    }

    private int validateMultipleOfThousand(int purchaseAmount) {
        if (!(purchaseAmount % 1000 == 0)) {
            throw new IllegalStateException();
        }
        return purchaseAmount / 1000;
    }

    public Map<Long, List<Integer>> getLotteryNumbers() {
        return LotteryNumbers;
    }
}
