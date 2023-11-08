package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    //상수(static final) 또는 클래스 변수
    Generator generator = new Generator();
    Printer printer = new Printer();

    //인스턴스 변수
    int matchingThreeNumbers;
    int matchingFourNumbers;
    int matchingFiveNumbers;
    int matchingFiveAndBonusNumbers;
    int matchingSixNumbers;

    //생성자

    //메서드
    public void calculateResult(List<Lotto> lotto, List<Integer> winningNumbers, int bonusNumber) {
        Printer printer = new Printer();
        for (int count = 0; count < lotto.size(); count++) {
            int matchingCount = compareWinningNumber(lotto.get(count),winningNumbers);

            if (matchingCount == 3) matchingThreeNumbers++;
            if (matchingCount == 4) matchingFourNumbers++;
            //5개가 일치한다면, 보너스 번호와 비교
            if (matchingCount == 5) {
                if(compareBonusNumber(lotto.get(count), bonusNumber)) matchingFiveAndBonusNumbers++;
            }
        }
        printer.showResult(matchingThreeNumbers, matchingFourNumbers, matchingFiveNumbers, matchingFiveAndBonusNumbers, matchingSixNumbers);
    }

    public int compareWinningNumber(Lotto lotteryNumbers, List<Integer> winningNumbers) {
        List<Integer> matchingNumbers = new ArrayList<>(winningNumbers);
        matchingNumbers.retainAll(lotteryNumbers.getLotteryNumbers());
        return matchingNumbers.size();
    }

    private boolean compareBonusNumber(Lotto lotteryNumbers, int bonusNumber) {
        // 보너스 번호와 일치하는지 비교하는 코드 구현
        if (lotteryNumbers.getLotteryNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public void calculateProfit() {
        long prizeMoney = calculatePrizeMoney();
        double profitPercent = ((double)prizeMoney/generator.getMoney()) * 100;
        printer.showProfit(profitPercent);
    }

    private long calculatePrizeMoney() {
        long prizeMoney = 0;
        return prizeMoney;
    }
}
