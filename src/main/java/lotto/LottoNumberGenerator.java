package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * 로또 번호를 생성하는 클래스
 */
public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
