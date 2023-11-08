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
            InteractModule.printRandomNum(randomNum);
        }

        return generateLotto;
    }

    public static List<Integer> generateResult(List<Lotto> generateLotto, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> result = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        );

        for (Lotto lotto : generateLotto) {
            ResultModule.checkResult(result, lotto, winningNum, bonusNum);
        }

        return ResultModule.formattingResult(result);
    }
}
