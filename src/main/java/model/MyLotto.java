package model;

import Constant.ErrorMessage;
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_UNITS.getMessage());
        }
    }

    public List<Lotto> getMyLotto() {
        return Collections.unmodifiableList(this.myLotto);
    }

    public int size() {
        return this.myLotto.size();
    }
}
