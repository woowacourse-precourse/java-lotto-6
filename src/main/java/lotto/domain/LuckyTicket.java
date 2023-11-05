package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckyTicket {

    private final Lotto lotto;
    private final int bonusNumber;

    private LuckyTicket(
        final Lotto lotto,
        final int bonusNumber
    ) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LuckyTicket of(
        final Lotto lotto,
        final int bonusNumber
    ) {
        return new LuckyTicket(lotto, bonusNumber);
    }

    public LotteryResult matchWith(final User user) {
        List<Lotto> userTickets = user.getTickets();
        List<Integer> luckyNumbers = lotto.getNumbers();
        List<LotteryResult> results = new ArrayList<>();

        for (Lotto userTicket : userTickets) {
            List<Integer> numbers = userTicket.getNumbers();
            int numberCount = matchCountWithStream(luckyNumbers, numbers);
            int bonusCount = Collections.frequency(luckyNumbers, bonusNumber);
            results.add(makeLotteryResult(numberCount, bonusCount));
        }

        Collections.sort(results);
        return results.get(0);
    }

    private LotteryResult makeLotteryResult(int matchCount, int bonusCount) {

    }

    private int matchCountWithStream(List<Integer> luckyNumbers, List<Integer> userNumbers) {
        Long count = userNumbers.stream()
            .filter(luckyNumbers::contains)
            .count();
        return count.intValue();
    }

    public boolean hasBonusNumberInt(List<Integer> list) {
        return list.contains(bonusNumber);
    }


    public int matchCountWithTwoPointer(
        final List<Integer> userNumbers,
        final List<Integer> luckyNumbers
    ) {
        // 투포인터 알고리즘으로 이미 정렬되어 있는 두 리스트의 숫자 들을 비교한다.
        int userIndex = 0, luckyIndex = 0;
        int count = 0;

        while (userIndex < userNumbers.size() && luckyIndex < luckyNumbers.size()) {
            Integer userNumber = userNumbers.get(userIndex);
            Integer luckyNumber = luckyNumbers.get(luckyIndex);

            if (userNumber > luckyNumber) luckyIndex++;
            if (luckyNumber > userNumber) userIndex++;
            if (userNumber == luckyNumber) {
                luckyIndex++;
                userIndex++;
                count++;
            }
        }
        return count;
    }


}
