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

            int correctCount = countCorrectNumber(lottoNumbers, winningNumber);
            boolean correctBonus = checkCorrectBonusNumber(lottoNumbers, bonusNumber);

            calculateRank(correctCount, correctBonus);
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

    private void calculateRank(int correctCount, boolean correctBonus) {
        if (correctCount == FIRST_CORRECT_CONDITION.getNumber()) {
            result.countRank(FIRST.getNumber());
            result.addIncome(FIRST_REWORD.getNumber());
            return;
        }
        if (correctCount == SECOND_CORRECT_CONDITION.getNumber() && correctBonus) {
            result.countRank(SECOND.getNumber());
            result.addIncome(SECOND_REWORD.getNumber());
            return;
        }
        if (correctCount == THIRD_CORRECT_CONDITION.getNumber()) {
            result.countRank(THIRD.getNumber());
            result.addIncome(THIRD_REWORD.getNumber());
            return;
        }
        if (correctCount == FOURTH_CORRECT_CONDITION.getNumber()) {
            result.countRank(FOURTH.getNumber());
            result.addIncome(FOURTH_REWORD.getNumber());
            return;
        }
        if (correctCount == FIFTH_CORRECT_CONDITION.getNumber()) {
            result.countRank(FIFTH.getNumber());
            result.addIncome(FIFTH_REWORD.getNumber());
        }
    }

    public double calculateIncomeRate(Result result, Payment payment) {
        return (result.getIncome() / payment.getPayment()) * 100;
    }
}
