package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class GameUtil {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM = 6;

    //로또 생성
    public static Lotto createLotto(){
        List<Integer> createdLotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,MAX_LOTTO_NUM,LOTTO_NUM);

        Collections.sort(createdLotto);

        return new Lotto(createdLotto);
    }

    //당첨 결과 반환

    //총 수익률 반환
}
