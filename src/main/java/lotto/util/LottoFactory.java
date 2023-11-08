package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoRule.STANDARD;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto createLotto(){
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(getSortedNumber(lottoNumbers));
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                STANDARD.getStartNumber(),
                STANDARD.getLastNumber(),
                STANDARD.getLottoSize());
    }

    private static List<Integer> getSortedNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto createLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

}
