package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomLotto {

    private static final int LottoSize = 6;

    public List<Integer> randomLotto() {
        List<Integer> mixedLotto = new ArrayList<>();

        while(mixedLotto.size() < LottoSize) {
            int randomNumber = Randoms.pickNumberInRange(1,45);

            if(!mixedLotto.contains(randomNumber)) {
                mixedLotto.add(randomNumber);
            }
        }

        Collections.sort(mixedLotto);

        return mixedLotto;
    }
}
