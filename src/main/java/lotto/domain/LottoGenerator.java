package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.generator.RandomStrategy;

public class LottoGenerator {
    public Lotto generateLotto(RandomStrategy randomGenerator) {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, Lotto.STANDARD_SIZE)) {
            // 수정,, strategy 움직인 이유가 없음.. 인자 제외해야 한다
            addAlternativeNumber(lotto, randomGenerator.generate(
                    () -> Randoms.pickNumberInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE))
            );
        }
        Collections.sort(lotto);
        return Lotto.from(lotto);
    }

    private void addAlternativeNumber(List<Integer> lotto, int randomNumber) {
        if (hasDuplicatedNumber(lotto, randomNumber)) {
            return;
        }
        lotto.add(randomNumber);
    }

    private boolean hasStandardSize(List<Integer> lotto, int standardSize) {
        return lotto.size() == standardSize;
    }

    private boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
        if (lotto.contains(generatedNumber)) {
            return true;
        }
        return false;
    }
}
