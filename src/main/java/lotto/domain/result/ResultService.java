package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultService {
    private Result result;
    private List<Grade> grades;
    private String earningRate;

    public ResultService(Result result) {
        this.result = result;
    }

    public void giveStatistics() {
        compare();
        calculateEarningRate();
        result.setGrades(grades);
        result.setEarningRate(earningRate);
    }

    public void compare() {
        List<Grade> grades = new ArrayList<>();
        for (Lotto lotto : result.getCustomer().getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int sameCount = countSameNumber(lottoNumbers, result.getWinningNumber().getWinningNumbers());
            boolean hasSameNumber = containSameNumber(lottoNumbers, result.getWinningNumber().getBonusNumber());
            Grade grade = giveGrade(sameCount, hasSameNumber);
            grades.add(grade);
        }
        this.grades = grades;
    }

    public int countSameNumber(List<Integer> numbers, List<Integer> winningNumbers) {
        int sameCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    public boolean containSameNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Grade giveGrade(int sameCount, boolean hasBonus) {
        if (sameCount == 6) {
            return Grade.FIRST;
        }
        if (sameCount == 5 && hasBonus) {
            return Grade.SECOND;
        }
        if (sameCount == 5) {
            return Grade.THIRD;
        }
        if (sameCount == 4) {
            return Grade.FOURTH;
        }
        if (sameCount == 3) {
            return Grade.FIFTH;
        }
        return Grade.NOTHING;
    }

    public void calculateEarningRate() {
        int price = result.getCustomer().getPrice();
        long totalPrize = sumAllPrize(grades);
        earningRate = calculatePercentage(price, totalPrize);
    }

    public long sumAllPrize(List<Grade> grades) {
        long sum = 0L;
        for (Grade grade : grades) {
            sum = sum + grade.getPrize();
        }
        return sum;
    }

    public String calculatePercentage(int price, long prize) {
        float prizeF = (float) prize;
        float priceF = (float) price;
        float percentage = prizeF / priceF * 100f;
        String result = String.format("%,.1f", percentage);
        return result;
    }

    public int countGrade(Grade grade) {
        return Collections.frequency(grades, grade);
    }
}
