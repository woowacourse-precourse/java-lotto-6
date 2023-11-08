package lotto.Controller;

import lotto.Domain.Lotto;
import lotto.Domain.Prize;
import lotto.View.LottoInputView;
import lotto.View.LottoOutputView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final int LOTTO_TICKET_PRICE = 1000; // 로또 한 장의 가격

    private LottoInputView inputView;
    private LottoOutputView outputView;

    public LottoController(LottoInputView inputView, LottoOutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame() {
        int ticketCount = inputView.getUserInput() / LOTTO_TICKET_PRICE;
        List<Lotto> purchasedTickets = generateTickets(ticketCount);
        outputView.displayPurchasedTickets(purchasedTickets);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
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

        for (Lotto lotto : purchasedTickets) {
            int matchingNumbers = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            prizeCounts[matchingNumbers]++;

            if (matchingNumbers == 5 && hasBonusNumber) {
                prizeCounts[5]++;
            } else if (matchingNumbers == 6) {
                prizeCounts[6]++;
            }
        }

        results.add("당첨 통계");
        results.add("---");

        Prize[] prizeLevels = Prize.values();

        for (int i = 3; i <= 7; i++) {
            int count = prizeCounts[i];
            String message = prizeLevels[i - 3].getMessage() + count + "개";
            results.add(message);
        }

        double profitRate = ((calculateTotalPrize(prizeCounts) / (purchasedTickets.size() * 1000.0)) * 100);
        results.add("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
        return results;
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

    private int getPrizeAmount(int matchingNumbers) {
        int[] prizeAmounts = {0, 0, 0, 5000, 50000, 1500000, 30000000};
        if (matchingNumbers >= 0 && matchingNumbers <= 6) {
            return prizeAmounts[matchingNumbers];
        } else {
            return 0; // 유효하지 않은 인덱스에 대한 처리
        }
    }

    private int calculateTotalPrize(int[] prizeCounts) {
        int totalPrize = 0;
        for (int i = 3; i < prizeCounts.length; i++) {
            totalPrize += getPrizeAmount(i) * prizeCounts[i];
        }
        return totalPrize;
    }

}
