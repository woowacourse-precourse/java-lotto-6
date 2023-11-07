package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    //    private int bonusNumber;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static int countMatchingNumbers(List<Integer> winnerNumbers, List<Integer> ticketNumbers) {
        int count = 0;
        for (Integer number : ticketNumbers) {
            if (winnerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static void countWinningTickets(List<Integer> winnerNumbers, List<Lotto> tickets, int bonusNumber) {
        int[] count = new int[LottoRank.values().length];
        for (Lotto ticket : tickets) {
            int matchCount = countMatchingNumbers(winnerNumbers, ticket.getNumbers());
            boolean hasBonusNumber = ticket.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.getRank(matchCount, hasBonusNumber);
            if (rank != null) {
                count[rank.ordinal()]++;
            }
        }
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + count[rank.ordinal()] + "개");
        }
    }
}
