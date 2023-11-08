package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.ConstantValues.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    // HashSet의 요소들을 정렬하여 Lotto로 만들어 반환
    public static Lotto makeLotto() {
        List<Integer> numbers = pickUniqueNumbersInRange(START_LOTTO_NUMBER.getValue(), END_LOTTO_NUMBER.getValue(),
            LOTTO_LENGTH.getValue());
//        numbers.sort(Integer::compareTo); 이러면 java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:261) 오류가 뜬다.
        // 그래서 다음과 같이 해야 한다.
        List<Integer> lottoNumbers = numbers.stream().sorted().toList();

        return new Lotto(numbers);
    }

}
