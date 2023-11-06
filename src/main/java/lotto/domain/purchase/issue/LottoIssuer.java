package lotto.domain.purchase.issue;

import static lotto.domain.purchase.issue.LottoNumberRangePolicy.END_RANGE;
import static lotto.domain.purchase.issue.LottoNumberRangePolicy.START_RANGE;
import static lotto.domain.purchase.issue.LottoSizePolicy.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public final class LottoIssuer {
    // 서로 다른 로또 번호가 생성될 때까지 호출
    public static Lotto issueLotto() {
        Lotto lotto = null;
        boolean sucess = false;
        while (!sucess) {
            try {
                List<Integer> radomNumbers = Randoms.pickUniqueNumbersInRange(START_RANGE.getRange(),
                        END_RANGE.getRange(),
                        LOTTO_SIZE.getSize());
                lotto = new Lotto(radomNumbers);
                sucess = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }
}
