package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.CustomizedException;
import lotto.view.InputView;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        CustomizedException.winningNumbersQualification(numbers);
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
        showWinningRank(count);
        calculateRateOfReturn(tickets, count);
    }

    public static void calculateRateOfReturn(List<Lotto> tickets, int[] count) {
        int lottoPrize = tickets.size() * 1000;
        int prizeMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            prizeMoney += rank.getPrize() * count[rank.ordinal()];
        }
        double temporaryRateOfReturn = (double) prizeMoney / lottoPrize;
        double rateOfReturn = Math.round(temporaryRateOfReturn * 1000) / 10.0;
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void showWinningRank(int[] count) {
        System.out.println("당첨 통계\n" + "---");
        for (int i = LottoRank.values().length - 1; i >= 0; i--) {
            LottoRank rank = LottoRank.values()[i];
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedNumber = decimalFormat.format(rank.getPrize());
            if (rank.getPrize() == 30000000) {
                System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + formattedNumber + "원) - " + count[rank.ordinal()] + "개");
                continue;
            }
            System.out.println(rank.getMatchCount() + "개 일치 (" + formattedNumber + "원) - " + count[rank.ordinal()] + "개");
        }
    }

}
