package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

// 로또 번호를 생성하기 위한 클래스
public class LottoNumberFactory implements NumberFactory {
    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
