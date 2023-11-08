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
        return new Lotto(numbers);
    }

}
