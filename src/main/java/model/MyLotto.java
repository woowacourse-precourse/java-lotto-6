package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MyLotto {
    private final List<Lotto> myLotto;

    public MyLotto(int purchaseAmount) {
        validate(purchaseAmount);
        myLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            Lotto lottoTicket = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            myLotto.add(lottoTicket);
        }
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닌 값을 입력되었습니다.");
        }
    }

    public List<Lotto> getMyLotto() {
        return Collections.unmodifiableList(this.myLotto);
    }

    public int size() {
        return this.myLotto.size();
    }
}
