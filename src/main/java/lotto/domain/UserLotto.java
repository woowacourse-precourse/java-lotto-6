package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private final List<Lotto> userLottoNumber;

    private final int purchase;

    public UserLotto(int purchase) {
        this.userLottoNumber = new ArrayList<>();
        this.purchase = purchase;

        setUserLottoNumber(purchase);
    }

    private void setUserLottoNumber(int purchase) {
        for (int i = 0; i < purchase; i++) {
            userLottoNumber.add(new Lotto(generatedNumbers()));
        }
    }

    private List<Integer> generatedNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getUserLottoNumber() {
        return userLottoNumber;
    }

    public int getPurchase() {
        return purchase;
    }
}
