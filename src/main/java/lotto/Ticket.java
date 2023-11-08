package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;

    Ticket() {
        this.numbers = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Ranking drawTicket(Lotto lotto, Bonus bonus) {
        int winningNumber = countWinningNumber(lotto);
        boolean hasBonus = hasBonusNumber(bonus);
        return Ranking.findRanking(winningNumber, hasBonus);
    }

    private int countWinningNumber(Lotto lotto) {
        int winningNumber = 0;
        for (int number : numbers) {
            if (lotto.hasNumber(number)) {
                winningNumber++;
            }
        }
        return winningNumber;
    }

    private boolean hasBonusNumber(Bonus bonus) {
        int bonusNumber = bonus.getNumber();
        return numbers.contains(bonusNumber);
    }
}