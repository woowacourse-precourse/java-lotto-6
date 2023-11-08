package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;

public class Result {
    private static final int THREE_HIT_PRICE = 5000;
    private static final int FOUR_HIT_PRICE = 50000;
    private static final int FIVE_HIT_PRICE = 1500000;
    private static final int FIVE_HIT_PLUS_BONUS_HIT_PRICE = 30000000;
    private static final int SIX_HIT_PRICE = 2000000000;

    private static int threeHit;
    private static int fourHit;
    private static int fiveHit;
    private static int fiveHitPlusBonusHit;
    private static int sixHit;
    private final Payment payment;
    private final List<Lotto> lottos;

    public Result(LottoMachine lottoMachine) {
        this.lottos = lottoMachine.getLottos();
        this.payment = lottoMachine.getPayment();
    }

    public void calculateResult(Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Integer> winningResults = lottos.stream().map(lotto -> lotto.countMatchingNumbers(winningNumbers))
                .toList();
        List<Boolean> bonusResults = lottos.stream().map(lotto -> lotto.containsNumber(bonusNumber.getNumber()))
                .toList();
        countResult(winningResults, bonusResults);
    }

    private void countResult(List<Integer> winningResults, List<Boolean> bonusResults) {
        resetCount();
        for (int i = 0; i < winningResults.size(); i++) {
            updateCount(winningResults.get(i),bonusResults.get(i));
        }
    }

    private void updateCount(Integer result, boolean bonusResult) {
        if (result == 3) {
            threeHit++;
        }
        if (result == 4) {
            fourHit++;
        }
        if (result == 5 && !bonusResult) {
            fiveHit++;
        }
        if (result == 5 && bonusResult) {
            fiveHitPlusBonusHit++;
        }
        if (result == 6) {
            sixHit++;
        }
    }

    private void resetCount() {
        threeHit = 0;
        fourHit = 0;
        fiveHit = 0;
        fiveHitPlusBonusHit = 0;
        sixHit = 0;
    }

    public double calculateWinningRate() {
        int price = calculatePrice();
        double winningRate = (double) price / payment.payment() * 100;
        return Math.round(winningRate * 10.0) / 10.0;
    }

    private int calculatePrice() {
        return threeHit * THREE_HIT_PRICE + fourHit * FOUR_HIT_PRICE + fiveHit * FIVE_HIT_PRICE
                + fiveHitPlusBonusHit * FIVE_HIT_PLUS_BONUS_HIT_PRICE + sixHit * SIX_HIT_PRICE;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + threeHit + "개\n"
                + "4개 일치 (50,000원) - " + fourHit + "개\n"
                + "5개 일치 (1,500,000원) - " + fiveHit + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveHitPlusBonusHit + "개\n"
                + "6개 일치 (2,000,000,000원) - " + sixHit + "개";
    }

}
