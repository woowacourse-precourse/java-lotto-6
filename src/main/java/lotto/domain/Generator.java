package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Generator {

    public static List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> generateLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            randomNum.sort(Comparator.naturalOrder());
            generateLotto.add(new Lotto(randomNum));
            System.out.println(randomNum);
        }

        return generateLotto;
    }

    public static List<Integer> generateResult(List<Lotto> generateLotto, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> result = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        );

        for (Lotto l : generateLotto) {
            List<Integer> lotto = l.getNumbers();

            int correctNum = dubRemovedListSize(lotto, winningNum, lotto.contains(bonusNum));

            if (correctNum < 10) {
                result.set(correctNum, result.get(correctNum) + 1);
            }
        }

        return result;
    }

    private static int dubRemovedListSize(List<Integer> lotto, List<Integer> winningNum, boolean isBonus) {
        lotto.addAll(winningNum);
        int dupRemovedNum = lotto.stream().distinct().toList().size();

        return checkWinningNum(dupRemovedNum, isBonus);
    }

    private static int checkWinningNum(int dubRemovedNum, boolean isBonus) {
        int result = dubRemovedNum;

        if (dubRemovedNum == 6) {
            result = 5;
        }

        if (dubRemovedNum == 7 && isBonus) {
            result = 6;
        }

        return result;
    }
}
