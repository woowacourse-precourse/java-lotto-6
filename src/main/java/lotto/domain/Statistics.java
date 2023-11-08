package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Statistics {

    private static int first = 0;
    private static int second = 0;
    private static int third = 0;
    private static int fourth = 0;
    private static int fifth = 0;

    public void temp(Lottos lottos, Lotto lotto, BonusNumber bonusNumber) {
        List<Lotto> allLottos = lottos.getAllLottos();
        for (Lotto temp : allLottos) {
            int matchedNumber = countMatchingNumbers(temp.getNumbers(), lotto.getNumbers(), bonusNumber);
            countRank(matchedNumber, temp.getNumbers(), bonusNumber);
        }
    }

    private void checkBonusNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.stream()
                    .anyMatch(number -> Objects.equals(number, bonusNumber.getBonusNumber()))) {
            second++;
            third--;
        }
    }

    private void countRank(int matchedNumber, List<Integer> numbers, BonusNumber bonusNumber) {
        if(matchedNumber == 3) {
            fifth++;
        }
        if(matchedNumber == 4) {
            fourth++;
        }
        if(matchedNumber == 5) {
            third++;
            checkBonusNumber(numbers, bonusNumber);
        }
        if(matchedNumber == 6) {
            first++;
        }
    }

    private int countMatchingNumbers(List<Integer> numbers1, List<Integer> numbers2, BonusNumber bonusNumber) {
        return (int) numbers1.stream()
                .filter(numbers2::contains)
                .count();
    }

    public int calculateprofits() {
        int profits = 0;
        profits += (first * 2000000000 + second * 30000000 + third * 1500000 + fourth * 50000 + fifth * 5000);
        return profits;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + fifth + "개" + '\n' +
                "4개 일치 (50,000원) - " + fourth + "개" + '\n' +
                "5개 일치 (1,500,000원) - " + third + "개" + '\n' +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개" + '\n' +
                "6개 일치 (2,000,000,000원) - " + first + "개";
    }
}
