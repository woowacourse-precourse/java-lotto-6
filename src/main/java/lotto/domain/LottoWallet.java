package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.MIN_NUMBER;
import static lotto.constant.GeneralConstant.MAX_NUMBER;
import static lotto.constant.GeneralConstant.NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> myLotto = new ArrayList<Lotto>();

    public LottoWallet() {}

    public void addLotto(int number) {
        clearWallet();
        for (int i = ZERO; i < number; i++) {
            myLotto.add(new Lotto(pickNumbers()));
        }
    }

    private void clearWallet() {
        myLotto.clear();
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }

    public List<Lotto> getLottos() {
        return myLotto;
    }
}
