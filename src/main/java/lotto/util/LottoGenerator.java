package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.util.generator.RandomStrategy;

public class LottoGenerator {
    public static Lotto generateLotto(RandomStrategy randomGenerator) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoService.MIN_VALUE,
                LottoService.MAX_VALUE, LottoService.STANDARD_SIZE);
        Collections.sort(randomNumbers);
        return Lotto.from(randomNumbers);
    }

    private static void addAlternativeNumber(List<Integer> lotto, int randomNumber) {
        if (hasDuplicatedNumber(lotto, randomNumber)) {
            return;
        }
        lotto.add(randomNumber);
    }

    private static boolean hasStandardSize(List<Integer> lotto, int standardSize) {
        return lotto.size() == standardSize;
    }

    private static boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
        if (lotto.contains(generatedNumber)) {
            return true;
        }
        return false;
    }
}
