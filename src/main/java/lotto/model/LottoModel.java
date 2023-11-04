package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class LottoModel {
    private List<List<Integer>> lottoTickets;
    private List<Integer> userLottoNumbers;
    private int bonusNumber;
    private List<Integer> lucky;
    private int purchaseAmount;

    public LottoModel(List<List<Integer>> lottoTickets, List<Integer> userLottoNumbers, int bonusNumber,
                      int purchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.userLottoNumbers = userLottoNumbers;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
        this.lucky = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void calculatePrize() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            int sameNumberCount = countSameNumbers(userLottoNumbers, lottoTickets.get(i));

            if (sameNumberCount >= 3 && sameNumberCount != 5) {
                lucky.set(sameNumberCount - 3, lucky.get(sameNumberCount - 3) + 1);
            }
            if (sameNumberCount == 5 && !lottoTickets.get(i).contains(bonusNumber)) {
                lucky.set(2, lucky.get(2) + 1);
            }
            if (sameNumberCount == 5 && lottoTickets.get(i).contains(bonusNumber)) {
                lucky.set(3, lucky.get(4) + 1);
            }
        }
    }

    public void displayStatistics() {
        double sumPrize = calculateSumPrize();
        double beforeRate = sumPrize / purchaseAmount * 100;
        double rate = Math.round(beforeRate * 10.0) / 10.0;
        OutputView.displayStatistics(lucky, rate);
    }

    private int countSameNumbers(List<Integer> userNumbers, List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (ticketNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private double calculateSumPrize() {
        double sumPrize = 0;
        sumPrize += 5000 * lucky.get(0);
        sumPrize += 50000 * lucky.get(1);
        sumPrize += 1500000 * lucky.get(2);
        sumPrize += 30000000 * lucky.get(4);
        sumPrize += 2000000000 * lucky.get(3);
        return sumPrize;
    }
}
