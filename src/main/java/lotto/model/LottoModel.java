package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Constants;
import lotto.view.OutputView;

public class LottoModel {
    private List<List<Integer>> lottoTickets;
    private List<Integer> LottoNumbers;
    private int bonusNumber;
    private List<Integer> lucky;
    private int purchaseAmount;

    public LottoModel(List<List<Integer>> lottoTickets, List<Integer> LottoNumbers, int bonusNumber,
                      int purchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.LottoNumbers = LottoNumbers;
        this.bonusNumber = bonusNumber;
        this.purchaseAmount = purchaseAmount;
        this.lucky = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void calculatePrize() {
        for (int i = 0; i < lottoTickets.size(); i++) {
            int sameNumberCount = countSameNumbers(LottoNumbers, lottoTickets.get(i));

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
        OutputView.printResult(lucky, rate);
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
        sumPrize += Constants.SAME_3.getPrize() * lucky.get(0);
        sumPrize += Constants.SAME_4.getPrize() * lucky.get(1);
        sumPrize += Constants.SAME_5.getPrize() * lucky.get(2);
        sumPrize += Constants.SAME_5_BONUS.getPrize() * lucky.get(4);
        sumPrize += Constants.SAME_6.getPrize() * lucky.get(3);
        return sumPrize;
    }
}
