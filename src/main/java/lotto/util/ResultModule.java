package lotto.util;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class ResultModule {
    private static final Integer FIRST_PLACE = 5;
    private static final Integer SECOND_PLACE = 6;
    private static final Integer THIRD_PLACE = 7;
    private static final Integer FIFTH_PLACE = 9;

    public static void checkResult(List<Integer> result, Lotto lotto, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> summationLotto = sumLottoAndWinningNum(winningNum, lotto);

        int dubRemovedSize = getDubRemovedListSize(summationLotto);

        int resultIndex = checkResultIndex(dubRemovedSize, summationLotto.contains(bonusNum));

        addResult(result, resultIndex);
    }

    private static List<Integer> sumLottoAndWinningNum(List<Integer> winningNum, Lotto l) {
        List<Integer> lotto = l.getNumbers();
        lotto.addAll(winningNum);
        return lotto;
    }

    private static int getDubRemovedListSize(List<Integer> lotto) {
        return lotto.stream().distinct().toList().size();
    }

    private static int checkResultIndex(int dupRemovedSize, boolean isBonus) {
        dupRemovedSize = checkIndexChangeCondition(dupRemovedSize == SECOND_PLACE, dupRemovedSize, FIRST_PLACE);

        dupRemovedSize = checkIndexChangeCondition(dupRemovedSize == THIRD_PLACE && isBonus, dupRemovedSize, SECOND_PLACE);

        return dupRemovedSize;
    }

    private static int checkIndexChangeCondition(boolean changedCondition, int dupRemovedSize, int changedIndex) {
        if (changedCondition) {
            return changedIndex;
        }
        return dupRemovedSize;
    }

    private static void addResult(List<Integer> result, int dubRemovedSize) {
        if (dubRemovedSize <= FIFTH_PLACE) {
            result.set(dubRemovedSize, result.get(dubRemovedSize) + 1);
        }
    }

    public static List<Integer> formattingResult(List<Integer> result) {
        result.subList(5, 9);
        Collections.reverse(result);
        return result;
    }
}
