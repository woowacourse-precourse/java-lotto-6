package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Payment;

public class Result {
    private int threeHit;
    private int fourHit;
    private int fiveHit;
    private int fiveHitWithBonusNumber;
    private int sixHit;
    private Payment payment;
    private List<Lotto> lottos;

    public Result(LottoBuyer lottoBuyer) {
        this.lottos = lottoBuyer.getLottos();
        this.payment = lottoBuyer.getPayment();
    }

    public void calculateResult(Lotto winningNumbers, BonusNumber bonusNumber) {
        List<Integer> winningResults = lottos.stream().map(lotto -> lotto.countMatchingNumbers(winningNumbers)).toList();
        List<Boolean> bonusResults = lottos.stream().map(lotto -> lotto.containsNumber(bonusNumber.getNumber())).toList();
        System.out.println(bonusResults);
        countResult(winningResults,bonusResults);
    }

    private void countResult(List<Integer> winningResults, List<Boolean> bonusResults) {
        for (int i=0; i<winningResults.size(); i++) {
            int result = winningResults.get(i);
            if(result == 3) threeHit++;
            if(result == 4) fourHit++;
            if(result == 5 && !bonusResults.get(i)) fiveHit++;
            if(result == 5 && bonusResults.get(i)) fiveHitWithBonusNumber++;
            if(result == 6) sixHit++;
        }
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + threeHit + "개\n"
                + "4개 일치 (50,000원) - " + fourHit + "개\n"
                + "5개 일치 (1,500,000원) - " + fiveHit + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveHitWithBonusNumber + "개\n"
                + "6개 일치 (2,000,000,000원) - " + sixHit + "개\n";
    }

}
