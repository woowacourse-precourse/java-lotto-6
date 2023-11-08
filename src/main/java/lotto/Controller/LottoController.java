package lotto.Controller;

import lotto.Domain.EntireMessage;
import lotto.Domain.Lotto;
import lotto.Domain.Prize;
import lotto.View.LottoInputView;
import lotto.View.LottoOutputView;
import lotto.Util.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final int LOTTO_TICKET_PRICE = 1000; // 로또 한 장의 가격

    private LottoInputView inputView;
    private LottoOutputView outputView;

    public LottoController(LottoInputView inputView, LottoOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame() {
        int ticketCount = inputView.getUserInput() / LOTTO_TICKET_PRICE;
        List<Lotto> purchasedTickets = generateTickets(ticketCount);
        outputView.displayPurchasedTickets(purchasedTickets);

        List<Integer> winningNumbers = InputValidation.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        List<String> results = calculatePrizes(purchasedTickets, winningNumbers, bonusNumber);
        outputView.displayResults(results);
    }

    private List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> purchasedTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto randomLotto = Lotto.generateRandomLotto();
            purchasedTickets.add(randomLotto);
        }
        return purchasedTickets;
    }

    private List<String> calculatePrizes(List<Lotto> purchasedTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<String> results = new ArrayList<>();
        int[] prizeCounts = new int[8];

        calculatePrizeCounts(purchasedTickets, winningNumbers, bonusNumber, prizeCounts);

        results.add(EntireMessage.WINNING_STATISTICS_MSG);
        results.add(EntireMessage.DASH);

        Prize[] prizeLevels = Prize.values();

        generatePrizeMessages(prizeCounts, prizeLevels, results);

        double profitRate = calculateProfitRate(purchasedTickets.size(), prizeCounts);
        results.add(EntireMessage.STATISTICS_PREFIX_MSG + String.format("%.1f", profitRate) + EntireMessage.STATISTICS_SUFFIX_MSG);
        return results;
    }

    private void calculatePrizeCounts(List<Lotto> purchasedTickets, List<Integer> winningNumbers, int bonusNumber, int[] prizeCounts) {
        for (Lotto lotto : purchasedTickets) {
            int matchingNumbers = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            prizeCounts[matchingNumbers]++;
            updatePrizeCounts(prizeCounts, matchingNumbers, hasBonusNumber);
        }
    }
    private void updatePrizeCounts(int[] prizeCounts, int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && hasBonusNumber) {
            prizeCounts[5]++;
        } else if (matchingNumbers == 6) {
            prizeCounts[6]++;
        }
    }
    private void generatePrizeMessages(int[] prizeCounts, Prize[] prizeLevels, List<String> results) {
        for (int i = 3; i <= 7; i++) {
            int count = prizeCounts[i];
            String message = generatePrizeMessage(prizeLevels[i - 3], count);
            results.add(message);
        }
    }

    private String generatePrizeMessage(Prize prizeLevel, int count) {
        return prizeLevel.getMessage() + count + EntireMessage.COUNT_SUFFIX;
    }

    private double calculateProfitRate(int ticketCount, int[] prizeCounts) {
        return ((calculateTotalPrize(prizeCounts) / (ticketCount * 1000.0)) * 100);
    }
    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    private int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (int i = 3; i < prizeCounts.length; i++) {
            totalPrize += getPrizeAmount(i) * prizeCounts[i];
        }
        return totalPrize;
    }
    private int getPrizeAmount(int matchingNumbers) {
        int[] prizeAmounts = {0, 0, 0, 5000, 50000, 1500000, 30000000};
        return (matchingNumbers >= 0 && matchingNumbers <= 6) ? prizeAmounts[matchingNumbers] : 0;
    }
}
