package lotto.util;

import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtils {
    public static List<Integer> convertStringToLottoNumberList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Lotto> generateLottoPaper(int howManyLotto) {
        List<Lotto> lottoPapers = new ArrayList<>();
        for (int i = 0; i < howManyLotto; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoPapers.add(new Lotto(randomNumbers));
        }
        return lottoPapers;
    }
}
