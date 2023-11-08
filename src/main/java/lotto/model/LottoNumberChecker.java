package lotto.model;

import lotto.Winnings;
import lotto.message.ExceptionMessage;

import java.util.*;

public class LottoNumberChecker {
    private final List<Lotto> userNumberList;
    private final List<Integer> answerNumber;
    private final int bonusNumber;
    private static final int FIRST_COMMON_NUMBER = 6;
    private static final int SECOND_THIRD_COMMON_NUMBER = 5;
    private static final int FOURTH_COMMON_NUMBER = 4;
    private static final int FIFTH_COMMON_NUMBER = 3;

    public LottoNumberChecker(List<Integer> answerNumber, List<Lotto> userNumberList, int bonusNumber) {
        this.answerNumber = answerNumber;
        this.userNumberList = userNumberList;

        validateNumberRange(bonusNumber);
        checkDuplicate(answerNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getRankList() {

        List<Integer> rankList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (Lotto userNumber : userNumberList) {
            int rank = checkRank(userNumber);
            if (rank >= 1 && rank <= 5) {
                rankList.set(rank, rankList.get(rank) + 1);
            }
        }

        return rankList;
    }

    private int checkRank(Lotto userNumber) {

        int rank;
        int commonNumber = countCommonNumber(userNumber);

        if (commonNumber == FIRST_COMMON_NUMBER) {
            rank = Winnings.FIRST_PRIZE.gerRank();
            return rank;
        }

        if (commonNumber == SECOND_THIRD_COMMON_NUMBER) {
            rank = checkBonusNumber(userNumber, bonusNumber);
            return rank;
        }

        if (commonNumber == FOURTH_COMMON_NUMBER) {
            rank = Winnings.FOURTH_PRIZE.gerRank();
            return rank;
        }

        if (commonNumber == FIFTH_COMMON_NUMBER) {
            rank = Winnings.FIFTH_PRIZE.gerRank();
            return rank;
        }

        return 0;
    }

    private int checkBonusNumber(Lotto userNumber, int bonusNumber) {

        int rank = Winnings.THIRD_PRIZE.gerRank();

        if (userNumber.getNumbers().contains(bonusNumber)) {
            rank = Winnings.SECOND_PRIZE.gerRank();
        }

        return rank;
    }

    private int countCommonNumber(Lotto userNumber) {

        Set<Integer> set = new HashSet<>(userNumber.getNumbers());

        int count = 0;
        for (int number : answerNumber) {
            if (set.contains(number)) {
                count++;
                set.remove(number);
            }
        }

        return count;
    }

    private void validateNumberRange(int number) {

        if (!((number >= 1) && (number <= 45))) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_RANGE_NUMBER.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> answerNumber, int bonusNumber) {

        if (answerNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
