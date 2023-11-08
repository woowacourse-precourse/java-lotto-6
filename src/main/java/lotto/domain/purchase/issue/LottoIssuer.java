package lotto.domain.purchase.issue;

import static lotto.domain.policy.LottoNumberRangePolicy.END_RANGE;
import static lotto.domain.policy.LottoNumberRangePolicy.START_RANGE;
import static lotto.domain.policy.LottoSizePolicy.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public final class LottoIssuer {
    // 서로 다른 로또 번호가 생성될 때까지 호출
    public static Lotto issueLotto() {
        Lotto lotto = null;
        boolean sucess = false;
        while (!sucess) {
            List<Integer> radomNumbers = createRandomNumbers(START_RANGE.getRange(), END_RANGE.getRange(),
                    LOTTO_SIZE.getSize());
            try {
                lotto = new Lotto(radomNumbers);
                sucess = true;
            } catch (Exception ignored) {
            }
        }
        return lotto;
    }

    private static List<Integer> createRandomNumbers(int start, int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }
}
