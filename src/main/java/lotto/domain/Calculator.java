package lotto.domain;

import java.util.List;

public class Calculator {
    private static final int LOTTO_LENGTH = 6;

    private final Result result;
    private final Payment purchaseAmount;

    public Calculator(Payment purchaseAmount){
        this.result = new Result();
        this.purchaseAmount = purchaseAmount;
    }

    public Result calculateResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        for(int i=0; i<lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getLottoNumbers();
            int correctCount = 0;
            boolean correctBonus = false;
            for(int j=0; j<LOTTO_LENGTH; j++) {
                if (lottoNumbers.contains(winningNumber.get(j))){
                    correctCount++;
                }
                if(lottoNumbers.contains(bonusNumber)){
                    correctBonus = true;
                }
            }
            calculateRank(correctCount, correctBonus);
        }

        return result;
    }

    private void calculateRank(int correctCount, boolean correctBonus){
        if(correctCount == 6) {
            result.countRank(1);
            result.addIncome(2000000000);
            return;
        }
        if(correctCount == 5 && correctBonus) {
            result.countRank(2);
            result.addIncome(30000000);
            return;
        }
        if(correctCount == 5) {
            result.countRank(3);
            result.addIncome(1500000);
            return;
        }
        if(correctCount == 4) {
            result.countRank(4);
            result.addIncome(50000);
            return;
        }
        if(correctCount == 3) {
            result.countRank(5);
            result.addIncome(5000);
        }
    }

    public double calculateIncomeRate(Result result){
        return (result.getIncome() / purchaseAmount.getAmount()) * 100;
    }
}
