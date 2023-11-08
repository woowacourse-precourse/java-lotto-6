package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.Result;

import java.util.List;

import static lotto.utils.UtilNumber.*;

public class Calculator {
    private final Result result;

    public Calculator() {
        this.result = new Result();
    }

    public Result calculateResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lottoNumbers = lottos.get(i).getLottoNumbers();

            int correctNumber = countCorrectNumber(lottoNumbers, winningNumber);
            boolean correctBonus = checkCorrectBonusNumber(lottoNumbers, bonusNumber);

            int rank = calculateRank(correctNumber, correctBonus);
            result.countRank(rank);
            result.addIncome(calculateReword(rank));
        }

        return result;
    }

    private int countCorrectNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int correctNumber = 0;
        for (int j = 0; j < LOTTO_LENGTH.getNumber(); j++) {
            if (lottoNumbers.contains(winningNumbers.get(j))) {
                correctNumber++;
            }
        }

        return correctNumber;
    }

    private boolean checkCorrectBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private int calculateRank(int correctCount, boolean correctBonus) {
        if (correctCount == FIRST_CORRECT_CONDITION.getNumber()) return FIRST.getNumber();
        if (correctCount == SECOND_CORRECT_CONDITION.getNumber() && correctBonus) return SECOND.getNumber();
        if (correctCount == THIRD_CORRECT_CONDITION.getNumber()) return THIRD.getNumber();
        if (correctCount == FOURTH_CORRECT_CONDITION.getNumber()) return FOURTH.getNumber();
        if (correctCount == FIFTH_CORRECT_CONDITION.getNumber()) return FIFTH.getNumber();
        return 0;
    }

    private int calculateReword(int rank){
        if(rank == FIRST.getNumber()) return FIRST_REWORD.getNumber();
        if(rank == SECOND.getNumber()) return SECOND_REWORD.getNumber();
        if(rank == THIRD.getNumber()) return THIRD_REWORD.getNumber();
        if(rank == FOURTH.getNumber()) return FOURTH_REWORD.getNumber();
        if(rank == FIFTH.getNumber()) return FIFTH_REWORD.getNumber();
        return 0;
    }

    public double calculateIncomeRate(Result result, Payment payment) {
        return (result.getIncome() / payment.getPayment()) * 100;
    }
}
