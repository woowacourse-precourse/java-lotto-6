package lotto.model;

import java.util.List;
import java.util.Set;

public class WinningStatistics {
    private int three;
    private int four;
    private int five;
    private int fiveWithBonus;
    private int six;

    public WinningStatistics() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.fiveWithBonus = 0;
        this.six = 0;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFiveWithBonus() {
        return fiveWithBonus;
    }

    public int getSix() {
        return six;
    }

    public void count(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        Set<Integer> numbers = winningNumbers.getNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            long count = lottoNumbers.stream()
                    .filter(numbers::contains)
                    .count();

            boolean bonusMatch = lottoNumbers.stream()
                    .anyMatch(num -> num == bonusNumber);

            if (count == 3) {
                three += 1;
            } else if (count == 4) {
                four += 1;
            } else if (count == 5) {
                if (bonusMatch) {
                    fiveWithBonus += 1;
                } else {
                    five += 1;
                }
            } else if (count == 6) {
                six += 1;
            }
        }
    }

    public void printResult(double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (1,500,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + five + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
