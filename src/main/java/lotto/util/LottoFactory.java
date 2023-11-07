package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoRule;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto createLotto(){
        List<Integer> lottoNumbers = getLottoNumbers();
        return new Lotto(getSortedNumber(lottoNumbers));
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.STANDARD.getStartNumber(),
                LottoRule.STANDARD.getLastNumber(),
                LottoRule.STANDARD.getLottoSize());
    }

    //정렬되어 있는지 확인하는건 Lotto 클래스 역활이라고 생각한다. Collections.sort()만 사용해서 생성하면 우테코 test가 List.of()로 만들었기 때문에 예외가 발생함
    private static List<Integer> getSortedNumber(List<Integer> numbers) {
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }

    public static Lotto createLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

}
