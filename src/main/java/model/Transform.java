package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import utility.Lotto;

public class Transform {
    public List<Integer> generateRandomList() {
        List<Integer> randomList = null;
        while (randomList == null) {
            try {
                randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Lotto lotto = new Lotto(randomList);
            } catch (IllegalArgumentException e) {
                // 유효한 로또 번호를 생성할 수 없는 경우 다시 시도
            }
        }
        return randomList;
    }
}
